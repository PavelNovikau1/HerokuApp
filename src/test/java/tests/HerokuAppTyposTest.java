package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

//f. Typos - Проверить соответствие параграфа орфографии
//Локатор By.tagName(“p”)
public class HerokuAppTyposTest {

    @Test
    public void typosTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/typos");
        WebElement element = driver.findElement(By.xpath("//p[2]"));
        Assert.assertEquals(element.getText(), "Sometimes you'll see a typo, other times you won't.");
        driver.quit();
    }
}
