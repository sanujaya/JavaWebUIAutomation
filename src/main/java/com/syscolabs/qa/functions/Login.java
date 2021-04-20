package com.syscolabs.qa.functions;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolabs.qa.pages.LoginPage;
import com.syscolabs.qa.pages.HomePage;
import org.testng.Assert;


public class Login {
    protected SyscoLabUI syscoLabUI = new SyscoLabUI();
    public LoginPage loginPage = new LoginPage();
    public HomePage homePage = new HomePage();


    public void loginButtonAvailability(){
        Assert.assertTrue(loginPage.isLoginButtonAvailable(),"Login button Available");
    }



    public void logIntoAccount(String email, String password) throws InterruptedException {
        loginPage.enterEmailAdress(email);
        Thread.sleep(3000);
        loginPage.enterPassword(password);
        Thread.sleep(3000);
        loginPage.clickLoginButton();

    }

    public void verifyEmptyFieldLogin() {
        loginPage.clickLoginButton();

    }


    public void emailFieldValidation(){
        Assert.assertTrue(loginPage.emailEmptyFieldValidation(),"Email is not validated");
        syscoLabUI.clear(loginPage.txteEmailBox);


    }

    public void passwordFieldValidation(){
        Assert.assertTrue(loginPage.passwordEmptyFieldValidation(),"Password is not Validated");
        syscoLabUI.clear(loginPage.txtpasswordBox);

    }





}