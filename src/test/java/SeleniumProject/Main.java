package SeleniumProject;
import  org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;

public class Main {

        @BeforeMethod
        public void beforeMethod() {

            System.out.println(" Test start on Chrome Browser");

        }

        //test 1 browser = chrome
        @Test
        public void Chrome_browser_Test() throws InterruptedException {


            //link external input source
            System.out.println("Launching Google Chrome browser");
            //set the chrome path
            setProperty("webdriver.chrome.driver", "src/test/chromedriver_linux64/chromedriver");

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            //wait is use for control the selenium flow
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get("https://www.saucedemo.com/");

            String ActualTitle = driver.getTitle();
            String ExpectedTitle = "Swag Labs";
            Assert.assertEquals(ExpectedTitle, ActualTitle);

            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");

            driver.findElement(By.id("login-button")).click();

            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

            driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

            driver.findElement(By.id("checkout")).click();

            driver.findElement(By.id("first-name")).sendKeys("rahul");


            driver.findElement(By.id("last-name")).sendKeys("kumar");

            driver.findElement(By.id("postal-code")).sendKeys("25000");
            driver.findElement(By.id("continue")).click();

            driver.findElement(By.id("finish")).click();

            Assert.assertEquals("THANK YOU FOR YOUR ORDER", driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText());



        }

        @AfterMethod
        public void afterMethod() {
            //driver.close();
            System.out.println("Finished Test On Chrome Browser");
        }
    }
