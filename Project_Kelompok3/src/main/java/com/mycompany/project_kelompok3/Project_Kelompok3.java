/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project_kelompok3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.mycompany.project_kelompok3.scripts.HomePage;
import com.mycompany.project_kelompok3.scripts.ServiceAdminPageScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

/**
 *
 * @author HESRON
 */
public class Project_Kelompok3 {

    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");

       String[][] data = null;
       WebDriver driver = new ChromeDriver();

        try {
            String googleSheetsURL = "https://docs.google.com/spreadsheets/d/e/2PACX-1vSdInjILdcDpe6Fvxs9C_THdYU5dCgrfl5ivamkFN_OAT6RdHkzeQaF6KzfDtBuphFtEnkhqm6_Mp8H/pub?output=csv";
            URL url = new URL(googleSheetsURL);

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {
                List<String[]> rows = new ArrayList<>();
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] row = line.split(",");
                    rows.add(row);
                }

                // Convert the list to a two-dimensional array
                data = new String[rows.size()][];
                data = rows.toArray(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String username =data[0][1].toString();
        String email =data[1][1].toString();
        String password =data[2][1].toString();
        driver.get("https://gruplm.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo(0, arguments[0]);", 4000);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
////
//        driver.findElement(By.xpath("//a[@href='#lifetime']")).click();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//
//        js.executeScript("window.scrollTo(0, arguments[0]);", 5100);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//
//        driver.findElement(By.xpath("//a[@href='https://gruplm.com/registration/step-1/regular/21' and @class='main-btn']")).click();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//
//        js.executeScript("window.scrollTo(0, arguments[0]);", 400);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//
//        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
//        usernameField.sendKeys(username);
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//        WebElement emailField = driver.findElement(By.xpath("//input[@name='email']"));
//        emailField.sendKeys(email);
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//
//        WebElement passField = driver.findElement(By.xpath("//input[@name='password']"));
//        passField.sendKeys(password);
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//
//        WebElement passcField = driver.findElement(By.xpath("//input[@name='password_confirmation']"));
//        passcField.sendKeys(password);
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//
//        js.executeScript("window.scrollTo(0, arguments[0]);", 550);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//
//        driver.findElement(By.xpath("//button[@class='main-btn' and text()='continue']")).click();
//
//
         WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), 'Checkout')]")));
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//
//        js.executeScript("window.scrollTo(0, arguments[0]);", 500);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//
//        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Hezron");
//         try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Dharmawan");
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("08999272636");
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//        driver.findElement(By.xpath("//input[@name='company_name']")).sendKeys("Kelompok_3");
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//        js.executeScript("window.scrollTo(0, arguments[0]);", 800);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//        driver.findElement(By.xpath("//input[@name='address']")).sendKeys("jl melon 22");
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Surabaya");
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//        driver.findElement(By.xpath("//input[@name='district']")).sendKeys("East Java");
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//        driver.findElement(By.xpath("//input[@name='country']")).sendKeys("Indonesia");
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//        js.executeScript("window.scrollTo(0, arguments[0]);", 500);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//        driver.findElement(By.xpath("//input[@name='coupon']")).sendKeys("softwaretesting");
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//        driver.findElement(By.xpath("//span[@class='input-group-text coupon-apply' and text()='Apply']")).click();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//        js.executeScript("window.scrollTo(0, arguments[0]);", 650);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//        driver.findElement(By.xpath("//span[@class='current' and text()='Choose an option']")).click();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//        driver.findElement(By.xpath("//li[@class='option' and @data-value='Flutterwave']")).click();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//        driver.findElement(By.xpath("//button[@id='confirmBtn' and @class='main-btn w-100 mt-4']")).click();
//
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), 'Payment Success !')]")));
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }
//        driver.findElement(By.xpath("//a[text()='Go to Home']")).click();
//
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), 'Minimize the time, it takes to initiate a relationship between you and the customer.')]")));
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            // Handle the exception
//        }

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

//        ServiceAdminPageScript serviceAdminPageScript = new ServiceAdminPageScript();
//        serviceAdminPageScript.run(driver);

        HomePage homePage = new HomePage();
        homePage.run(driver);
    }
}
