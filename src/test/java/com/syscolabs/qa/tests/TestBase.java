package com.syscolabs.qa.tests;

import com.syscolabs.qa.functions.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;


public class TestBase {

    public Home home = new Home();
    public Login login = new Login();
    public MyAccount myAccount = new MyAccount();
    public AddToCart addToCart = new AddToCart();
    public CheckOut checkOut = new CheckOut();
    SoftAssert softAssert = new SoftAssert();


    @BeforeMethod
    public void loadHomePage() throws InterruptedException {
        home.loadHomePage();

    }


    @AfterMethod
    public void closeBrowser(){
        home.exitBrowser();
    }
}
