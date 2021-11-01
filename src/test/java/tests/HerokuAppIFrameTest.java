package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

//Frames
//        Открыть iFrame
//        Проверить, что текст внутри параграфа равен “Your content goes here.”
public class HerokuAppIFrameTest {

    @Test
    public void enableDisableDynamicControlsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        Assert.assertEquals(driver.findElement(By.id("tinymce")).getText(),"Your content goes here.");
        driver.quit();
    }
}
