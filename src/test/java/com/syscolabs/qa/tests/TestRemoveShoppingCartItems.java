package com.syscolabs.qa.tests;

import com.syscolabs.qa.common.Constants;
import org.testng.annotations.Test;


public class TestRemoveShoppingCartItems extends TestBase{


    @Test
    public void removeSHoppingCartItems() throws InterruptedException {
        home.navigateToLoginPage();
        softAssert.assertTrue(login.getLoginButtonAvailability(),"Login button Available");
        login.logIntoAccount(Constants.VALID_EMAIL, Constants.VALID_PASSWORD);
        softAssert.assertEquals(myAccount.getUserName(), Constants.USER_NAME,"Username is incorrect");
        myAccount.removeShoppingCartItems();
        softAssert.assertAll();
    }


}
