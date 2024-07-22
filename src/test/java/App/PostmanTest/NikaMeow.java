package App.PostmanTest;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class NikaMeow {
    private static WebDriver driver;

    @BeforeAll
    private static void driverInstall() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public static void nextPageButtonClick() {
        WebElement button = driver.findElement(new By.ByXPath("//div[@class='chapters-navpanel']//a[2]"));
        if (button.isDisplayed()) {
            Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(d -> button.isDisplayed());
            button.click();
        }
    }

    @Test
    public void authorization() {
        driver.get("https://younettranslate.com/projects/liu-yao/uchitel-ushel");
    }

    @Test
    public void textArea() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("NikaKniga.txt"));
        List<WebElement> textArea = driver.findElements(new By.ByXPath("//div[@class='postdata-content fontsize fontsize3']//p"));
        for (WebElement webElement : textArea) {
            writer.write(webElement.getAttribute("textContent"));
        }
        for (int j = 0; j < 85; j++) {
            try {
                nextPageButtonClick();
            } catch (NoSuchElementException e) {
            }
            textArea = driver.findElements(new By.ByXPath("//div[@class='postdata-content fontsize fontsize3']//p"));


            for (WebElement webElement : textArea) {
                writer.write(webElement.getAttribute("textContent") + "\n");
            }


        }
    }

}






