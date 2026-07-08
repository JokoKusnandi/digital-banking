package com.banking.common.util;

import java.util.regex.Pattern;

public final class ValidationUtil {

    private ValidationUtil(){}

    public static boolean match(String regex,String value){

        if(value==null)
            return false;

        return Pattern.matches(regex,value);

    }

}
