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

    private void checkEquation(WebDriver driver, String equation, String result) {
        // equation
//        driver.findElement(By.xpath("//div[contains(@id, 'root')]//section/form//input")).sendKeys(equation);
        driver.findElement(By.className("_3mX7MD-u")).sendKeys(equation);
        // button
        //        driver.findElement(By.xpath("//div[contains(@id, 'root')]//section/form//button")).click();
//        driver.findElement(By.className("_2HkkNXzH")).click();
//        util.tryClick(driver, By.className("_2HkkNXzH _1caL4O8E _3nvo6gir"));
        util.tryClick(driver, By.xpath("//button[@class='_2HkkNXzH _1caL4O8E _3nvo6gir']"));
        // equation
//        String equationValue = driver.findElement(By.xpath("(/html/body/div[@id='root']//main//section[@tabindex='0']/div)[0]/img")).getAttribute("alt");
        String equationValue = driver.findElement(By.xpath("(//img[@class='ZbCdqua6'])[1]")).getAttribute("alt");
        Assert.assertEquals(equation, equationValue);
        // result
//        String resultValue = driver.findElement(By.xpath("(/html/body/div[@id='root']//main//section[@tabindex='0']/div)[1]/img")).getAttribute("alt");
        String resultValue = driver.findElement(By.xpath("(//img[@class='ZbCdqua6'])[2]")).getAttribute("alt");
        Assert.assertTrue(resultValue.contains(result));
    }

    @Test
    public void check2plus2() throws Exception {
        checkEquation(firefoxDriver, "2 + 2", "4");
        checkEquation(chromeDriver, "2 + 2", "4");
    }

    @Test
    public void CheckLongExpression() throws Exception {
        checkEquation(chromeDriver, "(1/19 (315×6 + 2×5))×0.01", "1");
        checkEquation(firefoxDriver, "(1/19 (315×6 + 2×5))×0.01", "1");
    }

    @Test
    public void CheckBase16() throws Exception {
        checkEquation(chromeDriver, "convert 15 to base16", "f_16");
        checkEquation(firefoxDriver, "convert 15 to base16", "f_16");
    }

    @Test
    public void CheckCaloricValue() throws Exception {
        checkEquation(chromeDriver, "peanut butter | amount | 10 grams", "mass | 10 grams");
        checkEquation(firefoxDriver, "peanut butter | amount | 10 grams", "mass | 10 grams");
    }
}