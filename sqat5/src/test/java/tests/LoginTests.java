package tests;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ExtentManager;

public class LoginTests extends BaseTest {

    @Test
    public void validLoginTest() throws InterruptedException {
        test = ExtentManager.getExtent().createTest("Valid Login");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(9000);
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
        test.pass("Login successful");
    }

    @Test
    public void invalidLoginTest() throws InterruptedException {
        test = ExtentManager.getExtent().createTest("Invalid Login");
        driver.findElement(By.id("user-name")).sendKeys("wrong");
        driver.findElement(By.id("password")).sendKeys("wrong");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(9000);
        Assert.assertTrue(driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed());
        test.pass("Error shown");
    }

    @Test
    public void addToCartTest() throws InterruptedException {
        test = ExtentManager.getExtent().createTest("Add to Cart");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(9000);
        Assert.assertEquals(driver.findElement(By.className("shopping_cart_badge")).getText(), "1");
        test.pass("Item added");
    }
}