package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

//Context Menu
//        Правый клик по элементу
//        Валидация текста на алерте
//        Закрытие алерта
public class HerokuAppContextMenuTest {

    @Test
    public void appContextMenuTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        actions.contextClick(elementLocator).perform();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().getText();
        Assert.assertEquals(driver.switchTo().alert().getText(), "You selected a context menu");
        driver.switchTo().alert().accept();
        driver.quit();
    }
}
