package com.syscolabs.qa.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{


    private final By lnkUserIconButton = By.xpath("//a[@href='https://www.theathletesfoot.com.au/customer/account/login/']");


    public void loadMyAccountPage(){
        syscoLabUI.waitTillElementLoaded(lnkUserIconButton).click();
        //syscoLabUI.sleep(5);
    }

    public void closeBrowser(){
        syscoLabUI.quit();
    }




}
