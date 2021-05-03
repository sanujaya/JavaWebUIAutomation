package com.syscolabs.qa.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.remote.BrowserType;

public class BasePage {
    protected static SyscoLabUI syscoLabUI = new SyscoLabUI();

    public void loadHomePage(String url) {
        syscoLabUI = new SyscoLabWUI(BrowserType.CHROME);
        syscoLabUI.driver.get(url);
        syscoLabUI.driver.manage().window().maximize();

    }
}
