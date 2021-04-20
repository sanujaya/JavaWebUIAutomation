package com.syscolabs.qa.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AddToCartPage {
    protected SyscoLabUI syscoLabUI = new SyscoLabUI();

    private By lnkMainCategory = By.xpath("//span[@id='mi-1-3']");
    private By lnkSubCategory = By.xpath("//a[@href='https://www.theathletesfoot.com.au/kids/kids-run.html']");
    private By btnsSelectSizeOption1 = By.xpath("//div[@id='swatch-row-276']//div[@class='swatch-option text'][1]");
    private By btnsSelectSizeOption2 = By.xpath("//div[@id='swatch-row-277']//div[@class='swatch-option text'][1]");
    private By btnAddToCart = By.xpath("//button[@id='product-addtocart-button']");
    private By btnshoppingCartIcon = By.xpath("//span[@class='showcart-trigger header-sidebar-link -cart']");
    private By btnCheckOut = By.xpath("//button[@data-role='proceed-to-checkout']");
    private By btnViewCart =By.xpath("//a[@href='https://www.theathletesfoot.com.au/checkout/cart/']");


    public String itemTitle;
    public String itemPrice;


    public void selectMainCategory(){
        syscoLabUI.click(lnkMainCategory);
    }

    public void selectSubCategory(){
        syscoLabUI.click(lnkSubCategory);
    }


    public void clickOnRandomItem(){

        int priceAvailability;
        WebElement selectItem;
        String title;
        String selectedProductPrice;

        do {

            Random random = new Random();
            int randomNo =3 ;
            while (randomNo<=3)
                randomNo = random.nextInt(50);

            //System.out.println("random number = "+ randomNo);

            selectItem = syscoLabUI.findElement(By.xpath("(//img[@class='product-image-photo'])["+randomNo+"]"));
            syscoLabUI.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            title = selectItem.getAttribute("title");
            //System.out.println("Title = "+title);

            priceAvailability = syscoLabUI.findElements(By.xpath("//a[@title='"+title+"']/parent::strong/parent::div/div")).size();

        }
        while(priceAvailability<1);

        syscoLabUI.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        selectedProductPrice = syscoLabUI.findElement(By.xpath("//a[@title='"+title+"']/parent::strong/parent::div/div/span/span/span")).getAttribute("data-price-amount");

        syscoLabUI.sleep(5);
        syscoLabUI.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        syscoLabUI.click(selectItem);
        //System.out.println("click");
        syscoLabUI.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        syscoLabUI.sleep(5);

        //System.out.println("Item Titel = "+title);
        //System.out.println("Item Price = "+selectedProductPrice);

        itemTitle =  title;
        itemPrice = selectedProductPrice;




    }


    public void selectFirstAvailbleSize(){

        syscoLabUI.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        if (itemTitle.contains("(PS)")){
            syscoLabUI.click(btnsSelectSizeOption1);

        }
        else {
            syscoLabUI.click(btnsSelectSizeOption2);
        }
        syscoLabUI.sleep(5);
    }


    public void clickAddToCart(){
        syscoLabUI.click(btnAddToCart);
        //System.out.println("Add to cart");
        syscoLabUI.sleep(5);
    }

    public void clickShoppingCart(){
        syscoLabUI.click(btnshoppingCartIcon);
        //System.out.println("Click shopping cart");
        syscoLabUI.sleep(5);

    }

    public void ClickViewCart(){
        syscoLabUI.click(btnViewCart);
        //System.out.println("Click view cart");
    }




    public String getProductName(){
        String productName = syscoLabUI.findElement(By.xpath("(//div[@class='item-details']//strong//a)[1]")).getText();
        //System.out.println("Product Name ="+productName);
        return productName;

    }

    public String getProductPrice(){
        String productPrice = syscoLabUI.findElement(By.xpath("(//tbody[@class='cart item']//tr//td//span//span[@class='price'])[1]")).getText().replace("$","");
        //System.out.println("Product Price ="+productPrice);
        return productPrice;
    }


    public boolean isItemNameCorrect(){
        if (getProductName().equals(itemTitle))
            return true;
        else
            return false;
    }

    public boolean isItemPriceCorrect(){
        if (getProductPrice().equals(itemPrice))
            return true;

        else
            return false;

    }


    public void navigateToCheckOutPage(){
        syscoLabUI.click(btnCheckOut);
    }




}
