package com.syscolabs.qa.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

import java.util.concurrent.TimeUnit;


public class LoginPage {
    protected SyscoLabUI syscoLabUI = new SyscoLabUI();

    public By txteEmailBox = By.xpath("//input[@id='email']");
    public By txtpasswordBox = By.xpath("//input[@id='pass']");
    private By btnLoginButton = By.xpath("//button[@id='send2']");
    private By lblEmailFieldErrorMessage = By.xpath("//div[@id='email-error']");
    private By lblpasswordFieldErrorMessage = By.xpath("//*[contains(text(),'The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.')]");

    public boolean isLoginButtonAvailable(){
        Boolean isDisplayed = syscoLabUI.isDisplayed(btnLoginButton);
        return isDisplayed;
    }

    public void enterEmailAdress(String email) {
        syscoLabUI.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        syscoLabUI.sendKeys(txteEmailBox,email);
        syscoLabUI.sleep(5);


    }

    public void enterPassword(String password){
        syscoLabUI.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        syscoLabUI.sendKeys(txtpasswordBox, password);
        syscoLabUI.sleep(2);

    }

    public void clickLoginButton(){
        syscoLabUI.click(btnLoginButton);
        syscoLabUI.sleep(2);


    }


    public boolean emailEmptyFieldValidation(){
        boolean isDisplayed = syscoLabUI.isDisplayed(lblEmailFieldErrorMessage);
        return isDisplayed;
    }

    public boolean passwordEmptyFieldValidation(){
        boolean isDisplayed = syscoLabUI.isDisplayed(lblpasswordFieldErrorMessage);
        return isDisplayed;
    }






}
