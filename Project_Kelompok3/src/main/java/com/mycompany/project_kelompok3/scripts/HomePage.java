/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_kelompok3.scripts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 *
 * @author Jonathan Aurelius
 */
public class HomePage implements ISeleniumScript{
    @Override
    public void run(WebDriver driver){
      
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, arguments[0]);", 4000);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the exception
        }
//       
        driver.get("https://gruplm.com/user/home_page/hero/slider_version?language=en");
        
        driver.findElement(By.xpath("//a[@href='https://gruplm.com/user/home_page/hero/slider_version/create_slider']")).click();
        driver.findElement(By.cssSelector("#language")).click();
        driver.findElement(By.xpath("//option[text()='English']")).click();
        driver.findElement(By.xpath("//input[@name='title]")).sendKeys("Ironman");
        driver.findElement(By.xpath("//input[@name='subtitle]")).sendKeys("Ironman is strong");
        driver.findElement(By.xpath("//input[@name='btn_name]")).sendKeys("marvel");
        driver.findElement(By.xpath("//input[@name='btn_url]")).sendKeys("example.com");
        driver.findElement(By.xpath("//input[@name='serial_number]")).sendKeys("1");
        driver.findElement(By.xpath("//button[@type='submit' ]")).click();
      }
}
