package lab;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.TimeUnit;


class Util {
    String getBaseUrl() {
        return baseUrl;
    }

    private String baseUrl;

    String getCorrectLogin() {
        return "pukoh@mail.ru";
    }

    String getCorrectPassword() {
        return "8FBN7j3Jh,fmk3Q";
    }

    Util() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        baseUrl = "https://www.wolframalpha.com/";
    }

    void prepare(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(getBaseUrl());
    }

    boolean isElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    void tryClick(WebDriver driver, By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));

        element.sendKeys(Keys.ENTER);
    }

    void auth(WebDriver driver, String login, String password) {

        String loginPath = "input[name=login].c-top-loginform__input";
        String passwordPath = "input[name=password].c-top-loginform__input";
        driver.findElement(By.xpath("//button[@onclick=\"yaCounter.reachGoal('login_from_top_by_email'); return true;\"]")).click();
        driver.findElement(By.cssSelector(loginPath)).clear();
        driver.findElement(By.cssSelector(loginPath)).sendKeys(login);
        driver.findElement(By.cssSelector(passwordPath));
        driver.findElement(By.cssSelector(passwordPath)).sendKeys(password);
        driver.findElement(By.xpath("(//button[@type='submit'])[4]")).click();
    }

    String getRandomString() {
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }
}