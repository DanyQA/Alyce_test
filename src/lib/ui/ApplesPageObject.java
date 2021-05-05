package lib.ui;

import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ApplesPageObject extends MainPageObject {

    protected static String
            FREE_APPLES_BUTTON,
            GRAB_APPLE_BUTTON,
            USER_APPLES_COUNTER,
            BASKET_ROW,
            USER_APPLES_LIST,
            BASKET_LIST;

    public ApplesPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void clickFreeApples(){
        this.waitForElementAndClick(FREE_APPLES_BUTTON,
                "Cannot find 'Free apples' button",
                5);
    }

    public void addAppleToUser(String user_id, long waiting_time_in_millisec){
        String user_locator = getUserIdForButton(user_id);
        String user_counter = getUserIdForCounter(user_id);

        this.timeoutBeforeAction(waiting_time_in_millisec);

        int before = Integer.parseInt(this.waitForElementAndGetAttribute(user_counter,
                "innerText",
                "Cannot find innerText attribute",
                5));

        this.waitForElementAndClick(user_locator,
                "Cannot find 'Grab apples' button for user " + user_id,
                10);

        this.timeoutBeforeAction(1500);

        int after = Integer.parseInt(this.waitForElementAndGetAttribute(user_counter,
                "innerText",
                "Cannot find innerText attribute",
                5));

        Assert.assertEquals(before+1, after);

    }

    public void checkEmptyBasket()
    {
        this.waitForElementNotPresent(BASKET_ROW,
                "Basket isn't empty",
                5);
    }

//У меня мало опыта работы в автоматизации. И еще меньше с вебом, поэтому в этом методе я не пойму как вытащить id яблока,
// следовательно и проверить правильность написанного  тоже. Поэтому не судите строго, буду рад фидбэку))
    public void addAllApplesToOneUser(String user_id, long waiting_time_in_millisec)
    {
        int odd = 0;
        int even = 0;

        String user_locator = getUserIdForButton(user_id);
        this.timeoutBeforeAction(waiting_time_in_millisec);

        int  basket_apples =  Integer.parseInt(this.waitForElementAndGetAttribute(BASKET_LIST,
                "childElementCount",
                "Cannot find attribute: 'childElementCount'",
                5));

        while ( basket_apples != 1 ){

            this.timeoutBeforeAction(waiting_time_in_millisec);
            this.waitForElementAndClick(user_locator,
                    "Cannot find 'Grab apples' button for user " + user_id,
                    10);

            int  user_apple =  Integer.parseInt(this.waitForElementAndGetAttribute(USER_APPLES_LIST,
                    "id",
                    "Cannot find attribute: 'id'",
                    5));

            if ((user_apple&1)!=1) {
                odd++;
            } else {
                even++;
            }

            basket_apples = Integer.parseInt(this.waitForElementAndGetAttribute(BASKET_LIST,
                    "childElementCount",
                    "Cannot find attribute: 'childElementCount'",
                    5));
        }

        if ((odd != 0)&&(even == 0)){
            System.out.println("User has apples with odd apple id's");
        } if ((odd != 0)&&(even == 0)){
            System.out.println("User has apples with even apple id's");
        } else {
        throw new IllegalArgumentException("User has apples with odd and even apples id's");
        }

    }

    private static String getUserIdForButton(String  user_id)
    {
        return GRAB_APPLE_BUTTON.replace("{ID}", user_id);
    }

    private static String getUserIdForCounter(String  user_id)
    {
        return USER_APPLES_COUNTER.replace("{ID}", user_id);
    }

}
