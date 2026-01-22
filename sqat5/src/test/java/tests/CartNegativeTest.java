package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartNegativeTest extends BaseTest {

    @Test
    public void cartShouldBeEmptyInitially() {

        driver.findElement(By.className("shopping_cart_link")).click();

        boolean cartIsEmpty = driver.findElements(
                By.className("cart_item")
        ).isEmpty();

        Assert.assertTrue(
                cartIsEmpty,
                "Cart is NOT empty initially"
        );
    }
}

