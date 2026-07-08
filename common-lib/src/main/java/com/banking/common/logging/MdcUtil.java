package com.banking.common.logging;

import org.slf4j.MDC;

public final class MdcUtil {

    private MdcUtil(){}

    public static void put(String key,String value){

        MDC.put(key,value);

    }

    public static String get(String key){

        return MDC.get(key);

    }

    public static void clear(){

        MDC.clear();

    }

}
