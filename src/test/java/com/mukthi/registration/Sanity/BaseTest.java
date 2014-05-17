package com.mukthi.registration.Sanity;

/**
 * Created by Samuel on 15/05/2014.
 */

        import com.mukthi.registration.BusinessLib.BusinessLibrary;
        import org.junit.AfterClass;
        import org.junit.BeforeClass;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest {

    public static WebDriver driver;
    public static BusinessLibrary businessLib;

    @BeforeClass
    public static void startUp()
    {
        driver = new FirefoxDriver();
        //driver.get("http://srikanthgoudm-001-site1.smarterasp.net/");
        //driver.manage().window().maximize();
        businessLib = new BusinessLibrary(driver);
    }


    @AfterClass
    public static void stop()
    {
        driver.quit();
    }
}