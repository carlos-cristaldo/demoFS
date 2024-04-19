package org.example.demofs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// page_url = https://www.jetbrains.com/
public class MainPage {
    @FindBy(xpath = "//*[@data-test-marker='Developer Tools']")
    public WebElement seeDeveloperToolsButton;

    @FindBy(xpath = "//*[@data-test='suggestion-action']")
    public WebElement findYourToolsButton;

    @FindBy(xpath="//*[@id=\"webpack-dev-server-client-overlay-div\"]/button")
    public WebElement dismissButton;

    @FindBy(xpath = "//*[@id=\"webpack-dev-server-client-overlay\"]")
    public WebElement iframeError;

    @FindBy(xpath = "//*[@data-testid='monster-5']")
    public WebElement monsterFive;

    @FindBy(xpath = "//*[@data-testid='app-name']")
    public WebElement pageLbl;

    @FindBy(name = "name")
    public WebElement nameInput;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void dismissError(WebDriver driver){
        driver.switchTo().frame(iframeError);

        new WebDriverWait(driver, Duration.ofSeconds(1)).until(
                ExpectedConditions.elementToBeClickable(dismissButton)).click();

    }
}
