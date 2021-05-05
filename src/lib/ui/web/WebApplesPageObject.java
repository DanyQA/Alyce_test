package lib.ui.web;

import lib.ui.ApplesPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebApplesPageObject extends ApplesPageObject{

    static {
        FREE_APPLES_BUTTON = "xpath://a[contains(text(),'Free Apples')]";
        GRAB_APPLE_BUTTON = "css:.list-group-item:nth-child({ID}) .btn";
        USER_APPLES_COUNTER = "css:.list-group-item:nth-child({ID}) .badge";
        BASKET_ROW = "css:div>ul[class='list-group basket']>li[class='list-group-item']";
        USER_APPLES_LIST = "css:ul[class='list-group-item'] > div[class='col-12'] > ul > li"; //"css:list-group:nth-child({ID}) > .list-group-item:nth-child({APPLE_ID})";
        BASKET_LIST  = "css:ul[class='list-group basket']";
    }

    public WebApplesPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }


}
