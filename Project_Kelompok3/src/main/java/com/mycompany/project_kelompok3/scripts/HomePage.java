/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_kelompok3.scripts;

import java.awt.Desktop.Action;
import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

        Actions actions = new Actions(driver);

        try {
            // Set the shown sections in the home page
            driver.get("https://gruplm.com/user/sections");

            List<WebElement> formGroups = driver.findElements(By.xpath("//div[@class='col-lg-6 offset-lg-3']/div[@class='form-group']"));


            // Portofolio
            WebElement element = formGroups.get(0).findElement(By.tagName("div"));
            element.findElements(By.tagName("label")).get(1).click();

            // Counter Info
            element = formGroups.get(2).findElement(By.tagName("div"));
            element.findElements(By.tagName("label")).get(1).click();

            // Video
            element = formGroups.get(3).findElement(By.tagName("div"));
            element.findElements(By.tagName("label")).get(1).click();

            // Blog
            element = formGroups.get(4).findElement(By.tagName("div"));
            element.findElements(By.tagName("label")).get(1).click();

            // FAQ
            element = formGroups.get(5).findElement(By.tagName("div"));
            element.findElements(By.tagName("label")).get(1).click();

            // Contact
            element = formGroups.get(6).findElement(By.tagName("div"));
            element.findElements(By.tagName("label")).get(1).click();

            // Work Process
            element = formGroups.get(7).findElement(By.tagName("div"));
            element.findElements(By.tagName("label")).get(1).click();

            driver.findElement(By.cssSelector("#displayNotif")).click();

            Thread.sleep(4000);

            // Hero section
            driver.get("https://gruplm.com/user/home_page/hero/static_version?language=en");

            driver.findElement(By.xpath("//select[@name='userLanguage']")).click();
            driver.findElement(By.xpath("//select[@name='userLanguage']/option[@value='en']")).click();

            URL imageUrl = this.getClass().getResource("/images/homepage-marquee-desktop-overlay.jpg");
            if (imageUrl != null) {
                File imageFile = new File(imageUrl.getPath());
                if (imageFile.exists()) {
                    driver.findElement(By.cssSelector("input#image")).sendKeys(imageFile.getPath());
                }
            }

            driver.findElement(By.xpath("//input[@name='title']")).clear();
            driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Nuro");

            driver.findElement(By.xpath("//input[@name='subtitle']")).clear();
            driver.findElement(By.xpath("//input[@name='subtitle']")).sendKeys("Nuro - The Smart Car");

            driver.findElement(By.xpath("//textarea[@name='hero_text']")).clear();
            driver.findElement(By.xpath("//textarea[@name='hero_text']")).sendKeys("The world's first smart automobile");

            driver.findElement(By.xpath("//input[@name='btn_name']")).clear();
            driver.findElement(By.xpath("//input[@name='btn_name']")).sendKeys("Check it out!");

            driver.findElement(By.xpath("//input[@name='btn_url']")).clear();
            driver.findElement(By.xpath("//input[@name='btn_url']")).sendKeys("https://www.nuro.ai/");

            driver.findElement(By.xpath("//button[@type='submit' ]")).click();

            Thread.sleep(4000);

            // Home Section
//            driver.get("https://gruplm.com/user/home-page-text/edit?language=en");
//            driver.findElement(By.xpath("//input[@name='term']")).sendKeys("home sections");
//            driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
//            String menu_home_xpath = "//span[contains(text(),'Home Sections')]";
//            WebDriverWait wait = new WebDriverWait(driver, 10);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(menu_home_xpath)));
//            driver.findElement(By.xpath(menu_home_xpath)).click();
//            driver.findElement(By.xpath("//input[@name='skills_title']")).sendKeys("Coding HTML");
//            driver.findElement(By.xpath("//input[@name='skills_subtitle']")).sendKeys("All about HTML");
//            driver.findElement(By.xpath("//input[@name='service_title']")).sendKeys("Home Service");
//            driver.findElement(By.xpath("//input[@name='service_subtitle']")).sendKeys("Our service");
//            driver.findElement(By.xpath("//input[@name='portfolio_title']")).sendKeys("Our Portfolio");
//            driver.findElement(By.xpath("//input[@name='portfolio_subtitle']")).sendKeys("These are some of our portfolio");
//            String imagePath = Paths.get("").toAbsolutePath().toString() + "\"D:\\2c7dfeee-44be-4897-9d8c-9058bb94ad75.jpeg\"";
//            driver.findElement(By.id("testimonial_image")).sendKeys(imagePath);
//            driver.findElement(By.xpath("//input[@name='testimonial_title']")).sendKeys("Testimonial");
//            driver.findElement(By.xpath("//input[@name='testimonial_subtitle']")).sendKeys("Psst.. hear out our previous customer opinions!!");
//            driver.findElement(By.xpath("//input[@name='blog_title']")).sendKeys("Blog");
//            driver.findElement(By.xpath("//input[@name='blog_subtitle']")).sendKeys("See our post!!!");
//            driver.findElement(By.xpath("//input[@name='quote_section_title']")).sendKeys("Quote");
//            driver.findElement(By.xpath("//input[@name='quote_section_subtitle']")).sendKeys("Send your wisdom here");
//            driver.findElement(By.xpath("//button[@type='submitbtn' ]")).click();
//            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("submitBtn")));
//
//            // About section
//            driver.get("https://gruplm.com/user/home-page/about?language=en");
//            driver.findElement(By.xpath("//a[@href='https://gruplm.com/user/home-page/about?language=en']")).click();
//            driver.findElement(By.cssSelector("#language")).click();
//            driver.findElement(By.xpath("//option[text()='English']")).click();
//            driver.findElement(By.xpath("//input[@name='about_title']")).sendKeys("Ironman");
//            driver.findElement(By.xpath("//input[@name='about_subtitle']")).sendKeys("test");
//            driver.findElement(By.xpath("//input[@name='about_button_text']")).sendKeys("test");
//            driver.findElement(By.xpath("//input[@name='about_button_url']")).sendKeys("https://example.com");
//            driver.findElement(By.xpath("//button[@type='submitbtn' ]")).click();
//            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("submitBtn")));
        } catch (Exception err) {
            System.out.printf("Error: %s%n", err.getMessage());
            driver.quit();
        }

    }
}
