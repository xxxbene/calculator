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
    public void testAddition() throws InterruptedException {
        calculatorPage.enterFirstNumber("88");
        Thread.sleep(1500);
        calculatorPage.enterSecondNumber("11");
        Thread.sleep(1500);
        calculatorPage.operatorDropdown("+");
        Thread.sleep(1500);
        calculatorPage.clickCalculate();
        Thread.sleep(1500);

        String result = calculatorPage.getResult();
        Assert.assertEquals(result, "99"); // validasi hasil

        calculatorPage.resetCalculator();
    }

    @Test
    public void testSubstraction() throws InterruptedException {
        calculatorPage.enterFirstNumber("10");
        Thread.sleep(1500);
        calculatorPage.enterSecondNumber("3");
        Thread.sleep(1500);
        calculatorPage.operatorDropdown("-");
        Thread.sleep(1500);
        calculatorPage.clickCalculate();
        Thread.sleep(1500);

        String result = calculatorPage.getResult();
        Assert.assertEquals(result, "7"); // validasi hasil

        calculatorPage.resetCalculator();
    }

    @Test
    public void testDivision() throws InterruptedException {
        calculatorPage.enterFirstNumber("20");
        Thread.sleep(1500);
        calculatorPage.enterSecondNumber("2");
        Thread.sleep(1500);
        calculatorPage.operatorDropdown("/");
        Thread.sleep(1500);
        calculatorPage.clickCalculate();
        Thread.sleep(1500);

        String result = calculatorPage.getResult();
        Assert.assertEquals(result, "10"); // validasi hasil

        calculatorPage.resetCalculator();
    }

    @Test
    public void testMultiplication() throws InterruptedException {
        calculatorPage.enterFirstNumber("10");
        Thread.sleep(1500);
        calculatorPage.enterSecondNumber("10");
        Thread.sleep(1500);
        calculatorPage.operatorDropdown("*");
        Thread.sleep(1500);
        calculatorPage.clickCalculate();
        Thread.sleep(1500);

        String result = calculatorPage.getResult();
        Assert.assertEquals(result, "100"); // validasi hasil

        calculatorPage.resetCalculator();
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
