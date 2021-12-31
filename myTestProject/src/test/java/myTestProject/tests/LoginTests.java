package myTestProject.tests;

import myTestProject.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigUtils;

import java.util.Properties;

public class LoginTests {

    LoginPage loginPage;
    WebDriver driver;

    @BeforeClass
    public void openPage(){

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromdriver\\chromedriver.exe");
        driver = new ChromeDriver();

        Properties prop = ConfigUtils.getProps("data");
        driver.get(prop.getProperty("URL"));
        driver.manage().window().maximize();

    } // end of openPage

    @Test(description = "Login Test", priority = 1)
    public void login(){

        // Login
        loginPage = new LoginPage(driver);
        loginPage.login();

        // Verification for Login / Assertion
        String text = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/h1")).getText();
        Assert.assertEquals(text,"Dashboard");
        //Assert.assertTrue(text.contains("Dashboard"));


    } // end of login

    @Test(description = "Logout Test", priority = 2)
    public void logOut() throws InterruptedException {

        // LogOut
        loginPage.logout();

        // Verification for LogOut / Assertion
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("/login"));

    } // end of logOut

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    } // end of closeBrowser

} // end of LoginTests
