package com.syscolabs.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AddToCartPage extends BasePage{

    private final By lnkMainCategory = By.xpath("//span[@id='mi-1-3']");
    private final By lnkSubCategory = By.xpath("//a[@href='https://www.theathletesfoot.com.au/kids/kids-run.html']");
    private final By btnsSelectSizeOption1 = By.xpath("//div[@id='swatch-row-276']//div[@class='swatch-option text'][1]");
    private final By btnsSelectSizeOption2 = By.xpath("//div[@id='swatch-row-277']//div[@class='swatch-option text'][1]");
    private final By btnAddToCart = By.xpath("//button[@id='product-addtocart-button']");
    private final By btnshoppingCartIcon = By.xpath("//span[@class='showcart-trigger header-sidebar-link -cart']");
    private final By btnCheckOut = By.xpath("//button[@data-role='proceed-to-checkout']");
    private final By btnViewCart =By.xpath("//a[@href='https://www.theathletesfoot.com.au/checkout/cart/']");
    private final By lblProductName = By.xpath("(//div[@class='item-details']//strong//a)[1]");
    private final By lblProductPrice = By.xpath("(//tbody[@class='cart item']//tr//td//span//span[@class='price'])[1]");


    private String itemTitle;
    private String itemPrice;


    public void selectMainCategory(){
        syscoLabUI.waitTillElementLoaded(lnkMainCategory).click();
    }

    public void selectSubCategory(){
        syscoLabUI.waitTillElementLoaded(lnkSubCategory).click();
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
            syscoLabUI.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            title = selectItem.getAttribute("title");
            //System.out.println("Title = "+title);

            priceAvailability = syscoLabUI.findElements(By.xpath("//a[@title='"+title+"']/parent::strong/parent::div/div")).size();

        }
        while(priceAvailability<1);

        syscoLabUI.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        selectedProductPrice = syscoLabUI.findElement(By.xpath("//a[@title='"+title+"']/parent::strong/parent::div/div/span/span/span")).getAttribute("data-price-amount");

        syscoLabUI.waitTillElementLoaded(selectItem).click();

        itemTitle =  title;
        itemPrice = selectedProductPrice;
        
    }


    public void selectFirstAvailbleSize(){

        syscoLabUI.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        if (itemTitle.contains("(PS)")){
            syscoLabUI.waitTillElementLoaded(btnsSelectSizeOption1).click();

        }
        else {
            syscoLabUI.waitTillElementLoaded(btnsSelectSizeOption2).click();
        }
        syscoLabUI.sleep(5);
    }


    public void clickAddToCart(){
        syscoLabUI.waitTillElementLoaded(btnAddToCart).click();
        //System.out.println("Add to cart");
        syscoLabUI.sleep(5);
    }

    public void clickShoppingCart(){
        syscoLabUI.click(btnshoppingCartIcon);
        //System.out.println("Click shopping cart");
        syscoLabUI.sleep(5);

    }

    public void clickViewCart(){
        syscoLabUI.click(btnViewCart);
        //System.out.println("Click view cart");
    }


    public String getProductName(){
        return syscoLabUI.findElement(lblProductName).getText();

    }

    public String getProductPrice(){
        return syscoLabUI.findElement(lblProductPrice).getText().replace("$","");
    }

    public boolean isItemNameCorrect(){
        return getProductName().equals(itemTitle);
    }

    public boolean isItemPriceCorrect(){
        return getProductPrice().equals(itemPrice);

    }

    public void navigateToCheckOutPage(){
        syscoLabUI.click(btnCheckOut);
    }

}
