package com.mycompany.project_kelompok3.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginScript implements ISeleniumScript{
    String username;
    String email;
    String password;

    public LoginScript(String[][] data) {
        this.username = data[0][1];
        this.email = data[1][1];
        this.password = data[2][1];
    }

    @Override
    public void run(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://gruplm.com/");

        Boolean loggedIn = true;
        try {
            WebElement dashboardNavigation = driver.findElement(By.xpath("a[text()='Dashboard']"));
            wait.until(ExpectedConditions.visibilityOf(dashboardNavigation));
            dashboardNavigation.click();
        }
        catch (Exception err) {
            loggedIn = false;
        }

        if (!loggedIn) {
            WebElement loginNavigationBurger = driver.findElement(By.xpath("//div[@class='navbar-toggler']"));
            wait.until(ExpectedConditions.visibilityOf(loginNavigationBurger));
            loginNavigationBurger.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Handle the exception
            }

            WebElement loginNavigation = driver.findElement(By.xpath("//a[text()='Login']"));

            wait.until(ExpectedConditions.visibilityOf(loginNavigation));
            wait.until(ExpectedConditions.elementToBeClickable(loginNavigation));

            loginNavigation.click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), 'Login')]")));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Handle the exception
            }
            js.executeScript("window.scrollTo(0, arguments[0]);", 350);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Handle the exception
            }
            driver.findElement(By.xpath("//input[@type='email' and @name='email']")).sendKeys(email);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Handle the exception
            }
            driver.findElement(By.xpath("//input[@type='password' and @name='password']")).sendKeys(password);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Handle the exception
            }
            driver.findElement(By.xpath("//button[contains(text(), 'LOG IN')]")).click();
        }
    }
}
