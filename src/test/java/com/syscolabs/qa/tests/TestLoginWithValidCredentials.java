package com.syscolabs.qa.tests;

import com.syscolabs.qa.common.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginWithValidCredentials extends TestBase {



    @Test()
    public void verifyLoginWithValidCredentials() throws InterruptedException {
        home.navigateToLoginPage();
        Assert.assertTrue(login.getLoginButtonAvailability(),"Login button Available");
        login.logIntoAccount(Constants.VALID_EMAIL, Constants.VALID_PASSWORD);
        softAssert.assertEquals(myAccount.getUserName(), Constants.USER_NAME,"Username is incorrect");
        softAssert.assertAll();

    }



}
