package com.syscolabs.qa.tests;

import com.syscolabs.qa.common.Constants;
import org.testng.annotations.Test;

public class TestLoginWithInValidCredentials extends TestBase {


    @Test(description ="Login with invalid Credentials" )
    public void verifyLoginWithInValidCredentials() throws InterruptedException {

        home.navigateToLoginPage();
        softAssert.assertTrue(login.getLoginButtonAvailability(),"Login button Available");
        login.logIntoAccount(Constants.INVALID_EMAIL, Constants.INVALID_PASSWORD);
        softAssert.assertEquals(login.getEmailFieldValidation(),Constants.EMAIL_ERRORMESSAGE);
        login.clearEmailBox();
        login.clearPsswordBox();
        login.logIntoAccount(Constants.VALID_EMAIL, Constants.INVALID_PASSWORD);
        softAssert.assertEquals(login.getPasswordFieldValidation(),Constants.PASSWORD_ERRORMESSAGE);
        softAssert.assertAll();

    }

}
