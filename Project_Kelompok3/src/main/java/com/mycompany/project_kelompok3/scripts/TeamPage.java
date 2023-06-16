/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_kelompok3.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.net.URL;

/**
 *
 * @author daniel c
 */
public class TeamPage implements ISeleniumScript{
    private String[] names = {
            "Ian Nathaneil William",
            "Jonathan Aurelius",
            "Hezron Dharmawan",
            "Daniel Christianto"
    };

    private String[] ranks = {
            "Project Manager",
            "Developer",
            "Developer",
            "Developer"
    };

    private String[] images = {
            "/images/Shark.png",
            "/images/Seele.png",
            "/images/Nightmare.png",
            "/images/Fuelled_Determined.png",
    };

    public void run(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            driver.get("https://gruplm.com/user/team_section?language=en");
            driver.findElement(By.xpath("//a[@class='btn btn-primary btn-sm float-right']")).click();

            for (int i = 0; i < names.length; i++) {
                URL imageUrl = this.getClass().getResource(images[i]);
                if (imageUrl != null) {
                    File imageFile = new File(imageUrl.getPath());
                    if (imageFile.exists()) {
                        driver.findElement(By.cssSelector("#image")).sendKeys(imageFile.getPath());
                    }
                }

                js.executeScript("window.scrollTo(0, arguments[0]);", 1000);

                Select language = new Select(driver.findElement(By.xpath("//select[@name='user_language_id']")));
                language.selectByVisibleText("English");
                driver.findElement(By.xpath("//input[@name='name']")).sendKeys(names[i]);
                driver.findElement(By.xpath("//input[@name='rank']")).sendKeys(ranks[i]);
                driver.findElement(By.xpath("//input[@name='facebook']")).sendKeys("https://www.facebook.com");
                driver.findElement(By.xpath("//input[@name='instagram']")).sendKeys("https://www.instagram.com");
                driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();

                Thread.sleep(2500);
            }
        } catch (Exception e) {
            System.out.printf("Error: %s%n", e.getMessage());
            driver.quit();
        }

    }
}
