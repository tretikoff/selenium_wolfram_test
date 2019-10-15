package lab;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class AuthorizationTest {
    private Util util;

    private void doSuccessfulLogin(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        util.prepare(driver);
        util.auth(driver, util.getCorrectLogin(), util.getCorrectPassword());

        doLogin(driver, "pukoh@mail.ru", "8FBN7j3Jh,fmk3Q");
//        driver.findElement(By.cssSelector(".\\_1MOABRzM > span > span")).click();

//        util.tryClick(driver, By.xpath("//button[contains(@class, 'js-top-nav-sub')]"));
//        driver.findElement(By.linkText("Выход")).click();
        driver.quit();
    }

    private void doLogin(WebDriver driver, String email, String password) {
        util.tryClick(driver, By.xpath("//header//nav//button//span[text()='Sign in']/../.."));

        driver.findElement(By.id("create-account")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("first-name")).click();
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("Konstantin");
        driver.findElement(By.id("lastName")).sendKeys("Tretyakov");
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("passwordConfirm")).sendKeys("8FBN7j3Jh,fmk3Q");
        driver.findElement(By.id("accountAgreement1")).click();
        driver.findElement(By.id("create-id-btn")).click();
    }

//    private void register(WebDriver driver) {
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        util.prepare(driver);
//        util.auth(driver, util.getCorrectLogin(), util.getCorrectPassword());
//
////        WebDriverWait wait = new WebDriverWait(driver, 10);
////        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'js-top-nav-sub')]")));
////        util.tryClick(driver, By.xpath("//button[contains(@class, 'js-top-nav-sub')]"));
////        driver.findElement(By.linkText("Выход")).click();
////        driver.quit();
//
//        driver.manage().window().setSize(new Dimension(974, 1040));
//        driver.findElement(By.cssSelector(".\\_1MOABRzM > span > span")).click();
//        driver.findElement(By.id("create-account")).click();
//        driver.findElement(By.id("email")).sendKeys("asdg" + "@mailinator.com");
//        driver.findElement(By.id("firstName")).sendKeys("asdg");
//        driver.findElement(By.id("lastName")).sendKeys("asdg");
//        driver.findElement(By.id("password")).sendKeys("8FBN7j3Jh,fmk3Q");
//        driver.findElement(By.id("passwordConfirm")).sendKeys("8FBN7j3Jh,fmk3Q");
//        driver.findElement(By.id("accountAgreement1")).click();
//        driver.findElement(By.id("create-id-btn")).click();
//    }

    private void doWrongLogin(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        util.prepare(driver);
        util.auth(driver, util.getCorrectLogin(), "asdasdasd");
        assertEquals(true, util.isElementPresent(driver, By.cssSelector("span.field-validation-error")));
        driver.quit();
    }

    @Before
    public void setUp() throws Exception {
        util = new Util();
    }

    @Test
    public void successfulLogin() throws Exception {
//        doSuccessfulLogin(new FirefoxDriver());
        doSuccessfulLogin(new ChromeDriver());
    }

    @Test
    public void wrongPassword() throws Exception {
//        doWrongLogin(new FirefoxDriver());
        doWrongLogin(new ChromeDriver());
    }

    /*
    * package lab;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;

public class AuthorizationTest {
    private WebDriver driver;
    private Util util = new Util();

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        util.prepare(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void registration() {
        driver.get("https://www.wolframalpha.com/");
        driver.manage().window().setSize(new Dimension(974, 1040));
        driver.findElement(By.cssSelector(".\\_1MOABRzM > span > span")).click();
        driver.findElement(By.id("create-account")).click();
//        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("asdg" + "@mailinator.com");
//        driver.findElement(By.id("first-name")).click();
//        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("asdg");
        driver.findElement(By.id("lastName")).sendKeys("asdg");
        driver.findElement(By.id("password")).sendKeys("8FBN7j3Jh,fmk3Q");
        driver.findElement(By.id("passwordConfirm")).sendKeys("8FBN7j3Jh,fmk3Q");
        driver.findElement(By.id("accountAgreement1")).click();
        driver.findElement(By.id("create-id-btn")).click();
    }

    @Test
    public void login() {
        driver.get("https://www.wolframalpha.com/");
        driver.manage().window().setSize(new Dimension(974, 1040));
        driver.findElement(By.cssSelector(".\\_1MOABRzM > span > span")).click();
        driver.findElement(By.id("create-account")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("pukoh@mail.ru");
        driver.findElement(By.id("first-name")).click();
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("Konstantin");
        driver.findElement(By.id("lastName")).sendKeys("Tretyakov");
        driver.findElement(By.id("password")).sendKeys("8FBN7j3Jh,fmk3Q");
        driver.findElement(By.id("passwordConfirm")).sendKeys("8FBN7j3Jh,fmk3Q");
        driver.findElement(By.id("accountAgreement1")).click();
        driver.findElement(By.id("create-id-btn")).click();
    }

    @Test
    public void logout() {
        driver.get("https://www.wolframalpha.com/");
        driver.manage().window().setSize(new Dimension(974, 1040));
        driver.findElement(By.cssSelector(".\\_1MOABRzM > span > span")).click();
        driver.findElement(By.name("j_username")).sendKeys("pukoh@mail.ru");
        driver.findElement(By.name("j_password")).sendKeys("8FBN7j3Jh,fmk3Q");
        driver.findElement(By.id("sign-in-btn")).click();
        driver.findElement(By.cssSelector(".gWfHfTZi > .\\_3ci9dP6l")).click();
        driver.findElement(By.cssSelector(".\\_3ezZZ_kp:nth-child(9) > .\\_2HkkNXzH")).click();
        driver.close();
    }
}
*/
}