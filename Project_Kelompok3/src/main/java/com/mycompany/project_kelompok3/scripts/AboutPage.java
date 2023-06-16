/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_kelompok3.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author daniel c
 */
public class AboutPage implements ISeleniumScript{
     public void run(WebDriver driver){
         JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, arguments[0]);", 4000);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the exception
        }
        driver.get("https://gruplm.com/user/menu-builder?language=en");
        driver.findElement(By.xpath("//i[@class='fas fa-bars']")).click();
        driver.findElement(By.xpath("//span[@class='sortableListsOpener btn btn-success btn-sm']")).click();
        driver.findElement(By.xpath("//input[@class='form-control item-menu']")).sendKeys("halo");
        driver.findElement(By.xpath("//button[@id='btnAdd']")).click();
     }
}
