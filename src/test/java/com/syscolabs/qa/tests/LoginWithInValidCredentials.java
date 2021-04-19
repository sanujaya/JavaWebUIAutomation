package com.syscolabs.qa.tests;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolabs.qa.common.Constants;
import com.syscolabs.qa.functions.Home;
import com.syscolabs.qa.functions.MyAccount;
import com.syscolabs.qa.functions.Login;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginWithInValidCredentials {
    public Home home = new Home();
    public Login login = new Login();
    public MyAccount myAccount = new MyAccount();
    private SyscoLabUI syscoLabUI ;

    @BeforeMethod
    public void loadHomePage() {
        home.loadHomePage();


    }


    @Test(description ="Login button Availablility" )
    public void verifyLoginWithInValidCredentials() throws InterruptedException {
        home.navigateToLoginPage();
        login.loginButtonAvailability();

        Thread.sleep(3000);
    }
    @Test(description ="Email field Validation" )
    public void verifyLoginWithInValidEmail() throws InterruptedException {
        home.navigateToLoginPage();
        login.logIntoAccount(Constants.INVALID_EMAIL, Constants.INVALID_PASSWORD);
        Thread.sleep(3000);
        login.emailFieldValidation();
        Thread.sleep(3000);

    }
    @Test(description ="Password field Validation" )
    public void verifyLoginWithInValidPassword() throws InterruptedException {
        home.navigateToLoginPage();
        login.logIntoAccount(Constants.VALID_EMAIL, Constants.INVALID_PASSWORD);
        login.passwordFieldValidation();
        Thread.sleep(3000);
    }


    @AfterMethod
    public void closeBrowser(){
        home.exitBrowser();
    }
}
