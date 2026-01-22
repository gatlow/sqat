package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCardPositiveTest extends BaseTest {

    @Test
    public void addCardSuccessfully() {

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        driver.findElement(By.xpath("//button[text()='Add Element']")).click();

        boolean isCardPresent = driver.findElements(
                By.className("added-manually")
        ).size() > 0;

        Assert.assertTrue(isCardPresent, "Card was NOT added!");
    }
}

