package com.syscolabs.qa.functions;

import com.syscolabs.qa.common.Constants;
import com.syscolabs.qa.pages.HomePage;


public class Home {

public HomePage homePage = new HomePage();


    public void loadHomePage(){
        homePage.loadHomePage(Constants.WEB_URL);
    }

    public void navigateToLoginPage() {
        homePage.loadMyAccountPage();
    }



    public void exitBrowser(){

        homePage.closeBrowser();

    }





}
