package com.mycompany.project_kelompok3.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.net.URL;
import java.util.List;

public class InitialSetupScript implements ISeleniumScript {
    @Override
    public void run(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            // Redirect to the menu builder, remove all selected menus, add only the selected menu
            driver.get("https://gruplm.com/user/menu-builder?language=en");

            List<WebElement> menuItems = driver.findElements(By.cssSelector("#myEditor>li"));

            for (WebElement menuItem : menuItems) {
                removeMenu(driver, menuItem);

                Thread.sleep(500);
            }

            js.executeScript("window.scrollTo(0, -600);");

            driver.findElement(By.xpath("//a[@data-text='Home'][@class='addToMenus btn btn-primary btn-sm float-right']")).click();
            driver.findElement(By.xpath("//a[@data-text='Services'][@class='addToMenus btn btn-primary btn-sm float-right']")).click();
            driver.findElement(By.xpath("//a[@data-text='Team'][@class='addToMenus btn btn-primary btn-sm float-right']")).click();

            js.executeScript("window.scrollTo(0, 600);");

            driver.findElement(By.cssSelector("#btnOutput")).click();

            Thread.sleep(4000);

            // ==== Redirect to the admin web setting page ====
            // Set the favicon image setting
            driver.get("https://gruplm.com/user/favicon");

            URL fileUrl = this.getClass().getResource("/images/back_end.png");
            if (fileUrl != null) {
                File file = new File(fileUrl.getPath());
                if (file.exists()) {
                    driver.findElement(By.cssSelector("#image")).sendKeys(file.getPath());

                    driver.findElement(By.cssSelector("#submitBtn")).click();

                    Thread.sleep(4000);
                }
            }

            // Set the web theme setting
            driver.get("https://gruplm.com/user/theme/version");
            WebElement themeForm = driver.findElement(By.cssSelector("#ajaxForm"));

            List<WebElement> themeItems = themeForm.findElements(By.cssSelector("div.col-4.col-sm-4"));
            themeItems.get(3).click();

            driver.findElement(By.cssSelector("#submitBtn")).click();

            Thread.sleep(4000);

            // Set the general settings
            driver.get("https://gruplm.com/user/general-settings");

            driver.findElement(By.xpath("//input[@name='website_title']")).clear();
            driver.findElement(By.xpath("//input[@name='website_title']")).sendKeys("Nuro");

            driver.findElement(By.cssSelector("span.select2-selection__rendered")).click();
            driver.findElement(By.xpath("//input[@aria-label='Search'][@class='select2-search__field']")).sendKeys("Jakarta");
            driver.findElement(By.xpath("//li[@class='select2-results__option select2-results__option--selectable select2-results__option--selected select2-results__option--highlighted']")).click();

            driver.findElement(By.xpath("//input[@name='base_currency_symbol']")).clear();
            driver.findElement(By.xpath("//input[@name='base_currency_symbol']")).sendKeys("Rp.");

            driver.findElement(By.xpath("//select[@name='base_currency_symbol_position']")).click();
            driver.findElement(By.xpath("//select[@name='base_currency_symbol_position']/option[@value='left']")).click();

            driver.findElement(By.xpath("//input[@name='base_currency_text']")).clear();
            driver.findElement(By.xpath("//input[@name='base_currency_text']")).sendKeys("Rupiah");

            driver.findElement(By.xpath("//select[@name='base_currency_text_position']")).click();
            driver.findElement(By.xpath("//select[@name='base_currency_text_position']/option[@value='right']")).click();

            driver.findElement(By.xpath("//input[@name='base_currency_rate']")).clear();
            driver.findElement(By.xpath("//input[@name='base_currency_rate']")).sendKeys("14500");

            driver.findElement(By.cssSelector("#submitBtn")).click();

            Thread.sleep(4000);

            // Set the web logo
            driver.get("https://gruplm.com/user/logo");

            fileUrl = this.getClass().getResource("/images/nuro_logo_dark.png");
            if (fileUrl != null) {
                File file = new File(fileUrl.getPath());
                if (file.exists()) {
                    driver.findElement(By.cssSelector("#image")).sendKeys(file.getPath());

                    driver.findElement(By.xpath("//button[@type='submit']")).click();

                    Thread.sleep(4000);
                }
            }
        }
        catch (Exception err) {
            System.out.printf("Error: %s%n", err.getMessage());
            driver.quit();
        }
    }

    private void removeMenu(WebDriver driver, WebElement listElement) {
        listElement.findElement(By.xpath("//a[@class='btn btn-danger btn-sm btnRemove clickable']")).click();
        driver.switchTo().alert().accept();
    }
}
