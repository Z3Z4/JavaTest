package App.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;


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
    public void payFormsConnectionPlaceHolderTextTest() {
        WebElement connectionPhone = driver.findElement(new By.ById("connection-phone"));
        assertEquals("Номер телефона", connectionPhone.getAttribute("placeholder"));
        WebElement connectionSum = driver.findElement(new By.ById("connection-sum"));
        assertEquals("Сумма", connectionSum.getAttribute("placeholder"));
        WebElement connectionEmail = driver.findElement(new By.ById("connection-email"));
        assertEquals("E-mail для отправки чека", connectionEmail.getAttribute("placeholder"));
        WebElement selectMenu = driver.findElement(new By.ByXPath("//div[@class='select__wrapper']//button"));
        selectMenu.click();
        //Internet
        WebElement selectMenuHomeInternet = driver.findElement(new By.ByXPath("//div[@class='select__wrapper opened']//ul//li[2]"));
        selectMenuHomeInternet.click();
        WebElement internetPhone = driver.findElement(new By.ById("internet-phone"));
        assertEquals("Номер абонента", internetPhone.getAttribute("placeholder"));
        WebElement internetSum = driver.findElement(new By.ById("internet-sum"));
        assertEquals("Сумма", internetSum.getAttribute("placeholder"));
        WebElement internetEmail = driver.findElement(new By.ById("internet-email"));
        assertEquals("E-mail для отправки чека", internetEmail.getAttribute("placeholder"));
        selectMenu.click();
        //Loan
        WebElement selectMenuLoan = driver.findElement(new By.ByXPath("//div[@class='select__wrapper opened']//ul//li[3]"));
        selectMenuLoan.click();
        WebElement scoreInstalment = driver.findElement(new By.ById("score-instalment"));
        assertEquals("Номер счета на 44", scoreInstalment.getAttribute("placeholder"));
        WebElement instalmentSum = driver.findElement(new By.ById("instalment-sum"));
        assertEquals("Сумма", instalmentSum.getAttribute("placeholder"));
        WebElement instalmentEmail = driver.findElement(new By.ById("instalment-email"));
        assertEquals("E-mail для отправки чека", instalmentEmail.getAttribute("placeholder"));
        //Arrears
        selectMenu.click();
        WebElement selectMenuDebt = driver.findElement(new By.ByXPath("//div[@class='select__wrapper opened']//ul//li[4]"));
        selectMenuDebt.click();
        WebElement scoreArrears = driver.findElement(new By.ById("score-arrears"));
        assertEquals("Номер счета на 2073", scoreArrears.getAttribute("placeholder"));
        WebElement arrearsSum = driver.findElement(new By.ById("arrears-sum"));
        assertEquals("Сумма", arrearsSum.getAttribute("placeholder"));
        WebElement arrearsEmail = driver.findElement(new By.ById("arrears-email"));
        assertEquals("E-mail для отправки чека", arrearsEmail.getAttribute("placeholder"));
    }

    @Test
    @Order(3)
    public void payWrapperIsCorrectSumTest() throws InterruptedException {
        WebElement selectMenu = driver.findElement(new By.ByXPath("//div[@class='select__wrapper']//button"));
        selectMenu.click();
        WebElement selectMenuCommunication = driver.findElement(new By.ByXPath("//div[@class='select__wrapper opened']//ul//li[1]"));
        selectMenuCommunication.click();
        WebElement connectionPhone = driver.findElement(new By.ById("connection-phone"));
        connectionPhone.sendKeys("297777777");
        WebElement connectionSum = driver.findElement(new By.ById("connection-sum"));
        connectionSum.sendKeys("100.00 BYN");
        WebElement payWrapperContinueButton = driver.findElement(new By.ByXPath("//div[@class='pay__forms']//button"));
        payWrapperContinueButton.click();
        Thread.sleep(5000);
        WebElement allowPaymentRequestFrame = driver.findElement(new By.ByXPath("//iframe[@src='https://checkout.bepaid.by/widget_v2/index.html']"));
        driver.switchTo().frame(allowPaymentRequestFrame);
        WebElement payWrapperSum = driver.findElement(new By.ByXPath("//div[@class='pay-description__cost']//span[1]"));
        assertEquals("100.00 BYN", payWrapperSum.getText());
        WebElement submitButtonSum = driver.findElement(new By.ByXPath("//div[@class='card-page__card']//button"));
        assertEquals("Оплатить 100.00 BYN", submitButtonSum.getText());
    }

    @Test
    @Order(4)
    public void payWrapperIsCorrectFieldsTest() {
        WebElement phoneNumber = driver.findElement(new By.ByXPath("//div[@class='pay-description__text']//span"));

        assertEquals("Оплата: Услуги связи Номер:375297777777", phoneNumber.getText());
        WebElement cardNumberPlaceHolderText = driver.findElement(new By.ByXPath("//*[contains(text(),'Номер карты')]"));

        assertEquals("Номер карты", cardNumberPlaceHolderText.getText());
        WebElement cardExpiryDatePlaceHolderText = driver.findElement(new By.ByXPath("//*[contains(text(),'Срок действия')]"));

        assertEquals("Срок действия", cardExpiryDatePlaceHolderText.getText());
        WebElement CVCPlaceHolderText = driver.findElement(new By.ByXPath("//*[text()='CVC']"));

        assertEquals("CVC", CVCPlaceHolderText.getText());
        WebElement cardHolderNamePlaceHolderText = driver.findElement(new By.ByXPath("//*[text()='Имя держателя (как на карте)']"));

        assertEquals("Имя держателя (как на карте)", cardHolderNamePlaceHolderText.getText());
    }
    @Test
    @Order(5)
    public void payPartnersIconsTest() {
        WebElement payPartnersLogoMasterCard = driver.findElement(new By.ByXPath("//*[contains(@class, 'cards-brands__container')]//img[1]"));
        int height1 = payPartnersLogoMasterCard.getSize().height;
        int width1 = payPartnersLogoMasterCard.getSize().width;
        Assertions.assertTrue(height1 > 0);
        Assertions.assertTrue(width1 > 0);
        WebElement payPartnersLogoVisa = driver.findElement(new By.ByXPath("//*[contains(@class, 'cards-brands__container')]//img[2]"));
        int height2 = payPartnersLogoMasterCard.getSize().height;
        int width2 = payPartnersLogoMasterCard.getSize().width;
        Assertions.assertTrue(height2 > 0);
        Assertions.assertTrue(width2 > 0);
        WebElement payPartnersLogoBelcart = driver.findElement(new By.ByXPath("//*[contains(@class, 'cards-brands__container')]//img[3]"));
        int height3 = payPartnersLogoMasterCard.getSize().height;
        int width3 = payPartnersLogoMasterCard.getSize().width;
        Assertions.assertTrue(height3 > 0);
        Assertions.assertTrue(width3 > 0);

        WebElement payPartnersLogoRandom1 = driver.findElement(new By.ByXPath("//*[contains(@class, 'cards-brands cards-brands_random')]//img[1]"));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> payPartnersLogoRandom1.isDisplayed());
        Assertions.assertTrue(payPartnersLogoRandom1.isDisplayed());
        WebElement payPartnersLogoRandom2 = driver.findElement(new By.ByXPath("//*[contains(@class, 'cards-brands cards-brands_random')]//img[2]"));
        wait.until(d -> payPartnersLogoRandom2.isDisplayed());
        Assertions.assertTrue(payPartnersLogoRandom2.isDisplayed());
    }

    @Test
    @Order(7)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
