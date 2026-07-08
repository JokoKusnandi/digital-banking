package com.banking.common.aspect;

import com.sun.jdi.request.DuplicateRequestException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class IdempotencyAspect {
    private final RedisTemplate<String, String> redisTemplate;
    private static final String IDEMPOTENCY_KEY_PREFIX = "idempotency:";
    private static final long TTL_HOURS = 24;

    @Around("@annotation(com.banking.common.annotation.Idempotent)")
    public Object handleIdempotency(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return joinPoint.proceed();
        }
        HttpServletRequest request = attributes.getRequest();
        String idempotencyKey = request.getHeader("X-Idempotency-Key");
        if (idempotencyKey == null || idempotencyKey.isEmpty()) {
            idempotencyKey = generateIdempotencyKey(request);
        }

        String redisKey = IDEMPOTENCY_KEY_PREFIX + idempotencyKey;

        Boolean isAbsent = redisTemplate.opsForValue().setIfAbsent(redisKey,"PROCESSED",TTL_HOURS, TimeUnit.HOURS);

        if(Boolean.FALSE.equals(isAbsent)){
            log.warn("Duplicate request detected with key : {}", idempotencyKey);
            throw new DuplicateRequestException("Duplicate request detected. Please use a unique X-Idempotency-Key header.");
        }

        try{
            return joinPoint.proceed();
        } catch (Exception e) {
            redisTemplate.delete(redisKey);
            throw e;
        }
    }
    private String generateIdempotencyKey(HttpServletRequest request){
        String method = request.getMethod();
        String ip = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");
        String deviceId = request.getHeader("Device-Id");
        String deviceToken = request.getHeader("Device-Token");
        String uri = request.getRequestURI();
        String body = ""; //could extract request body hash
        return UUID.randomUUID().toString();
    }
}

