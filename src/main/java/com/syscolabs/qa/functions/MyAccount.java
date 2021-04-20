package com.syscolabs.qa.functions;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolabs.qa.common.Constants;
import com.syscolabs.qa.pages.MyAccountPage;
import org.testng.Assert;

public class MyAccount {
    protected SyscoLabUI syscoLabUI = new SyscoLabUI();
    public MyAccountPage myAccountPage = new MyAccountPage();
    public AddToCart addToCart = new AddToCart();

    public void isUserNameDisplayed(){
        //System.out.println("Page username is ="+myAccountPage.readUsername());
        Assert.assertEquals(myAccountPage.readUsername(), Constants.USER_NAME,"Username is incorrect");

    }

    public void removeShoppingCartItems(){
        if(myAccountPage.isShoppingCartEmpty()){
            //System.out.println("click shopping icon");
            //myAccountPage.clickShoppingCart();
            //System.out.println("remove shopping item");
            myAccountPage.clickRemoveItems();
            //System.out.println("close page");
            myAccountPage.closeShoppingCart();
            //System.out.println("closed");

        }



        //System.out.println("true and add items");
        //addToCart.addItemsToCart();

    }





}
