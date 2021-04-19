package com.syscolabs.qa.tests;

import com.syscolabs.qa.common.Constants;
import com.syscolabs.qa.functions.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RemoveShoppingCartItems {
    public Home home = new Home();
    public Login login = new Login();
    public MyAccount myAccount = new MyAccount();
    //public AddToCart addToCart = new AddToCart();
    //public CheckOut checkOut = new CheckOut();
    //public AddItemToCart addItemToCart = new AddItemToCart();


    @BeforeMethod
    public void loadHomePage() throws InterruptedException {
        home.loadHomePage();
        home.navigateToLoginPage();
        login.loginButtonAvailability();
        login.logIntoAccount(Constants.VALID_EMAIL, Constants.VALID_PASSWORD);
        Thread.sleep(1000);
        myAccount.isUserNameDisplayed();
        Thread.sleep(1000);


    }



    @Test
    public void removeSHoppingCartItems(){
        myAccount.removeShoppingCartItems();
    }

    @AfterMethod
    public void closeBrowser(){
        home.exitBrowser();
    }



}
