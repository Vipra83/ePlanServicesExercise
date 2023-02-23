package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginWithMultipleSetsOfData {

    @Test
    public void verifyLoginCredentials() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C://Users//vipra//Downloads//chromedriver_win32//chromedriver.exe");
        // WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://secure.eplanservices401k.com");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement signIn = driver.findElement(By.xpath("//a[contains(text(),' Sign In')]"));
        signIn.click();
        Thread.sleep(2000);
        String[] expectedErrorMsgs = {"Invalid Username/Password.","Invalid Username/Password.","Account is locked due to too many failed attempts."};

        for (String expectedErrorMsg:expectedErrorMsgs) {

            WebElement uName = driver.findElement(By.name("username"));
            uName.clear();
            uName.sendKeys("vpatel");
            Thread.sleep(2000);
            WebElement passWord = driver.findElement(By.name("password"));
            passWord.clear();
            passWord.sendKeys("Abcd123");
            Thread.sleep(2000);
            WebElement signInBtn = driver.findElement(By.id("loginButton"));
            signInBtn.click();
            Thread.sleep(2000);

            String errorMessage = driver.findElement(By.cssSelector(".login-error")).getText();
            Assert.assertEquals(errorMessage,expectedErrorMsg);
        }

        driver.quit();
    }

}
