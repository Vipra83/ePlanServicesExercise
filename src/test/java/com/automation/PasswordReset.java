package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class PasswordReset {

    @Test(dataProvider = "testData")
    public void pwdReset(String userName,String password) {
        System.setProperty("webdriver.chrome.driver", "C://Users//vipra//Downloads//chromedriver_win32//chromedriver.exe");
        // WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://secure.eplanservices401k.com");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement signIn = driver.findElement(By.xpath("//a[contains(text(),' Sign In')]"));
        signIn.click();

        WebElement havingTroubleSignIn = driver.findElement(By.xpath("//a[contains(text(),'Having trouble signing in?')]"));
        havingTroubleSignIn.click();

        WebElement resetPwd = driver.findElement(By.xpath("//span[contains(text(),'Reset my password')]"));
        resetPwd.click();

        WebElement uName = driver.findElement(By.xpath("//input[@id='username']"));
        uName.sendKeys(userName);

        WebElement continueBtn = driver.findElement(By.id("continueButton"));
        continueBtn.click();

        WebElement secQue = driver.findElement(By.id("secQuestion"));
        secQue.sendKeys(password);

        WebElement finishBtn = driver.findElement(By.id("finishButton"));
        finishBtn.click();

        String expectedMsg = driver.findElement(By.xpath("//h1[contains(text(),'Your request was successful!')]")).getText();
        Assert.assertEquals(expectedMsg, "Your request was successful!");
    }

    @DataProvider(name = "testData")
    public Object[][] getData() {

        return new Object[][]{
                {"vpatel", "ePlan"},
                {"vpatel", "vPlan"},
                {"kpatel", "kPlan"}
        };
    }

}
