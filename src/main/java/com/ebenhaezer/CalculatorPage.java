package com.ebenhaezer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage {
    private WebDriver driver;

    // locator buat si element dari kalkulatornya
    private By number1Field = By.id("num1");
    private By number2Field = By.id("num2");
    private By resultText = By.id("result");
    private By buttonCalculate = By.xpath("/html/body/button");
    private By operatorDropdown = By.id("operator");


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
        WebElement field = waitForElement (number1Field);
        field.clear();
        field.sendKeys(number);
        sleep();
    }

    // msaukin angka kedua
    public void enterSecondNumber(String number) {
        WebElement field = waitForElement (number2Field);
        field.clear();
        field.sendKeys(number);
        sleep();
    }

    // milih di dropdown
    public void operatorDropdown (String operator) {
        WebElement operatorElement = waitForElement(operatorDropdown);
        Select select = new Select(operatorElement);
        select.selectByVisibleText(operator);
        sleep();
    }

    // click calculate buttonnya
    public void clickCalculate() {
        driver.findElement(buttonCalculate).click();
        sleep();
    }

    // ngedapetin hasil
    public String getResult() {
        String resultTextRaw = waitForElement(resultText).getText();
        return resultTextRaw.replace("Result: ", "").trim();
    }

    // buat test lebih human
    private void sleep() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // buat ngeclear atau reset biar ga niban angka sebelumnya
    public void resetCalculator() {
        WebElement firstNumberField = waitForElement(number1Field);
        WebElement secondNumberField = waitForElement(number2Field);
        firstNumberField.clear();
        secondNumberField.clear();
        sleep();
    }
}
