package com.syscolabs.qa.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolabs.qa.common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckOutPage {
    SyscoLabUI syscoLabUI = new SyscoLabUI();
    public By lblFirstName = By.xpath("//div[@name='shippingAddress.firstname']//div//input");
    public By lblLastName = By.xpath("//div[@name='shippingAddress.lastname']//div//input");
    public By btnContinue = By.xpath("//button[@title='Continue']");
    public By lblAddressErrorMessage = By.xpath("//input[@name='street[0]']//..//div[starts-with(@id,'error')]//span");
    public By lblSuburbErrorMessage = By.xpath("//input[@name='city']//..//div[starts-with(@id,'error')]//span");
    public By lblStateErrorMessage = By.xpath("//select[@name='region_id']//..//div[starts-with(@id,'error')]//span");
    public By lblPostCodeErrorMessage = By.xpath("//input[@name='postcode']//..//div[starts-with(@id,'error')]//span");
    public By lblPhoneNumberErrorMessage = By.xpath("//input[@name='telephone']//..//div[starts-with(@id,'error')]//span");
    public By txtAddress = By.xpath("//div[@name='shippingAddress.street.0']/div/input");
    public By txtPostCode = By.xpath("//div[@name='shippingAddress.postcode']/div/input");
    public By txtPhoneNumber = By.xpath("(//input[@placeholder='0XXX XXX XXX'])[1]");
    public By drpdDelivery = By.xpath("//select[@name='delivery_notes']");

    //public By rdBtnCreditCcard = By.xpath("//label[@for='braintree']");
    public By txtCardNumber = By.xpath("//input[@id='credit-card-number']");
    public By txtExpireDate = By.xpath("//input[@id='expiration']");
    public By txtCCV = By.xpath("//input[@id='cvv']");
    public By btnPlaceHolder = By.xpath("//div[@class='opc-submit-step']//button[@title='Place Order']");





    public String getFirstName(){
        String firstName = syscoLabUI.findElement(lblFirstName).getAttribute("value");
        return firstName;
    }

    public String getLastName(){
        String lastName = syscoLabUI.findElement(lblLastName).getAttribute("value");
        return lastName;
    }




    public void clickContinue(){
        syscoLabUI.click(btnContinue);
    }

    public void enterAddress(){
        syscoLabUI.sendKeys(txtAddress, Constants.ADDRESS);
    }

    public void enterPostCode(){
        syscoLabUI.sendKeys(txtPostCode, Constants.POSTCODE);
        syscoLabUI.sleep(5);
        syscoLabUI.sendKeys(txtPostCode, Keys.ARROW_DOWN);
        syscoLabUI.sleep(5);
        syscoLabUI.sendKeys(txtPostCode, Keys.ENTER);
        syscoLabUI.sleep(5);

    }

    public void enterTeleohoneNumber(){
        syscoLabUI.sendKeys(txtPhoneNumber, Constants.PHONE_NUMBER);
        syscoLabUI.sleep(5);
    }


    public void selectDeliveryOption(){
        Select deliveryDropdown = new Select (syscoLabUI.findElement(drpdDelivery));
        List<WebElement> dropdownValues = deliveryDropdown.getOptions();

        if (dropdownValues.size() > 0) {
            //System.out.println("Delivery options are available");
            deliveryDropdown.selectByValue("Leave near front door");
        }
        else
            System.out.println("Delivery options are not available");

        syscoLabUI.sleep(5);
    }

    public boolean isAddressErrorMessageDisplayed(){
        Boolean isAddressError = syscoLabUI.isDisplayed(lblAddressErrorMessage);
        return isAddressError;
    }

    public boolean isStateErrorMessageDisplayed(){
        Boolean isStateError = syscoLabUI.isDisplayed(lblStateErrorMessage);
        return isStateError;
    }

    public boolean isSuburbErrorMessageDisplayed(){
        Boolean isSuburbError = syscoLabUI.isDisplayed(lblSuburbErrorMessage);
        return isSuburbError;
    }

    public boolean isPostCodeErrorMessageDisplayed(){
        Boolean isPostCodeError = syscoLabUI.isDisplayed(lblPostCodeErrorMessage);
        return isPostCodeError;
    }
    public boolean isPhoneNumberErrorMessageDisplayed(){
        Boolean islblPhoneNumberError = syscoLabUI.isDisplayed(lblPhoneNumberErrorMessage);
        return islblPhoneNumberError;
    }


    public void selectCreditCardOption(){
        WebElement rdBtnCreditCcard = syscoLabUI.driver.findElement(By.xpath("//label[@for='braintree']"));
        syscoLabUI.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        JavascriptExecutor executor = (JavascriptExecutor)syscoLabUI.driver;
        executor.executeScript("arguments[0].click()",rdBtnCreditCcard);

        //syscoLabUI.sleep(5);
        //syscoLabUI.click(rdBtnCreditCcard);
        syscoLabUI.sleep(5);
    }

    public void clickPlaceHolder(){
        syscoLabUI.click(btnPlaceHolder);
    }


    public void enterValidCardNumber(){
        WebElement creditCardNumber = syscoLabUI.driver.switchTo().frame("braintree-hosted-field-number").findElement(txtCardNumber);
        syscoLabUI.sendKeys(creditCardNumber, Constants.VALID_CREDIT_CARD);
        syscoLabUI.driver.switchTo().defaultContent();

    }

    public void enterValidExpireDate(){
        WebElement expireDate = syscoLabUI.driver.switchTo().frame("braintree-hosted-field-expirationDate").findElement(txtExpireDate);
        syscoLabUI.sendKeys(expireDate, Constants.VALID_EXPIRE_DATE);
        syscoLabUI.driver.switchTo().defaultContent();

    }

    public void enterValidCCV(){
        WebElement ccv = syscoLabUI.driver.switchTo().frame("braintree-hosted-field-cvv").findElement(txtCCV);
        syscoLabUI.sendKeys(ccv, Constants.VALID_CCV_CODE);
        syscoLabUI.driver.switchTo().defaultContent();

    }

    public void enterInValidCardNumber(){
        WebElement creditCardNumber = syscoLabUI.driver.switchTo().frame("braintree-hosted-field-number").findElement(txtCardNumber);
        syscoLabUI.sendKeys(creditCardNumber, Constants.INVALID_CREDIT_CARD);
        syscoLabUI.driver.switchTo().defaultContent();

    }

    public void enterInValidExpireDate(){
        WebElement expireDate = syscoLabUI.driver.switchTo().frame("braintree-hosted-field-expirationDate").findElement(txtExpireDate);
        syscoLabUI.sendKeys(expireDate, Constants.INVALID_EXPIRE_DATE);
        syscoLabUI.driver.switchTo().defaultContent();

    }

    public void enterInValidCCV(){
        WebElement ccv = syscoLabUI.driver.switchTo().frame("braintree-hosted-field-cvv").findElement(txtCCV);
        syscoLabUI.sendKeys(ccv, Constants.INVALID_CCV_CODE);
        syscoLabUI.driver.switchTo().defaultContent();

    }




    public boolean isInvalidCreditCardError() {
        syscoLabUI.sleep(5);
        boolean isDisplayed = syscoLabUI.isDisplayed(By.xpath("//div[@class='hosted-error']//span[text()='" + Constants.CREDIT_CARD_NUMBER_ERROR+ "']"));
        return isDisplayed;
    }

    public boolean isInvalidExpireDateError() {
        syscoLabUI.sleep(5);
        boolean isDisplayed = syscoLabUI.isDisplayed(By.xpath("//div[@class='hosted-error']//span[text()='" + Constants.EXPIRATION_DATE_ERROR+ "']"));
        return isDisplayed;
    }

    public boolean isInvalidCCVError() {
        syscoLabUI.sleep(5);
        boolean isDisplayed = syscoLabUI.isDisplayed(By.xpath("//div[@class='hosted-error']//span[text()='" + Constants.CCV_NUMBER_ERROR+ "']"));
        return isDisplayed;
    }
















}
