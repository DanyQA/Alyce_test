package lib;

import junit.framework.TestCase;
import lib.ui.ApplesPageObject;
import lib.ui.factories.ApplesPageObjectFactory;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CoreTestCase extends TestCase {

    protected RemoteWebDriver driver;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        driver = Platform.getInstance().getDriver();
        driver.get("http://alve01.beget.tech/");

        ApplesPageObject applesPageObject  =  ApplesPageObjectFactory.create(driver);
        applesPageObject.clickFreeApples();
    }

    @Override
    protected void tearDown() throws Exception
    {
        driver.quit();

        super.tearDown();
    }
}
