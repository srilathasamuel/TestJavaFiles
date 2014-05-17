package com.mukthi.registration.Sanity;

/**
 * Created by Samuel on 15/05/2014.
 */

import com.mukthi.registration.Sanity.BaseTest;
import com.mukthi.registration.Utils.Utils;
import com.mukthi.registration.Utils.UserDetails;
import com.mukthi.registration.Utils.DateOfBirth;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.NoSuchElementException;


public class SanityTestPack extends BaseTest{

    void doNavigate()
    {

    }

    void doLogin(UserDetails userDetails)
    {
        System.out.println("testing login ...");
        businessLib.login(userDetails);

        try {
            System.out.println("login test finished, now waiting.....");
            Thread.sleep(1000 * 2);
        }
        catch ( InterruptedException e)
        {
            System.out.println("exception caught!");
        }
    }


    void doLogout()
    {
        System.out.println("testing logout");
        businessLib.logout();

        try {
            System.out.println("logout test finished, now waiting.....");
            Thread.sleep(1000 * 2);
        }
        catch ( InterruptedException e)
        {
            System.out.println("exception caught!");
        }

    }

    String doRegistration(UserDetails userDetails)
    {
        System.out.println("testing registration");
        String status = "";
        try
        {
            status = businessLib.register(userDetails);


            Assert.assertEquals("Your registration completed", driver.findElement(By.cssSelector("div.section-body")).getText());
            driver.findElement(By.linkText("Continue")).click();
            Assert.assertTrue(Utils.isElementPresent(driver, By.cssSelector("#shopbar-account > a.shopbar-button.clearfix > span.shopbar-button-label.pull-left")));
        }
        catch (NoSuchElementException e)
        {
            System.out.println("NoSuchElementException caught!");
            System.out.println("registration failed!");
            return status;
        }
        System.out.println("testing registration finished");
        return status;
    }

    void testRegistration()
    {
        DateOfBirth dob2 = new DateOfBirth("12", "4", "1987");
        UserDetails user2 = new UserDetails("abc1&", "abc2", dob2, "abc1", "a1b1c1", "a1b1c1", "myemail1@gmail.com");
        System.out.println("Registration status:" + doRegistration(user2));

        DateOfBirth dob3 = new DateOfBirth("12", "4", "1987");
        UserDetails user3 = new UserDetails("abc1", "abc2", dob3, "abc2", "a1b1c1(", "a1b1c1", "myemail2@gmail.com");
        System.out.println("Registration status:" + doRegistration(user3));

        DateOfBirth dob4 = new DateOfBirth("12", "4", "2000");
        UserDetails user4 = new UserDetails("abc1", "abc2", dob4, "abc3", "a1b1c1", "a1b1c1", "myemail3@gmail.com");
        System.out.println("Registration status:" + doRegistration(user4));

        UserDetails user5 = new UserDetails("abc1", "abc2", dob4, "abc4", "a1b1c1", "a1b1c1", "myemail4@gmail.com");
        System.out.println("Registration status:" + doRegistration(user5));

        UserDetails user6 = new UserDetails("abc1", "abc2", dob4, "abc1", "a1b1c1", "a1b1c1", "myemail5@gmail.com");
        System.out.println("Registration status:" + doRegistration(user6));

        UserDetails user7 = new UserDetails("abc1", "abc2", dob4, "abc1", "a1b1c1", "a1b1c1", "myemail6@gmail.com");
        System.out.println("Registration status:" + doRegistration(user7));
    }


    @Test
    public void testRegister() throws Exception
    {
        driver.get("http://srikanthgoudm-001-site1.smarterasp.net/");

        //Login tests
        UserDetails user1 = new UserDetails("ABC", "a1b1c1");
        doLogin(user1);

        //logout test
        doLogout();

        //Registration tests
        testRegistration();

        try {
            System.out.println("all tests finished, now waiting.....");
            Thread.sleep(1000 * 2);
        }
        catch ( InterruptedException e)
        {
            System.out.println("exception caught!");
        }

    }
}
