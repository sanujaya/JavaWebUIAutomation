package com.syscolabs.qa.tests;

import com.syscolabs.qa.common.Constants;
import com.syscolabs.qa.functions.AddToCart;
import com.syscolabs.qa.functions.Home;
import com.syscolabs.qa.functions.Login;
import com.syscolabs.qa.functions.MyAccount;
import org.testng.annotations.Test;

//import org.example.functions.*;

public class TestAddItemToCart extends TestBase {


    @Test(description = "Add item to cart")
    public void addProductItemToCart() throws InterruptedException {

        home.navigateToLoginPage();
        softAssert.assertTrue(login.getLoginButtonAvailability(),"Login button Available");
        login.logIntoAccount(Constants.VALID_EMAIL, Constants.VALID_PASSWORD);
        softAssert.assertEquals(myAccount.getUserName(), Constants.USER_NAME,"Username is incorrect");
        myAccount.removeShoppingCartItems();
        addToCart.addItemsToCart();
        addToCart.openShoppingCart();
        addToCart.clickViewCart();
        softAssert.assertTrue(addToCart.getProductName(),"Product Name is incorrect");
        softAssert.assertTrue(addToCart.getProductPrice(), "Product Price is incorrect");
        addToCart.clickSecureCheckOut();
        softAssert.assertAll();


    }


}
