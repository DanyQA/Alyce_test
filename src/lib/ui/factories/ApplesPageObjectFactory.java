package lib.ui.factories;

import lib.ui.ApplesPageObject;
import lib.ui.web.WebApplesPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ApplesPageObjectFactory {
    public static ApplesPageObject create(RemoteWebDriver driver) {

        return new WebApplesPageObject(driver);
    }
}
