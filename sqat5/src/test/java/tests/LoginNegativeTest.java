package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginNegativeTest extends BaseTest {

    @Test
    public void loginWithInvalidCredentials() {

        // Вводим неверные логин и пароль
        driver.findElement(By.id("user-name")).sendKeys("invalid_user");
        driver.findElement(By.id("password")).sendKeys("wrong_password");
        driver.findElement(By.id("login-button")).click();

        // Проверяем, что появилась ошибка
        boolean errorDisplayed = driver.findElements(By.cssSelector("h3[data-test='error']")).size() > 0;

        // ASSERT — если нет ошибки, тест упадёт
        Assert.assertTrue(errorDisplayed, "Error message is NOT displayed for invalid login");

        // Скрин будет автоматически создан Listener’ом
    }
}
