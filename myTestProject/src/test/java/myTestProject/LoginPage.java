package myTestProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    By username = new By.ById("txtUsername");
    By password = new By.ByName("txtPassword");
    By btnLogin = new By.ByClassName("button");

    By btnLogoutMenu = new By.ByXPath("//*[@id='welcome']");
    By btnLogout = new By.ByLinkText("Logout");

    public LoginPage(WebDriver driver){

        this.driver = driver;
    }
    public void login(){

        driver.findElement(username).sendKeys("Admin");
        driver.findElement(password).sendKeys("admin123");
        driver.findElement(btnLogin).click();

    } // end og loginPage function

    public void logout() throws InterruptedException {

        driver.findElement(btnLogoutMenu).click();
        Thread.sleep(2000);
        driver.findElement(btnLogout).click();

    } // end of logOut function
} // end of LoginPage class
