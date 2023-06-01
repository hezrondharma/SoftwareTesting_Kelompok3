/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyek_kelompok_3;



import java.time.Duration;
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
 * @author jonat
 */
public class Proyek_Kelompok_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium-java-4.8.3\\chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        try{
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   
        }catch(Error err){
            System.out.println(err.toString());
            driver.quit();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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
        
    }
    
}