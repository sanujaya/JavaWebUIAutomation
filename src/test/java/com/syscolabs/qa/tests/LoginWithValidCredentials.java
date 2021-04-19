package com.syscolabs.qa.tests;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolabs.qa.common.Constants;
import com.syscolabs.qa.functions.Home;
import com.syscolabs.qa.functions.Login;
import com.syscolabs.qa.functions.MyAccount;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginWithValidCredentials {

    public Home home = new Home();
    public Login login = new Login();
    public MyAccount myAccount = new MyAccount();
    private SyscoLabUI syscoLabUI ;

    @BeforeMethod
    public void loadHomePage() {
        home.loadHomePage();

    }


    @Test()
    public void verifyLoginWithValidCredentials() throws InterruptedException {
        home.navigateToLoginPage();
        login.loginButtonAvailability();
        login.logIntoAccount(Constants.VALID_EMAIL, Constants.VALID_PASSWORD);
        Thread.sleep(3000);
        myAccount.isUserNameDisplayed();
        Thread.sleep(3000);

    }

    @AfterMethod
    public void closeBrowser(){
        home.exitBrowser();
    }






}
