package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

//Dynamic Controls
//        Найти чекбокс
//        Нажать на кнопку
//        Дождаться надписи “It’s gone”
//        Проверить, что чекбокса нет
//        Найти инпут
//        Проверить, что он disabled
//        Нажать на кнопку
//        Дождаться надписи “It's enabled!”
//        Проверить, что инпут enabled
public class HerokuAppDynamicControlsTest {

    @Test
    public void removeAndAddDynamicControlsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkBox = driver.findElement(By.xpath("//*[@id='checkbox']/input"));
        WebElement removeButton = driver.findElement(By.xpath("//*[@id='checkbox-example']/button"));
        checkBox.isDisplayed();
        removeButton.click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='message']"), "It's gone!"));
        int numberOfElements = driver.findElements(By.xpath("//*[@id='checkbox']/input")).size();
        Assert.assertEquals(numberOfElements, 0);
        driver.quit();
    }

    @Test
    public void enableAndDisableDynamicControlsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement inputField = driver.findElement(By.xpath("//*[@id='input-example']/input"));
        inputField.getAttribute("disabled");
        WebElement enableDisableButton = driver.findElement(By.xpath("//*[@id='input-example']/button"));
        enableDisableButton.click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//p[@id='message']"), "It's enabled!"));
        Assert.assertNull(inputField.getAttribute("disabled"));
        driver.quit();
    }
}
