package com.banking.common.logging;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
public class CorrelationIdFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain)
            throws ServletException, IOException {

        String correlationId=request.getHeader(
                LoggingConstants.CORRELATION_ID);

        if(correlationId==null){

            correlationId= UUID.randomUUID().toString();

        }

        response.setHeader(
                LoggingConstants.CORRELATION_ID,
                correlationId);

        MdcUtil.put(
                LoggingConstants.CORRELATION_ID,
                correlationId);

        chain.doFilter(request,response);

        MdcUtil.clear();

    }

}