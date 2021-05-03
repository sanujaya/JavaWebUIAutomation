package com.syscolabs.qa.common;

public class Constants {
/*
    public static final String CHROME_DRIVER_URL = "JavaWebUIAutomation/src/main/resources/chrome_driver/windows/chromedriver.exe";
    public static final String WEB_URL ="https://www.theathletesfoot.com.au/";
    public static final String VALID_EMAIL = "hasithaofficial@gmail.com";
    public static final String VALID_PASSWORD = "Abc123$$";
    public static final String INVALID_EMAIL = "williamjacob802.com";
    public static final String INVALID_PASSWORD = "1234";
    public static final String USER_NAME ="Hasitha Sanujaya";
    public static final String FIRST_NAME ="Hasitha";
    public static final String LAST_NAME ="Sanujaya";
    public static final String SHOPPING_CART_EMPTY ="counter qty empty";
    public static final String SHOPPING_CART_NOT_EMPTY ="counter qty";
    public final static String ADDRESS="61  Grandis Road";
    public final static String POSTCODE="2000";
    public final static String PHONE_NUMBER="075456123";
    public final static String VALID_CREDIT_CARD ="5500 0000 0000 0004";
    public final static String INVALID_CREDIT_CARD ="5500";
    public final static String VALID_EXPIRE_DATE ="10/2024";
    public final static String INVALID_EXPIRE_DATE ="10/2030";
    public final static String VALID_CCV_CODE ="123";
    public final static String INVALID_CCV_CODE ="1";
    public final static String CREDIT_CARD_NUMBER_ERROR = "Please, enter valid Credit Card Number";
    public final static String EXPIRATION_DATE_ERROR = "Please, enter valid Expiration Date";
    public final static String CCV_NUMBER_ERROR = "Please, enter valid Card Verification Number";


 */
    public static final String CHROME_DRIVER_URL = SUTAFProperties.getProperty("driver.url");
    public static final String WEB_URL = SUTAFProperties.getProperty("website.url");
    public static final String VALID_EMAIL = SUTAFProperties.getProperty("valid.email");
    public static final String VALID_PASSWORD = SUTAFProperties.getProperty("valid.password");
    public static final String INVALID_EMAIL = SUTAFProperties.getProperty("invalid.email");
    public static final String INVALID_PASSWORD = SUTAFProperties.getProperty("invalid.password");
    public static final String EMAIL_ERRORMESSAGE = SUTAFProperties.getProperty("email.errormessage");
    public static final String PASSWORD_ERRORMESSAGE = SUTAFProperties.getProperty("password.errormessage");
    public static final String USER_NAME = SUTAFProperties.getProperty("user_name");
    public static final String FIRST_NAME = SUTAFProperties.getProperty("first.name");
    public static final String LAST_NAME = SUTAFProperties.getProperty("last.name");
    public static final String SHOPPING_CART_EMPTY = SUTAFProperties.getProperty("shooping.cart.empty.message");;
    public static final String SHOPPING_CART_NOT_EMPTY = SUTAFProperties.getProperty("shooping.cart.notempty.message");
    public final static String DELIVERY_FIELD_ERRORMESSAGE= SUTAFProperties.getProperty("deliveryfield.errormessage");
    public final static String ADDRESS= SUTAFProperties.getProperty("address");
    public final static String POSTCODE= SUTAFProperties.getProperty("postcode");
    public final static String PHONE_NUMBER= SUTAFProperties.getProperty("phonenumber");
    public final static String VALID_CREDIT_CARD = SUTAFProperties.getProperty("valid.credit.card");
    public final static String INVALID_CREDIT_CARD = SUTAFProperties.getProperty("invalid.credit.card");
    public final static String VALID_EXPIRE_DATE = SUTAFProperties.getProperty("valid.expire.date");
    public final static String INVALID_EXPIRE_DATE = SUTAFProperties.getProperty("invalid.expire.date");
    public final static String VALID_CCV_CODE = SUTAFProperties.getProperty("valid.ccv.code");
    public final static String INVALID_CCV_CODE = SUTAFProperties.getProperty("invalid.ccv.code");
    public final static String CREDIT_CARD_NUMBER_ERROR = SUTAFProperties.getProperty("creditcardnumber.error.message");
    public final static String EXPIRATION_DATE_ERROR = SUTAFProperties.getProperty("expiredate.error.message");
    public final static String CCV_NUMBER_ERROR = SUTAFProperties.getProperty("ccvnumber.error.message");

    public static final boolean IS_LOGGER_ENABLED = Boolean.parseBoolean(SUTAFProperties.getProperty("logger"));;
}