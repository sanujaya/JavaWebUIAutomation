package com.syscolabs.qa.tests;

import com.syscolabs.qa.common.Constants;
import com.syscolabs.qa.functions.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVerifyCheckOutProcess extends TestBase{

    @Test(description = "Checkout process verification")
    public void verifyCheckOutProcess() throws InterruptedException {


        home.navigateToLoginPage();
        softAssert.assertTrue(login.getLoginButtonAvailability(),"Login button Available");
        login.logIntoAccount(Constants.VALID_EMAIL, Constants.VALID_PASSWORD);
        softAssert.assertEquals(myAccount.getUserName(), Constants.USER_NAME,"Username is incorrect");
        myAccount.removeShoppingCartItems();
        addToCart.addItemsToCart();
        addToCart.openShoppingCart();
        addToCart.clickViewCart();
        softAssert.assertTrue(addToCart.getProductName(),"Product Name is incorrect");
        softAssert.assertTrue(addToCart.getProductPrice(), "Product Price is incorrect");
        addToCart.clickSecureCheckOut();
        softAssert.assertEquals(checkOut.getFirstName(), Constants.FIRST_NAME, "First name is incorrect");
        softAssert.assertEquals(checkOut.getLastName(), Constants.LAST_NAME, "Last name is incorrect");
        checkOut.clickContinueButton();
        softAssert.assertEquals(checkOut.getAddressErrorMessage(),Constants.DELIVERY_FIELD_ERRORMESSAGE);
        softAssert.assertEquals(checkOut.getSuburbErrorMessage(),Constants.DELIVERY_FIELD_ERRORMESSAGE);
        softAssert.assertEquals(checkOut.getStateErrorMessage(),Constants.DELIVERY_FIELD_ERRORMESSAGE);
        softAssert.assertEquals(checkOut.getPostCodeErrorMessage(),Constants.DELIVERY_FIELD_ERRORMESSAGE);
        softAssert.assertEquals(checkOut.getPhoneNumberErrorMessage(),Constants.DELIVERY_FIELD_ERRORMESSAGE);
        checkOut.addMandatoryFields();
        checkOut.selectDeliveryMethod();
        checkOut.clickContinueButton();
        checkOut.selectPaymentOption();
        softAssert.assertEquals(checkOut.validateCreditCardNUmberFields(),Constants.CREDIT_CARD_NUMBER_ERROR);
        softAssert.assertEquals(checkOut.validateExpireDateFields(),Constants.EMAIL_ERRORMESSAGE);
        softAssert.assertEquals(checkOut.validateCCVFields(),Constants.CCV_NUMBER_ERROR);
        checkOut.enterValidCCdata();

        softAssert.assertAll();


    }

}
