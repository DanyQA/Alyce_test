package lib;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;


public class Platform {
    private static final String PLATFORM_CHROME = "chrome";
    private static final String PLATFORM_SAFARI = "safari";



    private static Platform instance;

    private Platform() {}

    public static Platform getInstance()
    {
        if (instance == null)  {
            instance = new Platform();
        }
        return instance;
    }

    public RemoteWebDriver getDriver() throws Exception
    {
        if (this.isChrome()) {
            return new ChromeDriver();
        } else if (this.isSafari()) {
            return new SafariDriver();
        } else {
            throw new Exception("Cannot detect type of the Driver. Platform value: " + this.getPlatformVar());
        }
    }


    public boolean isChrome()
    {
        return isPlatform(PLATFORM_CHROME);
    }

    public boolean isSafari()
    {
        return isPlatform(PLATFORM_SAFARI);
    }


    private boolean isPlatform(String my_platform)
    {
        String platform = this.getPlatformVar();
        return my_platform.equals(platform);
    }

    private String getPlatformVar()
    {
        return System.getenv("PLATFORM");
    }

}
