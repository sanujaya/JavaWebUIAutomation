package com.syscolabs.qa.functions;

import com.syscolabs.qa.pages.AddToCartPage;
import com.syscolabs.qa.pages.BasePage;

public class AddToCart extends BasePage {
    public AddToCartPage addToCartPage = new AddToCartPage();

    public void addItemsToCart(){
        addToCartPage.selectMainCategory();
        addToCartPage.selectSubCategory();
        addToCartPage.clickOnRandomItem();
        addToCartPage.selectFirstAvailbleSize();
        addToCartPage.clickAddToCart();

    }

    public void openShoppingCart(){
        addToCartPage.clickShoppingCart();
    }

    public void clickViewCart(){
        addToCartPage.clickViewCart();
    }

    public boolean getProductName(){
        //System.out.println("Product Name is Correct");
        return addToCartPage.isItemNameCorrect();

    }

    public boolean getProductPrice(){
        //System.out.println("Product Price is Correct");
        return addToCartPage.isItemPriceCorrect();

    }

    public void clickSecureCheckOut(){
        addToCartPage.navigateToCheckOutPage();
    }








}
