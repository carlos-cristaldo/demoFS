package com.prueba.proyecto;

import com.prueba.pages.MainPage;
import com.prueba.utils.Constants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static com.prueba.utils.GetProperty.getProperties;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Unit test for simple App.
 */
public class AppTest {

    private WebDriver driver;
    private MainPage mainPage;
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:3000/");

        mainPage = new MainPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }






    @Test
    public void successMonsterCreation(){


        mainPage.dismissError(driver);

        mainPage.monsterFive.click();

        mainPage.setName(getProperties("name"));
        mainPage.setHp("100");
        mainPage.setDefense("100");
        mainPage.setSpeed("100");
        mainPage.setAttack("100");
        mainPage.clickCreateMonsterButton();

        logger.info(mainPage.getDinamicTitle());

        assertEquals(mainPage.getDinamicTitle(), Constants.DINAMIC_TITLE_OK, "Correct");


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
