package com.prueba.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// page_url = https://www.jetbrains.com/
public class MainPage {




    @FindBy(xpath="//*[@id=\"webpack-dev-server-client-overlay-div\"]/button")
    private WebElement dismissButton;

    @FindBy(xpath = "//*[@id=\"webpack-dev-server-client-overlay\"]")
    private WebElement iframeError;

    @FindBy(xpath = "//*[@data-testid='monster-5']")
    public WebElement monsterFive;

    @FindBy(xpath = "//*[@data-testid='btn-create-monster']")
    private WebElement createMonsterButton;

    @FindBy(xpath = "//*[@data-testid='app-name']")
    private WebElement pageLbl;

    @FindBy(xpath = "//*[@data-testid='dynamic-title']")
    private WebElement dinamicTitle;

    @FindBy(name = "name")
    private WebElement nameInput;

    @FindBy(name = "hp")
    private WebElement hpInput;

    @FindBy(name = "defense")
    private WebElement defenseInput;

    @FindBy(name = "speed")
    private WebElement speedInput;

    @FindBy(name = "attack")
    private WebElement attackInput;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void dismissError(WebDriver driver){
        driver.switchTo().frame(iframeError);
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(
                ExpectedConditions.elementToBeClickable(dismissButton)).click();
    }

    public void setName(String name){
        nameInput.sendKeys(name);
    }

    public void setHp(String hp) {hpInput.sendKeys(String.valueOf(hp));}

    public void setDefense(String defense){defenseInput.sendKeys(String.valueOf(defense));}

    public void setSpeed(String speed){speedInput.sendKeys(String.valueOf(speed));}

    public void setAttack(String attack){attackInput.sendKeys(String.valueOf(attack));}

    public void clickCreateMonsterButton(){createMonsterButton.click();}

    public String getDinamicTitle(){return dinamicTitle.getText();}
}
