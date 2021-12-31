package myTestProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigUtils;

import java.util.Properties;

public class main {

    public static void main (String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        Properties prop = ConfigUtils.getProps("data");
        driver.get(prop.getProperty("URL"));
        driver.manage().window().maximize();

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        // Verification for Login / Assertion
        String text = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/h1")).getText();

        if (text.contains("Dashboard")){
            System.out.println("Login Successfully");
        }


        // LogOut
        loginPage.logout();

        // Verification for LogOut / Assertion
        String url = driver.getCurrentUrl();
        if (url.contains("/login")){
            System.out.println("LogOut Successfully");
        }

        driver.quit();

    } // end main method
} // end main class
