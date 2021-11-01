package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

//File Upload
//        Загрузить файл
//        Проверить, что имя файла на странице совпадает с именем загруженного файла
public class HerokuAppFileUploadTest {

    @Test
    public void fileUploadTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.findElement(By.cssSelector("#file-upload")).sendKeys("C:/Users/Pavel/IdeaProjects/QA_08onl/HerokuApp/src/test/resources/readme.txt");
        driver.findElement(By.cssSelector("#file-submit")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#uploaded-files")).getText(),"readme.txt");
        driver.quit();
    }
}
