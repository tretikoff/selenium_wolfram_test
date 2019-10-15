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

public class CalculationTest {
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

    private void checkEquation(WebDriver driver, String equation, String result) throws InterruptedException {
        checkEquation(driver, equation, result, null);
    }

    private void checkEquation(WebDriver driver, String equation, String result, String expectedEquation) throws InterruptedException {
        if (expectedEquation == null) {
            expectedEquation = equation;
        }
        // input equation
        driver.findElement(By.className("_3mX7MD-u")).sendKeys(equation);
        // click send button
        util.tryClick(driver, By.xpath("//button[@class='_2HkkNXzH _1caL4O8E _3nvo6gir']"));
        Thread.sleep(1000);
        // check equation
        String equationValue = driver.findElement(By.xpath("(//img[@class='ZbCdqua6'])[1]")).getAttribute("alt");
        Assert.assertEquals(expectedEquation, equationValue);
        // check result
        String resultValue = driver.findElement(By.xpath("(//img[@class='ZbCdqua6'])[2]")).getAttribute("alt");
        Assert.assertTrue(resultValue.contains(result));
    }

    @Test
    public void check2plus2() throws InterruptedException {
        checkEquation(firefoxDriver, "2 + 2", "4");
        checkEquation(chromeDriver, "2 + 2", "4");
    }

    @Test
    public void checkMismatchedParentheses() throws InterruptedException {
        checkEquation(firefoxDriver, "(2 + 2 * 2(", "6", "2 + 2×2");
        checkEquation(chromeDriver, "(2 + 2 * 2(", "6", "2 + 2×2");
    }

    @Test
    public void CheckLongExpression() throws InterruptedException {
        checkEquation(chromeDriver, "(1/19 (315×6 + 2×5))×0.01", "1");
        checkEquation(firefoxDriver, "(1/19 (315×6 + 2×5))×0.01", "1");
    }

    @Test
    public void CheckBase16() throws InterruptedException {
        checkEquation(chromeDriver, "convert 15 to base16", "f_16");
        checkEquation(firefoxDriver, "convert 15 to base16", "f_16");
    }

    @Test
    public void CheckCaloricValue() throws InterruptedException {
        checkEquation(chromeDriver, "peanut butter | amount | 10 grams", "mass | 10 grams");
        checkEquation(firefoxDriver, "peanut butter | amount | 10 grams", "mass | 10 grams");
    }
}