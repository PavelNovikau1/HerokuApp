package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.pow;
import static org.testng.Assert.*;

//* (с зорачкай) Открыть файл используя Selenium
// driver.get("file:///Users/drak/IdeaProjects/InstagramBot/src/test/resources/blabla.html");
// и попробовать найти все перечисленные элементы
public class NewPageTests {

    @Test
    public void findTableOnPageTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("C:///Users/Pavel/IdeaProjects/QA_08onl/HerokuApp/src/test/resources/newPage.html");
        boolean webDriver = driver.findElement(By.id("table")).isDisplayed();
        assertTrue(webDriver);
        driver.quit();
    }

    @Test
    public void findInputFieldOnPageTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("C:///Users/Pavel/IdeaProjects/QA_08onl/HerokuApp/src/test/resources/newPage.html");
        boolean webDriver = driver.findElement(By.id("login")).isDisplayed();
        assertTrue(webDriver);
        driver.quit();
    }

    @Test
    public void findCheckBoxOnPageTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("C:///Users/Pavel/IdeaProjects/QA_08onl/HerokuApp/src/test/resources/newPage.html");
        boolean webDriver = driver.findElement(By.id("checkbox")).isDisplayed();
        assertTrue(webDriver);
        driver.quit();
    }

    @Test
    public void findDropDownListOnPageTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("C:///Users/Pavel/IdeaProjects/QA_08onl/HerokuApp/src/test/resources/newPage.html");
        boolean webDriver = driver.findElement(By.id("select cars")).isDisplayed();
        assertTrue(webDriver);
        driver.quit();
    }

    @Test
    public void findImageOnPageTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("C:///Users/Pavel/IdeaProjects/QA_08onl/HerokuApp/src/test/resources/newPage.html");
        int pictureHeight = driver.findElement(By.id("picture")).getSize().height;
        assertEquals(pictureHeight, 800);
        driver.quit();
    }

    @Test
    public void findParagraphOnPageTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("C:///Users/Pavel/IdeaProjects/QA_08onl/HerokuApp/src/test/resources/newPage.html");
        boolean webDriver = driver.findElement(By.id("paragraph")).isDisplayed();
        assertTrue(webDriver);
        driver.quit();
    }

    @Test
    public void findHyperLinkOnPageTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("C:///Users/Pavel/IdeaProjects/QA_08onl/HerokuApp/src/test/resources/newPage.html");
        boolean webDriver = driver.findElement(By.id("link")).isDisplayed();
        assertTrue(webDriver);
        driver.quit();
    }
}
