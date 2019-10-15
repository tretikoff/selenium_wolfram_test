package lab;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class AuthorizationTest {
    private Util util;
    private ChromeDriver chromeDriver;
    private FirefoxDriver firefoxDriver;

    @Before
    public void setUp() throws Exception {
        util = new Util();
        chromeDriver = new ChromeDriver();
        util.prepare(chromeDriver);
        firefoxDriver = new FirefoxDriver();
        util.prepare(firefoxDriver);
    }

    @After
    public void tearDown() {
        chromeDriver.quit();
        firefoxDriver.quit();
    }

    private void doRegister(WebDriver driver, String email, String password) {
        util.tryClick(driver, By.xpath("//button[@class='_2HkkNXzH _1MOABRzM gWLqKuPt']"));
        util.tryClick(driver, By.xpath("//a[@href='create']"));
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Firstname");
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Lastname");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='passwordConfirm']")).sendKeys(password);

        driver.findElement(By.className("agreement_checkbox")).sendKeys(password);
        util.tryClick(driver, By.xpath("//button[@type='submit']"));
    }

    private void doLogin(WebDriver driver, String email, String password) {
        util.tryClick(driver, By.xpath("//button[@class='_2HkkNXzH _1MOABRzM gWLqKuPt']"));
        driver.findElement(By.xpath("//input[@class='form-control'][@path='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@class='form-control'][@path='password']")).sendKeys(password);
        util.tryClick(driver, By.xpath("//button[@type='submit']"));
    }

    private void doLogOut(WebDriver driver) {
        driver.findElement(By.xpath("(//button[@class='_2HkkNXzH gWfHfTZi _1Dl0a26V'])[3]")).click();
        util.tryClick(driver, By.xpath("//button[@class='_2HkkNXzH gWfHfTZi i_HuwTyc']"));
    }

    @Test
    public void successfulLogin() throws Exception {
        doLogin(chromeDriver, util.getCorrectLogin(), util.getCorrectPassword());
        util.waitPresent(chromeDriver, By.className("_3ci9dP6l"));

        doLogin(firefoxDriver, util.getCorrectLogin(), util.getCorrectPassword());
        util.waitPresent(firefoxDriver, By.className("_3ci9dP6l"));
    }

    @Test
    public void successfulRegister() {
        doRegister(chromeDriver, util.getRandomString(10) + "@mail.ru", util.getCorrectPassword());
        doRegister(firefoxDriver, util.getRandomString(10) + "@mail.ru", util.getCorrectPassword());
    }

    @Test
    public void failedRegister() {
        doRegister(chromeDriver, util.getRandomString(10) + "@!!!!.ru", util.getCorrectPassword());
        chromeDriver.findElement(By.className("alert-danger"));
        doRegister(firefoxDriver, util.getRandomString(10) + "@!!!!.ru", util.getCorrectPassword());
        chromeDriver.findElement(By.className("alert-danger"));
    }

    @Test
    public void wrongPasswordLogin() {
        doRegister(chromeDriver, util.getCorrectLogin(), "wrong_password");
        chromeDriver.findElement(By.className("alert-danger"));
        doRegister(firefoxDriver, util.getCorrectLogin(), "wrong_password");
        firefoxDriver.findElement(By.className("alert-danger"));
    }

    @Test
    public void wrongEmailLogin() {
        doLogin(chromeDriver, util.getRandomString(10) + "@!!!.ru", util.getCorrectPassword());
        chromeDriver.findElement(By.className("alert-danger"));
        doLogin(firefoxDriver, "non-existent@!!!!.ru", util.getCorrectPassword());
        firefoxDriver.findElement(By.className("alert-danger"));
    }

    @Test
    public void logOut() throws Exception {
        doLogin(chromeDriver, util.getCorrectLogin(), util.getCorrectPassword());
        doLogOut(chromeDriver);
        doLogin(firefoxDriver, util.getCorrectLogin(), util.getCorrectPassword());
        doLogOut(firefoxDriver);
    }
}