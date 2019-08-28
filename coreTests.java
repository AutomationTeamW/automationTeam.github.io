package Selenium;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.io.File;
import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class coreTests {

    private static final int MAUSE_LEFT = 0;
    private static final int MAUSE_RIGHT = 2;
    private static final int PAGE_LOAD_TIME = 120;

   // private static final String BASE_URL = "http://bluecom:Blu3c0m2019@wacom.dev.bluecomvn.com/";
   private static final String BASE_URL = "http://integration-5ojmyuq-pdneyozyxyelg.eu-3.magentosite.cloud";
    private static final By LOGIN_URL = By.cssSelector("a[class='header__action__icon header__action__icon--login']");
    private static final By WACOM_LOGO = By.cssSelector("a[class='logo']");
    private static final By COOKIE_BUTTON = By.cssSelector("button[id='btn-cookie-allow']");

    @Test(alwaysRun = true)
    public synchronized void verifyGlobalElements(){

        System.setProperty("webdriver.chrome.driver","C:\\Automation\\lib\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIME, TimeUnit.SECONDS);

        //Click the cookie button
        driver.findElement(COOKIE_BUTTON).click();


        Assert.assertTrue(driver.findElement(WACOM_LOGO).isDisplayed(),"Element is not displayed");


            driver.findElement(LOGIN_URL).click();


        WebDriverWait wait=new WebDriverWait(driver, 20);
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#gigya-loginID-104250615426468660")));

            Assert.assertTrue(driver.findElement(By.cssSelector("#gigya-loginID-104250615426468660")).isDisplayed(),"Element is not displayed");




        driver.findElement(By.cssSelector("#gigya-loginID-104250615426468660")).sendKeys("molya.vlez@abv.bg");
        driver.findElement(By.cssSelector("#gigya-loginID-104250615426468660")).sendKeys(Keys.RETURN);
        driver.findElement(By.cssSelector("#gigya-password-47535563830332020")).sendKeys("T@st1234");
        driver.findElement(By.cssSelector("#gigya-password-47535563830332020")).sendKeys(Keys.RETURN);
       // driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    @Test(alwaysRun = true)
    public void testLogin(String userName, String password) {

        System.setProperty("webdriver.chrome.driver","C:\\Automationlib\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.findElement(LOGIN_URL).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("#gigya-loginID-104250615426468660")).isDisplayed(),"Element is not displayed");

        driver.findElement(By.cssSelector("#gigya-loginID-104250615426468660")).sendKeys("Molya.Vlez@gmal.com");
        driver.findElement(By.cssSelector("#gigya-loginID-104250615426468660")).sendKeys(Keys.RETURN);
        driver.findElement(By.cssSelector("#gigya-password-47535563830332020")).sendKeys("T@st1234");
        driver.findElement(By.cssSelector("#gigya-password-47535563830332020")).sendKeys(Keys.RETURN);
        driver.findElement(By.cssSelector("input[type='submit']")).click();

    }


}



