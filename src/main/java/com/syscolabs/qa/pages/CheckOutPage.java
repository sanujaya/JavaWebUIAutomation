package com.syscolabs.qa.pages;

import com.syscolabs.qa.common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckOutPage extends BasePage{

    private final By lblFirstName = By.xpath("//div[@name='shippingAddress.firstname']//div//input");
    private final By lblLastName = By.xpath("//div[@name='shippingAddress.lastname']//div//input");
    private final By btnContinue = By.xpath("//button[@title='Continue']");
    private final By lblAddressErrorMessage = By.xpath("//input[@name='street[0]']//..//div[starts-with(@id,'error')]//span");
    private final By lblSuburbErrorMessage = By.xpath("//input[@name='city']//..//div[starts-with(@id,'error')]//span");
    private final By lblStateErrorMessage = By.xpath("//select[@name='region_id']//..//div[starts-with(@id,'error')]//span");
    private final By lblPostCodeErrorMessage = By.xpath("//input[@name='postcode']//..//div[starts-with(@id,'error')]//span");
    private final By lblPhoneNumberErrorMessage = By.xpath("//input[@name='telephone']//..//div[starts-with(@id,'error')]//span");
    private final By txtAddress = By.xpath("//div[@name='shippingAddress.street.0']/div/input");
    private final By txtPostCode = By.xpath("//div[@name='shippingAddress.postcode']/div/input");
    private final By txtPhoneNumber = By.xpath("(//input[@placeholder='0XXX XXX XXX'])[1]");
    private final By drpdDelivery = By.xpath("//select[@name='delivery_notes']");

    private final By txtCardNumber = By.xpath("//input[@id='credit-card-number']");
    private final By txtExpireDate = By.xpath("//input[@id='expiration']");
    private final By txtCCV = By.xpath("//input[@id='cvv']");
    private final By btnPlaceHolder = By.xpath("//div[@class='opc-submit-step']//button[@title='Place Order']");



    public String returnFirstName(){
        return syscoLabUI.findElement(lblFirstName).getAttribute("value");
    }

    public String returnLastName(){
        return syscoLabUI.findElement(lblLastName).getAttribute("value");
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

    public String getAddressFieldErrorMessage(){
        return syscoLabUI.getText(lblAddressErrorMessage);
    }

    public String getStateFieldErrorMessage(){
        return syscoLabUI.getText(lblStateErrorMessage);
    }

    public String getSuburbFieldErrorMessage(){
        return syscoLabUI.getText(lblSuburbErrorMessage);
    }

    public String getPostCodeFieldErrorMessage(){
        return syscoLabUI.getText(lblPostCodeErrorMessage);
    }
    public String getPhoneNumberFieldErrorMessage(){
        return syscoLabUI.getText(lblPhoneNumberErrorMessage);
    }


    public void selectCreditCardOption(){
        WebElement rdBtnCreditCcard = syscoLabUI.driver.findElement(By.xpath("//label[@for='braintree']"));
        syscoLabUI.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        JavascriptExecutor executor = (JavascriptExecutor)syscoLabUI.driver;
        executor.executeScript("arguments[0].click()",rdBtnCreditCcard);
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


    public String isInvalidCreditCardError() {
        syscoLabUI.sleep(5);
        return syscoLabUI.getText(By.xpath("//div[@class='hosted-error']//span[text()='" + Constants.CREDIT_CARD_NUMBER_ERROR+ "']"));
    }

    public String isInvalidExpireDateError() {
        syscoLabUI.sleep(5);
        return syscoLabUI.getText(By.xpath("//div[@class='hosted-error']//span[text()='" + Constants.EXPIRATION_DATE_ERROR+ "']"));
    }

    public String isInvalidCCVError() {
        syscoLabUI.sleep(5);
        return syscoLabUI.getText(By.xpath("//div[@class='hosted-error']//span[text()='" + Constants.CCV_NUMBER_ERROR+ "']"));
    }
















}
