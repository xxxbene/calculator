package com.ebenhaezer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage {
    private WebDriver driver;

    // locator buat si element dari kalkulatornya
    private By number1Field = By.id("number1");
    private By number2Field = By.id("number2");
    private By addButton = By.id("add");
    private By substractButton = By.id("substract");
    private By multiplyButton = By.id("multiply");
    private By divideButton = By.id("divide");
    private By resultText = By.id("result");

    // pondasi buat si calculatorpagenya
    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    // nunggu element muncul
    private WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // masukin angka pertama
    public void enterFirstNumber(String number) {
        waitForElement(number1Field).sendKeys(number);
    }

    // msaukin angka kedua
    public void enterSecondNumber(String number) {
        waitForElement(number2Field).sendKeys(number);
    }

    // klik tombol tambah
    public void clickAdd() {
        waitForElement(addButton).click();
    }

    // klik tombol kurang
    public void clickSubstract() {
        waitForElement(substractButton).click();
    }

    // klik tombol kali
    public void clickMultiply() {
        waitForElement(multiplyButton).click();
    }

    // klik tombol bagi
    public void clickDivide() {
        waitForElement(divideButton).click();
    }

    // ngedapetin hasil
    public String getResult() {
        return waitForElement(resultText).getText();
    }
}
