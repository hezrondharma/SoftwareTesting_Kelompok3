/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyek_kelompok_3;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
/**
 *
 * 
 */
public class Proyek_Kelompok_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
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
        js.executeScript("window.scrollTo(0, arguments[0]);", 4000);
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//a[@href='#lifetime']")).click();
        Thread.sleep(1000);
        
        js.executeScript("window.scrollTo(0, arguments[0]);", 5100);
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//a[@href='https://gruplm.com/registration/step-1/regular/21' and @class='main-btn']")).click();
        Thread.sleep(1000);

        js.executeScript("window.scrollTo(0, arguments[0]);", 400);
        Thread.sleep(1000);
        
        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        usernameField.sendKeys(username);
        Thread.sleep(500);
        WebElement emailField = driver.findElement(By.xpath("//input[@name='email']"));
        emailField.sendKeys(email);
        Thread.sleep(500);
        
        WebElement passField = driver.findElement(By.xpath("//input[@name='password']"));
        passField.sendKeys(password);
        Thread.sleep(500);
        
        WebElement passcField = driver.findElement(By.xpath("//input[@name='password_confirmation']"));
        passcField.sendKeys(password);
        Thread.sleep(500);
        
        js.executeScript("window.scrollTo(0, arguments[0]);", 550);
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//button[@class='main-btn' and text()='continue']")).click();
        

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout value as needed
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), 'Checkout')]")));
        Thread.sleep(1000);
        
        js.executeScript("window.scrollTo(0, arguments[0]);", 500);
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Hezron");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Dharmawan");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("08999272636");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@name='company_name']")).sendKeys("Kelompok_3");
        Thread.sleep(500);
        js.executeScript("window.scrollTo(0, arguments[0]);", 800);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='address']")).sendKeys("jl melon 22");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Surabaya");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@name='district']")).sendKeys("East Java");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@name='country']")).sendKeys("Indonesia");
        Thread.sleep(500);
        js.executeScript("window.scrollTo(0, arguments[0]);", 500);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='coupon']")).sendKeys("softwaretesting");
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[@class='input-group-text coupon-apply' and text()='Apply']")).click();
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0, arguments[0]);", 650);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@class='current' and text()='Choose an option']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[@class='option' and @data-value='Flutterwave']")).click();  
        Thread.sleep(1000);        
        driver.findElement(By.xpath("//button[@id='confirmBtn' and @class='main-btn w-100 mt-4']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), 'Payment Success !')]")));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Go to Home']")).click();
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), 'Minimize the time, it takes to initiate a relationship between you and the customer.')]")));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='navbar-toggler']")).click();
        Thread.sleep(1000);
       
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), 'Login')]")));
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0, arguments[0]);", 350);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='email' and @name='email']")).sendKeys(email); 
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@type='password' and @name='password']")).sendKeys(password); 
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(), 'LOG IN')]")).click();
    }
    
}