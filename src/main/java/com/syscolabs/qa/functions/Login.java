package com.syscolabs.qa.functions;

import com.syscolabs.qa.pages.LoginPage;
import com.syscolabs.qa.pages.HomePage;


public class Login {
    public LoginPage loginPage = new LoginPage();


    public boolean getLoginButtonAvailability(){
        return loginPage.isLoginButtonAvailable();
    }

    public void logIntoAccount(String email, String password) {
        loginPage.enterEmailAdress(email);
        //Thread.sleep(3000);
        loginPage.enterPassword(password);
        //Thread.sleep(3000);
        loginPage.clickLoginButton();

    }

    public void clickLogin() {
        loginPage.clickLoginButton();

    }

    public String getEmailFieldValidation(){
        return loginPage.emailFieldValidation();

    }

    public String getPasswordFieldValidation(){
        return loginPage.passwordFieldValidation();


    }

    public void clearEmailBox(){
        loginPage.clearEmailField();
    }
    public void clearPsswordBox(){
        loginPage.clearPasswordField();
    }


}