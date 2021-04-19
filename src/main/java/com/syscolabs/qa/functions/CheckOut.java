package com.syscolabs.qa.functions;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolabs.qa.common.Constants;
import com.syscolabs.qa.pages.CheckOutPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CheckOut {
    public SyscoLabUI syscoLabUI = new SyscoLabUI();
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
        Assert.assertTrue(checkOutPage.isInvalidCreditCardError(),"Credit card Mandatory validation error message is not displayed");
        System.out.printf("Credit card Mandatory validation error message is displayed");
 /*       checkOutPage.enterInValidCardNumber();
        syscoLabUI.sleep(5);
        checkOutPage.clickPlaceHolder();
        syscoLabUI.sleep(5);
        Assert.assertTrue(checkOutPage.isInvalidCreditCardError(),"Credit card field validation error message is not displayed");
        System.out.printf("Credit card field validation error message is displayed");
*/
    }

    public void validateExpireDateFields(){
        checkOutPage.enterValidCardNumber();
        checkOutPage.clickPlaceHolder();
        Assert.assertTrue(checkOutPage.isInvalidExpireDateError(),"Expiredate Mandatory validation error message is not displayed");
        System.out.printf("Expiredate Mandatory validation error message is displayed");
/*        checkOutPage.enterInValidExpireDate();
        syscoLabUI.sleep(5);
        checkOutPage.clickPlaceHolder();
        syscoLabUI.sleep(5);
        Assert.assertTrue(checkOutPage.isInvalidExpireDateError(),"Expiredate field validation error message is not displayed");
        System.out.printf("Expiredate field validation error message is displayed");
 */
    }

    public void validateCCVFields(){

        checkOutPage.enterValidCardNumber();
        checkOutPage.enterValidExpireDate();
        checkOutPage.clickPlaceHolder();
        softAssert.assertTrue(checkOutPage.isInvalidCCVError(),"CCV Mandatory validation error message is not displayed");
        System.out.printf("CCV Mandatory validation error message is displayed");
/*
        checkOutPage.enterInValidCCV();
        syscoLabUI.sleep(5);
        checkOutPage.clickPlaceHolder();
        syscoLabUI.sleep(5);
        softAssert.assertTrue(checkOutPage.isInvalidCCVError(),"CCV field validation error message is not displayed");
        System.out.printf("CCV field validation error message is displayed");
  */    softAssert.assertAll();


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
