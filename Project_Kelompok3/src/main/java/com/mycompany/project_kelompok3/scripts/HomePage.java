/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_kelompok3.scripts;

import java.awt.Desktop.Action;
import java.nio.file.Paths;
import java.sql.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 *
 * @author Jonathan Aurelius
 */
public class HomePage implements ISeleniumScript {
    @Override
    public void run(WebDriver driver){
      
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, arguments[0]);", 4000);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the exception
        }
//       Hero section
        driver.get("https://gruplm.com/user/home_page/hero/slider_version?language=en");
        driver.findElement(By.xpath("//a[@href='https://gruplm.com/user/home_page/hero/slider_version/create_slider']")).click();
        driver.findElement(By.cssSelector("#language")).click();
        driver.findElement(By.xpath("//option[text()='English']")).click();
        driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Ironman");
        driver.findElement(By.xpath("//input[@name='subtitle']")).sendKeys("Ironman is strong");
        driver.findElement(By.xpath("//input[@name='btn_name']")).sendKeys("marvel");
        driver.findElement(By.xpath("//input[@name='btn_url']")).sendKeys("https://example.com");
        driver.findElement(By.xpath("//input[@name='serial_number']")).sendKeys("4");
        driver.findElement(By.xpath("//button[@type='submit' ]")).click();
//        
// Home Section
        driver.findElement(By.xpath("//input[@name='term']")).sendKeys("home sections");
        driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
        String menu_home_xpath = "//span[contains(text(),'Home Sections')]";
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(menu_home_xpath)));
        driver.findElement(By.xpath(menu_home_xpath)).click();
        driver.findElement(By.xpath("//input[@name='skills_title']")).sendKeys("Coding HTML");
        driver.findElement(By.xpath("//input[@name='skills_subtitle']")).sendKeys("All about HTML");
        driver.findElement(By.xpath("//input[@name='service_title']")).sendKeys("Home Service");
        driver.findElement(By.xpath("//input[@name='service_subtitle']")).sendKeys("Our service");
        driver.findElement(By.xpath("//input[@name='portfolio_title']")).sendKeys("Our Portfolio");
        driver.findElement(By.xpath("//input[@name='portfolio_subtitle']")).sendKeys("These are some of our portfolio");
//        String imagePath = Paths.get("").toAbsolutePath().toString() + "\"D:\\2c7dfeee-44be-4897-9d8c-9058bb94ad75.jpeg\"";
//        driver.findElement(By.id("testimonial_image")).sendKeys(imagePath);
        driver.findElement(By.xpath("//input[@name='testimonial_title']")).sendKeys("Testimonial");
        driver.findElement(By.xpath("//input[@name='testimonial_subtitle']")).sendKeys("Psst.. hear out our previous customer opinions!!");
        driver.findElement(By.xpath("//input[@name='blog_title']")).sendKeys("Blog");
        driver.findElement(By.xpath("//input[@name='blog_subtitle']")).sendKeys("See our post!!!");
        driver.findElement(By.xpath("//input[@name='quote_section_title']")).sendKeys("Quote");
        driver.findElement(By.xpath("//input[@name='quote_section_subtitle']")).sendKeys("Send your wisdom here");
        driver.findElement(By.xpath("//button[@type='submitbtn' ]")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("submitBtn")));
//        
        // About section
         driver.get("https://gruplm.com/user/home-page/about?language=en");
         driver.findElement(By.xpath("//a[@href='https://gruplm.com/user/home-page/about?language=en']")).click();
         driver.findElement(By.cssSelector("#language")).click();
         driver.findElement(By.xpath("//option[text()='English']")).click();
         driver.findElement(By.xpath("//input[@name='about_title']")).sendKeys("Ironman");
         driver.findElement(By.xpath("//input[@name='about_subtitle']")).sendKeys("test");
         driver.findElement(By.xpath("//input[@name='about_button_text']")).sendKeys("test");
         driver.findElement(By.xpath("//input[@name='about_button_url']")).sendKeys("https://example.com");
         driver.findElement(By.xpath("//button[@type='submitbtn' ]")).click();
         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("submitBtn")));
      }
}
