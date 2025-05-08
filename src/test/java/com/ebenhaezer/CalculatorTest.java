package com.ebenhaezer;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatorTest {
    private WebDriver driver;
    private CalculatorPage calculatorPage;

    // konfigurasi driver browser
    public static WebDriver buildDriver() {
        WebDriverManager.chromedriver().driverVersion("130.0.6723.116").setup(); // set sesuai versi yang udah punya

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Christian\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe"); // lokasi chrome for testing
        options.addArguments("--start-maximized"); // maxin jendela browser

        return new ChromeDriver(options); // return dari driver yang udah ke konfig
    }

    @BeforeClass
    public void setup() {
        driver = buildDriver(); // manggil si builddriver
        driver.get("file:///C:/Users/Christian/Documents/calculator.html"); // akses halaman kalkulator lokal
        calculatorPage = new CalculatorPage(driver); // inisiasi halaman kalkulator
    }

    @Test
    public void testAddition() {
        calculatorPage.enterFirstNumber("88");
        calculatorPage.enterSecondNumber("11");
        calculatorPage.clickAdd();
        String result = calculatorPage.getResult();
        Assert.assertEquals(result, "99"); // validasi hasil
    }

    @Test
    public void testSubstraction() {
        calculatorPage.enterFirstNumber("10");
        calculatorPage.enterSecondNumber("3");
        calculatorPage.clickSubstract();
        String result = calculatorPage.getResult();
        Assert.assertEquals(result, "7"); // validasi hasil
    }

    @Test
    public void testDivision() {
        calculatorPage.enterFirstNumber("20");
        calculatorPage.enterSecondNumber("2");
        calculatorPage.clickDivide();
        String result = calculatorPage.getResult();
        Assert.assertEquals(result, "10"); // validasi hasil
    }

    @Test
    public void testMultiplication() {
        calculatorPage.enterFirstNumber("10");
        calculatorPage.enterSecondNumber("10");
        calculatorPage.clickMultiply();
        String result = calculatorPage.getResult();
        Assert.assertEquals(result, "100"); // validasi hasil
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
