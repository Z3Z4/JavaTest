package App.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ChromeTest {
    private static WebDriver driver;


    @BeforeAll
    public static void webDriverSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    @Order(1)
    public void authorization() {
        driver.get("https://www.mts.by/");
        WebElement cookieAgree = driver.findElement(new By.ById("cookie-agree"));
        cookieAgree.click();
    }

    @Test
    @Order(2)
    public void payWrapperTextTest() {
        WebElement payWrapperText = driver.findElement(new By.ByXPath("//div[@class='pay__wrapper']//h2"));
        String result = payWrapperText.getText();
        assertEquals("Онлайн пополнение\n" + "без комиссии", result);
    }

    @Test
    @Order(3)
    public void payPartnersLogoTest() {
        WebElement payPartnersLogoVisa = driver.findElement(new By.ByXPath("//div[@class='pay__partners']//ul//li[1]//img"));
        int height1 = payPartnersLogoVisa.getSize().height;
        int width1 = payPartnersLogoVisa.getSize().width;
        assertTrue(height1 > 0);
        assertTrue(width1 > 0);
        WebElement payPartnersLogoVBVisa = driver.findElement(new By.ByXPath("//div[@class='pay__partners']//ul//li[2]//img"));
        int height2 = payPartnersLogoVisa.getSize().height;
        int width2 = payPartnersLogoVisa.getSize().width;
        assertTrue(height2 > 0);
        assertTrue(width2 > 0);
        WebElement payPartnersLogoMasterCard = driver.findElement(new By.ByXPath("//div[@class='pay__partners']//ul//li[3]//img"));
        int height3 = payPartnersLogoVisa.getSize().height;
        int width3 = payPartnersLogoVisa.getSize().width;
        assertTrue(height3 > 0);
        assertTrue(width3 > 0);
        WebElement payPartnersLogoMasterCardSC = driver.findElement(new By.ByXPath("//div[@class='pay__partners']//ul//li[4]//img"));
        int height4 = payPartnersLogoVisa.getSize().height;
        int width4 = payPartnersLogoVisa.getSize().width;
        assertTrue(height4 > 0);
        assertTrue(width4 > 0);
        WebElement payPartnersLogoBelcard = driver.findElement(new By.ByXPath("//div[@class='pay__partners']//ul//li[5]//img"));
        int height5 = payPartnersLogoVisa.getSize().height;
        int width5 = payPartnersLogoVisa.getSize().width;
        assertTrue(height5 > 0);
        assertTrue(width5 > 0);
    }

    @Test
    @Order(4)
    public void payWrapperAboutServiceLinkTest() {
        WebElement payWrapperAboutServiceLink = driver.findElement(new By.ByXPath("//div[@class='pay__wrapper']//a"));
        payWrapperAboutServiceLink.click();
        String actualURL = driver.getCurrentUrl();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", actualURL);
    }

    @Test
    @Order(5)
    public void payWrapperContinueButtonTest() throws InterruptedException {
        driver.get("https://www.mts.by/");
        WebElement phoneInputField = driver.findElement(new By.ById("connection-phone"));
        phoneInputField.sendKeys("297777777");
        WebElement amountOfMoneyInputField = driver.findElement(new By.ById("connection-sum"));
        amountOfMoneyInputField.sendKeys("100");
        WebElement payWrapperContinueButton = driver.findElement(new By.ByXPath("//div[@class='pay__forms']//button"));
        payWrapperContinueButton.click();
        Thread.sleep(5000);
        WebElement appWrapper = driver.findElement(new By.ByXPath("//div[@class='bepaid-app__container']"));
        assertTrue(appWrapper.isDisplayed());
    }

    @Test
    @Order(6)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
