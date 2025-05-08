package com.ebenhaezer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatorTest {
    private WebDriver driver;
    private CalculatorPage calculatorPage;

    @BeforeClass
    public void setup() {
        // pake chrome for testing
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Christian\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
        driver = new ChromeDriver();
        // Membuka file HTML kalkulator lokal
        driver.get("file:///C:/Users/Christian/Documents/calculator.html");


        calculatorPage = new CalculatorPage(driver);
    }

    @Test
    public void testAddition() {
        calculatorPage.enterFirstNumber("88");
        calculatorPage.enterSecondNumber("11");
        calculatorPage.clickAdd();
        String result = calculatorPage.getResult();
        Assert.assertEquals(result, "99");
    }

    @Test
    public void testSubstraction() {
        calculatorPage.enterFirstNumber("10");
        calculatorPage.enterSecondNumber("3");
        calculatorPage.clickSubstract();
        String result = calculatorPage.getResult();
        Assert.assertEquals(result, "7");
    }

    @Test
    public void testDivision() {
        calculatorPage.enterFirstNumber("20");
        calculatorPage.enterSecondNumber("2");
        calculatorPage.clickDivide();
        String result = calculatorPage.getResult();
        Assert.assertEquals(result, "10");
    }

    @Test
    public void testMultiplication() {
        calculatorPage.enterFirstNumber("10");
        calculatorPage.enterSecondNumber("10");
        calculatorPage.clickMultiply();
        String result = calculatorPage.getResult();
        Assert.assertEquals(result, "100");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
