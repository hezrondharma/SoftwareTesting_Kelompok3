/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_kelompok3.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author daniel c
 */
public class TeamPage implements ISeleniumScript{
    public void run(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, arguments[0]);", 4000);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the exception
        }
        driver.get("https://gruplm.com/user/team_section?language=en");
        driver.findElement(By.xpath("//a[@href='https://gruplm.com/user/team_section?language=en']")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-sm float-right']")).click();
        Select language = new Select(driver.findElement(By.xpath("//select[@name='user_language_id']")));
        language.selectByVisibleText("English");
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("text");
        driver.findElement(By.xpath("//input[@name='rank']")).sendKeys("1");
        driver.findElement(By.xpath("input[@name='facebook']")).sendKeys("www.facebook.com");
        driver.findElement(By.xpath("//input[@name='instagram']")).sendKeys("danielchristianto742.com");
        driver.findElement(By.xpath("//button[@name='btn btn-success']")).click();
    }
}
