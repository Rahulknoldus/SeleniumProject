package seliniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.System.*;

public class AutomateWebsite {

    @BeforeMethod
    public void beforeMethod() {

        System.out.println(" Test start on Chrome Browser");

    }

    //test 1 browser = chrome
    @Test
    public void Chrome_browser_Test() throws InterruptedException {


         //link external input source
        out.println("Launching Google Chrome browser");
        //set the chrome path
        setProperty("webdriver.chrome.driver", "src/test/chromedriver_linux64/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //wait is use for control the selenium flow
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //url=keka.com use
        driver.get("https://www.saucedemo.com/");

        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Swag Labs";
        Assert.assertEquals(ExpectedTitle, ActualTitle);

        //send emailId from excel_sheet
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //reached keka.knoldus.com now
        driver.findElement(By.id("login-button")).click();

        // driver.findElement(By.cssSelector("#identifierId")).sendKeys("kuch_bhi_add_krskta_ho");//also send or add keys into email field.
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //send password from external sheet
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        //now we login to keka via google ID
        driver.findElement(By.id("checkout")).click();

        //now to regularise attendance need pending approval or three dots.
        driver.findElement(By.id("first-name")).sendKeys("rahul");


        //now add time duration(9.45-6.45)
        driver.findElement(By.id("last-name")).sendKeys("kumar");

        driver.findElement(By.id("postal-code")).sendKeys("25000");
        driver.findElement(By.id("continue")).click();

        driver.findElement(By.id("finish")).click();

        Assert.assertEquals("THANK YOU FOR YOUR ORDER", driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText());



    }

    @AfterMethod
    public void afterMethod() {
        //driver.close();
        out.println("Finished Test On Chrome Browser");
    }
}