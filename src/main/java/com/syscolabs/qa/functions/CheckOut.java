package com.syscolabs.qa.functions;

import com.syscolabs.qa.pages.BasePage;
import com.syscolabs.qa.pages.CheckOutPage;

public class CheckOut {

    public CheckOutPage checkOutPage = new CheckOutPage();


    public String getFirstName(){
        return checkOutPage.returnFirstName();
    }
    public String getLastName(){
        return checkOutPage.returnLastName();
    }

    public String getAddressErrorMessage(){
        return checkOutPage.getAddressFieldErrorMessage();
    }

    public String getSuburbErrorMessage(){
        return checkOutPage.getSuburbFieldErrorMessage();
    }

    public String getStateErrorMessage(){
        return checkOutPage.getStateFieldErrorMessage();
    }

    public String getPostCodeErrorMessage(){
        return checkOutPage.getPostCodeFieldErrorMessage();
    }

    public String getPhoneNumberErrorMessage(){
        return checkOutPage.getPhoneNumberFieldErrorMessage();
    }

    public void addMandatoryFields(){
        checkOutPage.enterAddress();
        checkOutPage.enterPostCode();
        checkOutPage.enterTeleohoneNumber();
    }

    public void selectDeliveryMethod(){
        checkOutPage.selectDeliveryOption();
    }

    public void clickContinueButton(){
        checkOutPage.clickContinue();
    }

    public void selectPaymentOption(){
        checkOutPage.selectCreditCardOption();
    }


    public String validateCreditCardNUmberFields(){

        checkOutPage.clickPlaceHolder();
        //System.out.printf("Credit card Mandatory validation error message is displayed");
        return checkOutPage.isInvalidCreditCardError();
    }

    public String validateExpireDateFields(){
        checkOutPage.enterValidCardNumber();
        checkOutPage.clickPlaceHolder();
        //System.out.printf("Expiredate Mandatory validation error message is displayed");
        return checkOutPage.isInvalidExpireDateError();
    }

    public String validateCCVFields(){

        checkOutPage.enterValidCardNumber();
        checkOutPage.enterValidExpireDate();
        checkOutPage.clickPlaceHolder();
        //System.out.printf("CCV Mandatory validation error message is displayed");
        return checkOutPage.isInvalidCCVError();


    }

    public void enterValidCCdata(){
        checkOutPage.enterValidCardNumber();
        //System.out.println("enterValidCardNumber");
        checkOutPage.enterValidExpireDate();
        //System.out.println("enterValidExpireDate");
        checkOutPage.enterValidCCV();
        //System.out.println("enterValidCCV");
    }










}
