package com.banking.common.security.permission;

import java.util.List;

public final class Authorities {

    private Authorities(){}

    public static List<String> customer(){

        return List.of(

                "CUSTOMER_READ",

                "ACCOUNT_READ",

                "TRANSFER",

                "PAYMENT"

        );

    }

    public static List<String> admin(){

        return List.of(

                "CUSTOMER_READ",

                "CUSTOMER_WRITE",

                "ACCOUNT_READ",

                "ACCOUNT_WRITE",

                "TRANSFER",

                "PAYMENT",

                "ADMIN"

        );

    }

}
