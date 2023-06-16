package com.mycompany.project_kelompok3.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterScript implements ISeleniumScript {
    String username;
    String email;
    String password;

    public RegisterScript(String[][] data) {
        this.username = data[0][1];
        this.email = data[1][1];
        this.password = data[2][1];
    }


    @Override
    public void run(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://gruplm.com/");
        driver.manage().window().maximize();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the exception
        }

        js.executeScript("window.scrollTo(0, arguments[0]);", 4000);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the exception
        }

        driver.findElement(By.xpath("//a[@href='#lifetime']")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the exception
        }

        js.executeScript("window.scrollTo(0, arguments[0]);", 5100);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the exception
        }

        driver.findElement(By.xpath("//a[@href='https://gruplm.com/registration/step-1/regular/21' and @class='main-btn']")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the exception
        }

        js.executeScript("window.scrollTo(0, arguments[0]);", 400);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the exception
        }

        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        usernameField.sendKeys(username);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // Handle the exception
        }
        WebElement emailField = driver.findElement(By.xpath("//input[@name='email']"));
        emailField.sendKeys(email);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // Handle the exception
        }

        WebElement passField = driver.findElement(By.xpath("//input[@name='password']"));
        passField.sendKeys(password);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // Handle the exception
        }

        WebElement passcField = driver.findElement(By.xpath("//input[@name='password_confirmation']"));
        passcField.sendKeys(password);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // Handle the exception
        }

        js.executeScript("window.scrollTo(0, arguments[0]);", 550);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the exception
        }

        driver.findElement(By.xpath("//button[@class='main-btn' and text()='continue']")).click();


        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), 'Checkout')]")));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the exception
        }

        js.executeScript("window.scrollTo(0, arguments[0]);", 500);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the exception
        }

        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Hezron");
         try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // Handle the exception
        }
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Dharmawan");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // Handle the exception
        }
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("08999272636");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // Handle the exception
        }
        driver.findElement(By.xpath("//input[@name='company_name']")).sendKeys("Kelompok_3");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // Handle the exception
        }
        js.executeScript("window.scrollTo(0, arguments[0]);", 800);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the exception
        }
        driver.findElement(By.xpath("//input[@name='address']")).sendKeys("jl melon 22");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // Handle the exception
        }
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Surabaya");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // Handle the exception
        }
        driver.findElement(By.xpath("//input[@name='district']")).sendKeys("East Java");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // Handle the exception
        }
        driver.findElement(By.xpath("//input[@name='country']")).sendKeys("Indonesia");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // Handle the exception
        }
        js.executeScript("window.scrollTo(0, arguments[0]);", 500);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the exception
        }
        driver.findElement(By.xpath("//input[@name='coupon']")).sendKeys("softwaretesting");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // Handle the exception
        }
        driver.findElement(By.xpath("//span[@class='input-group-text coupon-apply' and text()='Apply']")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the exception
        }
        js.executeScript("window.scrollTo(0, arguments[0]);", 650);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the exception
        }
        driver.findElement(By.xpath("//span[@class='current' and text()='Choose an option']")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the exception
        }
        driver.findElement(By.xpath("//li[@class='option' and @data-value='Flutterwave']")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the exception
        }
        driver.findElement(By.xpath("//button[@id='confirmBtn' and @class='main-btn w-100 mt-4']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), 'Payment Success !')]")));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the exception
        }
        driver.findElement(By.xpath("//a[text()='Go to Home']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), 'Minimize the time, it takes to initiate a relationship between you and the customer.')]")));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the exception
        }
    }
}
