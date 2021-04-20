package com.syscolabs.qa.tests;

import com.syscolabs.qa.common.Constants;
import com.syscolabs.qa.functions.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyCheckOutProcess {
    public Home home = new Home();
    public Login login = new Login();
    public MyAccount myAccount = new MyAccount();
    public AddToCart addToCart = new AddToCart();
    public CheckOut checkOut = new CheckOut();

    @BeforeMethod
    public void loadHomePage() throws InterruptedException {
        home.loadHomePage();
        home.navigateToLoginPage();
        login.loginButtonAvailability();
        login.logIntoAccount(Constants.VALID_EMAIL, Constants.VALID_PASSWORD);
        Thread.sleep(1000);
        myAccount.isUserNameDisplayed();
        Thread.sleep(1000);
        myAccount.removeShoppingCartItems();
        addToCart.addItemsToCart();
        addToCart.openShoppingCart();
        addToCart.ClickViewCart();
        addToCart.verifyProductNameAndPrice();
        addToCart.clickSecureCheckOut();


    }

    @Test(description = "Checkout process verification")
    public void verifyCheckOutProcess() throws InterruptedException {
        checkOut.verifyFirstAndLastName();
        //System.out.println("verifyFirstAndLastName");
        checkOut.mandatoryFieldalidation();
        //System.out.println("mandatoryFieldalidation");
        checkOut.addMandatoryFields();
        //System.out.println("addMandatoryFields");
        checkOut.selectDeliveryMethod();
        //System.out.println("selectDeliveryMethod");
        checkOut.clickContinueButton();
        //System.out.println("clickContinueButton");
        checkOut.selectPaymentOption();
        //System.out.println("selectPaymentOption");
        checkOut.validateCreditCardNUmberFields();
        //System.out.println("validateCreditCardNUmberFields");
        checkOut.validateExpireDateFields();
        //System.out.println("validateExpireDateFields");
        checkOut.validateCCVFields();
        //System.out.println("validateCCVFields");
        checkOut.enterValidCCdata();
        //System.out.println("enterValidCCdata");



    }

    @AfterMethod
    public void closeBrowser(){
        home.exitBrowser();
    }



}
