package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

//* Sortable Data Tables - Проверить содержимое нескольких (3-5) ячеек таблицы.
// Использовать xpath типа //table//tr[1]//td[1] -
// получение первой ячейки из первого ряда первой таблицы и так далее.
public class HerokuAppSortableDataTablesTest {
    @Test
    public void sortableDataTablesTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement firstElementFromTable = driver.findElement(By.xpath("//*[@id='table1']//tr[1]/td[1]"));
        Assert.assertEquals(firstElementFromTable.getText(), "Smith");
        WebElement secondElementFromTable = driver.findElement(By.xpath("//*[@id='table1']//tr[1]/td[2]"));
        Assert.assertEquals(secondElementFromTable.getText(), "John");
        WebElement thirdElementFromTable = driver.findElement(By.xpath("//*[@id='table1']//tr[1]/td[3]"));
        Assert.assertEquals(thirdElementFromTable .getText(), "jsmith@gmail.com");
        WebElement fourthElementFromTable = driver.findElement(By.xpath("//*[@id='table1']//tr[1]/td[4]"));
        Assert.assertEquals(fourthElementFromTable .getText(), "$50.00");
        WebElement fifthElementFromTable = driver.findElement(By.xpath("//*[@id='table1']//tr[1]/td[5]"));
        Assert.assertEquals(fifthElementFromTable .getText(), "http://www.jsmith.com");
        driver.quit();
    }
}
