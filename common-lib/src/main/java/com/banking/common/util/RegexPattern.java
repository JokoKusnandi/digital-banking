package com.banking.common.util;

public final class RegexPattern {

    private RegexPattern(){}

    /**
     * Indonesia Mobile Number
     * 08xxxxxxxxxx
     * +628xxxxxxxxxx
     * 628xxxxxxxxxx
     */
    public static final String PHONE ="^(\\+62|62|0)8[1-9][0-9]{7,11}$";

    /**
     * Indonesia NIK
     */
    public static final String NIK ="^\\d{16}$";

    /**
     * Account Number
     */
    public static final String ACCOUNT_NUMBER ="^\\d{10,20}$";

    /**
     * ISO Currency
     */
    public static final String CURRENCY ="^[A-Z]{3}$";

}
