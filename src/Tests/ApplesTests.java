package Tests;

import lib.CoreTestCase;
import lib.ui.ApplesPageObject;
import lib.ui.factories.ApplesPageObjectFactory;
import org.junit.Test;

public class ApplesTests extends CoreTestCase {

    @Test
    public void  testAddAppleToUser()
    {
        ApplesPageObject applesPageObject = ApplesPageObjectFactory.create(driver);

        applesPageObject.addAppleToUser("1", 10000);
    }

    @Test
    public void testAddApplesToAllUsers(){
        ApplesPageObject applesPageObject = ApplesPageObjectFactory.create(driver);

        applesPageObject.addAppleToUser("1", 10000);
        applesPageObject.addAppleToUser("1", 10000);
        applesPageObject.addAppleToUser("3", 10000);
        applesPageObject.addAppleToUser("2", 10000);
        applesPageObject.checkEmptyBasket();
    }
}
