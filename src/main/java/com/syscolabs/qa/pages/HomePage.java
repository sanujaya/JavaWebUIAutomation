package com.syscolabs.qa.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import com.syscolabs.qa.common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;

public class HomePage {

    protected SyscoLabUI syscoLabUI = new SyscoLabUI();


    private By lnkUserIconButton = By.xpath("//a[@href='https://www.theathletesfoot.com.au/customer/account/login/']");


    public SyscoLabUI loadHomePage(String url) {
        String driver = Constants.CHROME_DRIVER_URL;
        syscoLabUI = new SyscoLabWUI(BrowserType.CHROME);
        syscoLabUI.driver.get(url);
        syscoLabUI.driver.manage().window().maximize();
        return syscoLabUI;
    }


    public void loadMyAccountPage(){
        syscoLabUI.click(lnkUserIconButton);
        syscoLabUI.sleep(5);
    }

    public void closeBrowser(){
        syscoLabUI.quit();
    }




}
