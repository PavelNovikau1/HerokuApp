package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertFalse;

//* Hovers - Сделать цепочку из действий: наведение на профиль,
// проверка имени, клик по ссылке, проверка, что нет 404 ошибки.
// Повторить для каждого из профилей. Использовать класс Actions;
public class HerokuAppHoversTest {

    @Test
    public void hoversTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);
        WebElement firstUserIcon = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/img"));
        action.moveToElement(firstUserIcon).build().perform();
        WebElement firstUserInfo = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/h5"));
        Assert.assertEquals(firstUserInfo.getText(), "name: user1");
        WebElement firstUserViewProfile = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/a"));
        firstUserViewProfile.click();
        assertFalse(driver.getTitle().contains("404"));
        driver.navigate().back();
        WebElement secondUserIcon = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/img"));
        action.moveToElement(secondUserIcon).build().perform();
        WebElement secondUserInfo = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/h5"));
        Assert.assertEquals(secondUserInfo.getText(), "name: user2");
        WebElement secondUserViewProfile = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/a"));
        secondUserViewProfile.click();
        assertFalse(driver.getTitle().contains("404"));
        driver.navigate().back();
        WebElement thirdUserIcon = driver.findElement(By.xpath("//*[@id='content']/div/div[3]/img"));
        action.moveToElement(thirdUserIcon).build().perform();
        WebElement thirdUserInfo = driver.findElement(By.xpath("//*[@id='content']/div/div[3]/div/h5"));
        Assert.assertEquals(thirdUserInfo.getText(), "name: user3");
        WebElement thirdUserViewProfile = driver.findElement(By.xpath("//*[@id='content']/div/div[3]/div/a"));
        thirdUserViewProfile.click();
        assertFalse(driver.getTitle().contains("404"));
        driver.quit();
    }
}
