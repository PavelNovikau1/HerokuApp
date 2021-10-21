package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

// b. Checkboxes - проверить, что первый чекбокс unchecked, отметить первый чекбокс,
// проверить что он checked. Проверить, что второй чекбокс checked,
// сделать unheck, проверить, что он unchecked
//Локатор By.cssSelector(“[type=checkbox]”)
public class HerokuAppCheckBoxesTest {
    @Test
    public void checkBoxesTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement firstCheckBox = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        Assert.assertFalse(firstCheckBox.isSelected());
        firstCheckBox.click();
        Assert.assertTrue(firstCheckBox.isSelected());
        WebElement secondCheckBox = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
        Assert.assertTrue(secondCheckBox.isSelected());
        secondCheckBox.click();
        Assert.assertFalse(secondCheckBox.isSelected());
        driver.quit();
    }
}
