package com.syscolabs.qa.pages;

import com.syscolabs.qa.common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class MyAccountPage extends BasePage{

    private final By btnshoppingCartIcon = By.xpath("//span[@data-container='#minicartOffcanvas']");
    private final By btnLastDeleteIcon = By.xpath("//a[@title='Remove item'][last()]");
    private final By btnOk = By.xpath("//button[contains(@class,'accept')]");
    private final By lblUserName = By.xpath("//div[@class='box box-information']/div/p");
    private final By lblCartQuantity = By.xpath("//span[@class='showcart-trigger header-sidebar-link -cart']/span");


    public String readUsername(){
        return syscoLabUI.findElement(lblUserName).getAttribute("innerText").split("\n")[0];
    }

    public String readCartQuantity(){
        return syscoLabUI.findElement(lblCartQuantity).getAttribute("class");

    }

    public String readCartQuantityCount(){
        return syscoLabUI.findElement(lblCartQuantity).getText();
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
        //System.out.println(i);

        while (i >0){
            syscoLabUI.waitTillElementLoaded(btnLastDeleteIcon).click();
            syscoLabUI.sleep(5);
            syscoLabUI.waitTillElementLoaded(btnOk).click();
            syscoLabUI.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            syscoLabUI.sleep(5);
            i--;
        }


    }

    public void closeShoppingCart(){

        WebElement btnCloseIcon = syscoLabUI.driver.findElement(By.xpath("//div[@class='close']"));
        syscoLabUI.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        JavascriptExecutor executor = (JavascriptExecutor)syscoLabUI.driver;
        executor.executeScript("arguments[0].click()",btnCloseIcon);
        syscoLabUI.sleep(5);


    }



}
