package com.syscolabs.qa.pages;

import org.openqa.selenium.By;


public class LoginPage extends BasePage{

    private final By txtEmailBox = By.xpath("//input[@id='email']");
    private final By txtpasswordBox = By.xpath("//input[@id='pass']");
    private final By btnLoginButton = By.xpath("//button[@id='send2']");
    private final By lblEmailFieldErrorMessage = By.xpath("//div[@id='email-error']");
    private final By lblpasswordFieldErrorMessage = By.xpath("//div[@data-ui-id='message-error']");

    public boolean isLoginButtonAvailable(){
        return syscoLabUI.isDisplayed(btnLoginButton);

    }

    public void enterEmailAdress(String email) {
        syscoLabUI.waitTillElementLoaded(txtEmailBox).sendKeys(email);
        //syscoLabUI.sleep(2);


    }

    public void enterPassword(String password){
        syscoLabUI.waitTillElementLoaded(txtpasswordBox).sendKeys(password);
        //syscoLabUI.sleep(2);
    }

    public void clickLoginButton(){
        syscoLabUI.click(btnLoginButton);
        //syscoLabUI.sleep(2);
    }

    public String emailFieldValidation(){
        return syscoLabUI.getText(lblEmailFieldErrorMessage);

    }

    public String passwordFieldValidation(){
        return syscoLabUI.getText(lblpasswordFieldErrorMessage);
    }

    public void clearEmailField(){
        syscoLabUI.clear(txtEmailBox);
    }

    public void clearPasswordField(){
        syscoLabUI.clear(txtpasswordBox);
    }



}
