package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            Path path = Path.of(System.getProperty("user.dir"), "reports", "screenshots", name + ".png");

            Files.createDirectories(path.getParent()); // создаёт папку если нет
            Files.copy(src.toPath(), path);

            return path.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
