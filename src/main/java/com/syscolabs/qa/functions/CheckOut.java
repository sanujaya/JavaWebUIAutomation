package com.syscolabs.qa.functions;

import com.syscolabs.qa.common.Constants;
import com.syscolabs.qa.pages.CheckOutPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CheckOut {
    public CheckOutPage checkOutPage = new CheckOutPage();
    public SoftAssert softAssert = new SoftAssert();

    public void verifyFirstAndLastName(){
        Assert.assertEquals(checkOutPage.getFirstName(), Constants.FIRST_NAME, "First name is incorrect");
        Assert.assertEquals(checkOutPage.getLastName(), Constants.LAST_NAME, "Last name is incorrect");

    }

    public void mandatoryFieldalidation(){
        checkOutPage.clickContinue();
        Assert.assertTrue(checkOutPage.isAddressErrorMessageDisplayed(),"Address is not Validated");
        Assert.assertTrue(checkOutPage.isSuburbErrorMessageDisplayed(),"Suburb is not Validated");
        Assert.assertTrue(checkOutPage.isStateErrorMessageDisplayed(),"State is not Validated");
        Assert.assertTrue(checkOutPage.isPostCodeErrorMessageDisplayed(),"PostCode is not Validated");
        Assert.assertTrue(checkOutPage.isPhoneNumberErrorMessageDisplayed(),"Phonenumber is not Validated");

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


    public void validateCreditCardNUmberFields(){
        checkOutPage.clickPlaceHolder();
        Assert.assertTrue(checkOutPage.isInvalidCreditCardError(),"Credit card is not Mandatory validation");

    }

    public void validateExpireDateFields(){
        checkOutPage.enterValidCardNumber();
        checkOutPage.clickPlaceHolder();
        Assert.assertTrue(checkOutPage.isInvalidExpireDateError(),"Expiredate is not Mandatory validation");

    }

    public void validateCCVFields(){

        checkOutPage.enterValidCardNumber();
        checkOutPage.enterValidExpireDate();
        checkOutPage.clickPlaceHolder();
        softAssert.assertTrue(checkOutPage.isInvalidCCVError(),"CCV is not Mandatory validation");

        softAssert.assertAll();


    }

    public void enterValidCCdata(){
        checkOutPage.enterValidCardNumber();
        System.out.println("enterValidCardNumber");
        checkOutPage.enterValidExpireDate();
        System.out.println("enterValidExpireDate");
        checkOutPage.enterValidCCV();
        System.out.println("enterValidCCV");
    }










}
