package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

//  a.Add/Remove Elements - добавить 2 элемента, удалить элемент, проверить количество элементов
//        Локаторы xpath:
//        By.xpath(“//button[text()=’Add Element’]”)
//        By.xpath(“//*[text()=’Add Element’]”)
//        By.xpath(“//*[@onclick=’addElement()’]”)
public class HerokuAppAddRemoveElementsTest {

    @Test
    public void addRemoveElementsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement buttonAddElement = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        for (int i = 1; i <= 2; i++) {
            buttonAddElement.click();
        }
        WebElement addedButton = driver.findElement(By.className("added-manually"));
        addedButton.click();
        List<WebElement> remainingButtons = driver.findElements(By.className("added-manually"));
        Assert.assertEquals(remainingButtons.size(), 1);
        driver.quit();
    }
}
