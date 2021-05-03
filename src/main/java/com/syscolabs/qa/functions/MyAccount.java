package com.syscolabs.qa.functions;

import com.syscolabs.qa.pages.MyAccountPage;

public class MyAccount {
    public MyAccountPage myAccountPage = new MyAccountPage();

    public String getUserName(){
        //System.out.println("Page username is ="+myAccountPage.readUsername());
        return myAccountPage.readUsername();


    }

    public void removeShoppingCartItems(){
        if(myAccountPage.isShoppingCartEmpty()){
            //System.out.println("click shopping icon");
            myAccountPage.clickRemoveItems();
            //System.out.println("close page");
            myAccountPage.closeShoppingCart();
            //System.out.println("closed");

        }

        //System.out.println("true and add items");
        //addToCart.addItemsToCart();

    }





}
