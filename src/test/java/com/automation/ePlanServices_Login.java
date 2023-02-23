package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;


public class ePlanServices_Login {

    @Test
    public void SuccessfulLogin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C://Users//vipra//Downloads//chromedriver_win32//chromedriver.exe");
        // WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://secure.eplanservices401k.com");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement signIn = driver.findElement(By.xpath("//a[contains(text(),' Sign In')]"));
        signIn.click();

        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("vpatel");

        //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(2000);

        WebElement passWord = driver.findElement(By.name("password"));
        passWord.sendKeys("Abcdefg123");

        Thread.sleep(2000);

        WebElement signInBtn = driver.findElement(By.id("loginButton"));
        signInBtn.click();

        Thread.sleep(2000);

        WebElement secQue = driver.findElement(By.name("securityAnswer"));
        secQue.sendKeys("ePlan");

        Thread.sleep(2000);

        WebElement submitBtn = driver.findElement(By.id("submitButton"));
        submitBtn.click();
        Thread.sleep(2000);
        String expectedUrl = "https://secure.eplanservices401k.com/PROD/eplan_ui/#/participant/dashboard";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl,"dashboard url doesn't match");

        System.out.println("The page url has been successfully verified");
        System.out.println("user logged in successfully");

        WebElement pName = driver.findElement(By.id("profileName"));
        pName.click();

        WebElement signOut = driver.findElement(By.xpath("//a[contains(text(),'Sign out')]"));
        signOut.click();

        driver.close();
    }

}

