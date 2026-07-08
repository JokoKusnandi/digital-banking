package com.banking.common.logging;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class LoggerUtil {

    private LoggerUtil(){}

    public static void info(String message){

        log.info(message);

    }

    public static void error(String message){

        log.error(message);

    }

    public static void warn(String message){

        log.warn(message);

    }

}
