package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

//d. Inputs - Проверить на возможность ввести различные цифровые и нецифровые значения,
// используя Keys.ARROW_UP И Keys.ARROW_DOWN
//Локатор By.tagName(“input”)
public class HerokuAppInputsTest {

    @Test
    public void inputsTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.tagName("input"));
        inputField.sendKeys("1111");
        String textFromField = inputField.getAttribute("value");
        Assert.assertEquals(textFromField, "1111");
        driver.quit();
    }
}
