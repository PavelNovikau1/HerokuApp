package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

// c. Dropdown - Взять все элементы дроп-дауна и проверить их наличие.
// Выбрать первый, проверить, что он выбран, выбрать второй, проверить, что он выбран
// Локатор By.id(“dropdown”)
public class HerokuAppDropdownTest {
    @Test
    public void dropdownTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdownButton = driver.findElement(By.id("dropdown"));
        dropdownButton.click();
        WebElement optionOne = driver.findElement(By.xpath("//*[@id='dropdown']/option[2]"));
        optionOne.click();
        Assert.assertTrue(optionOne.isSelected());
        dropdownButton.click();
        WebElement optionTwo = driver.findElement(By.xpath("//*[@id='dropdown']/option[3]"));
        optionTwo.click();
        Assert.assertTrue(optionTwo.isSelected());
        driver.quit();
    }
}
