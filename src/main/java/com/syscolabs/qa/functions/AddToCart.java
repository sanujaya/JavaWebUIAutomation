package com.syscolabs.qa.functions;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolabs.qa.pages.AddToCartPage;
import org.testng.Assert;

public class AddToCart {
    public AddToCartPage addToCartPage = new AddToCartPage();
    protected SyscoLabUI syscoLabUI = new SyscoLabUI();

    public void addItemsToCart(){
        addToCartPage.selectMainCategory();
        syscoLabUI.sleep(5);
        addToCartPage.selectSubCategory();
        syscoLabUI.sleep(5);
        addToCartPage.clickOnRandomItem();
        syscoLabUI.sleep(5);
        addToCartPage.selectFirstAvailbleSize();
        syscoLabUI.sleep(5);
        addToCartPage.clickAddToCart();
        syscoLabUI.sleep(5);

    }

    public void openShoppingCart(){
        addToCartPage.clickShoppingCart();
    }

    public void ClickViewCart(){
        addToCartPage.ClickViewCart();
    }




    public void verifyProductNameAndPrice(){
        Assert.assertTrue(addToCartPage.isItemNameCorrect(),"Product Name is incorrect");
        //System.out.println("Product Name is Correct");
        Assert.assertTrue(addToCartPage.isItemPriceCorrect(), "Product Price is incorrect");
        //System.out.println("Product Price is Correct");
    }


    public void clickSecureCheckOut(){
        addToCartPage.navigateToCheckOutPage();
    }








}
