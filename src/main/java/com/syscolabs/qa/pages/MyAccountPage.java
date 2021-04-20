package com.syscolabs.qa.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolabs.qa.common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class MyAccountPage {
    protected SyscoLabUI syscoLabUI = new SyscoLabUI();

    public By btnshoppingCartIcon = By.xpath("//span[@class='showcart-trigger header-sidebar-link -cart']");
    private By btnLastDeleteIcon = By.xpath("//a[@title='Remove item'][last()]");
    private By btnOk = By.xpath("//button[contains(@class,'accept')]");
    //private By btnCloseIcon = By.xpath("//div[@class='close']");


    public String readUsername(){
        String userName = syscoLabUI.findElement(By.xpath("//div[@class='box box-information']/div/p")).getAttribute("innerText").split("\n")[0];
        return userName;
    }

    public String readCartQuantity(){
        String cartQuantity= syscoLabUI.findElement(By.xpath("//span[@class='showcart-trigger header-sidebar-link -cart']/span")).getAttribute("class");
        //System.out.println("Site quantity name = "+cartQuantity);
        return cartQuantity;

    }

    public String readCartQuantityCount(){
        String cartQuantityCount = syscoLabUI.findElement(By.xpath("//span[@class='showcart-trigger header-sidebar-link -cart']/span")).getText();
        //System.out.println("Site quantity count = "+cartQuantityCount);
        return cartQuantityCount;

    }
    


    public void clickShoppingCart(){
        syscoLabUI.click(btnshoppingCartIcon);
        syscoLabUI.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public Boolean isShoppingCartEmpty(){
        boolean isEmpty;
        isEmpty = readCartQuantity().equals(Constants.SHOPPING_CART_NOT_EMPTY);
        //System.out.println("isshoppingCartEmpty = "+ isEmpty);
        return isEmpty;
    }

    public void clickRemoveItems(){
        int i = Integer.parseInt(String.valueOf(readCartQuantityCount()));
        clickShoppingCart();
        syscoLabUI.sleep(5);
        System.out.println(i);

        while (i >0){
            syscoLabUI.click(btnLastDeleteIcon);
            syscoLabUI.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            syscoLabUI.sleep(5);
            syscoLabUI.click(btnOk);
            syscoLabUI.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            syscoLabUI.sleep(5);
            i--;
        }


    }

    public void closeShoppingCart(){

        WebElement btnCloseIcon = syscoLabUI.driver.findElement(By.xpath("//div[@class='close']"));
        syscoLabUI.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        JavascriptExecutor executor = (JavascriptExecutor)syscoLabUI.driver;
        executor.executeScript("arguments[0].click()",btnCloseIcon);
        syscoLabUI.sleep(5);
        syscoLabUI.sleep(5);

    }



}
