package com.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Nopcommerce {

    private WebDriver driver;

    @Before
    public void invokeBrowser() throws Exception {
        //Setting Chrome browser
        System.setProperty("web.chrome.driver", "chrome.exe");

        driver = new ChromeDriver(

        );
        //Opening the home page
        driver.get("http://demo.nopcommerce.com/register");
        driver.manage().window().maximize();


        //Setting TimeOut
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void userInRegistration() {

        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Muhammad");
        driver.findElement(By.id("LastName")).sendKeys("ali");
        Select dropdown = new Select(driver.findElement(By.name("DateOfBirthDay")));
        dropdown.selectByIndex(10);
        Select dropdown1 = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        dropdown1.selectByVisibleText("March");
        Select dropdown2 = new Select(driver.findElement(By.name("DateOfBirthYear")));
        dropdown2.selectByVisibleText("1985");
        driver.findElement(By.id("Email")).sendKeys("max@mail.com");
        driver.findElement(By.id("Company")).sendKeys("Max ltd");
        driver.findElement(By.id("Newsletter")).click();
        driver.findElement(By.id("Password")).sendKeys("abc123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("abc123");
        driver.findElement(By.id("register-button")).click();
        Assert.assertTrue(driver.findElement(By.id("")).isDisplayed());
    }
    @After
    public void closeBrowser()
    {
        driver.quit();
    }

}


