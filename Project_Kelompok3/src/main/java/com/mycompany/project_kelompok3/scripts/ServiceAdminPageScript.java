package com.mycompany.project_kelompok3.scripts;

import com.mycompany.project_kelompok3.components.ServiceAdminPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ServiceAdminPageScript implements ISeleniumScript{
    @Override
    public void run(WebDriver driver) {
        // Initialize the loadable component of the page
        ServiceAdminPage serviceAdminPage = new ServiceAdminPage(driver);

        try {
            // Redirect the driver to the component's url.
            // If the redirect is unsuccessful, log the error and quit the driver.
            serviceAdminPage.get();

            serviceAdminPage.showCreateModal();

            URL imageUrl = this.getClass().getProtectionDomain().getClassLoader().getResource("images/1200px-Laravel.svg.png");
            if (imageUrl != null) {
                System.out.println(imageUrl.getPath());

                File imageFile = new File(imageUrl.toString());
                System.out.print("File exists:");
                System.out.println(imageFile.exists());

                if (imageFile.exists()) {
                    serviceAdminPage.selectImage(imageFile.getPath());
                }
            }

            serviceAdminPage.selectServiceLanguage(1);
            serviceAdminPage.inputServiceName("Laravel");
            serviceAdminPage.inputServiceContent("Laravel is the greatest framework there is for the PHP programming language!");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 500);");
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            serviceAdminPage.inputSerial(1);
            serviceAdminPage.isFeatured(true);
            serviceAdminPage.isEnabled(true);
            serviceAdminPage.inputMetaKeywords("Features,Framework,Outstanding,PHP");
            serviceAdminPage.inputMetaDescription("Laravel adalah framework terbaik untuk bahasa PHP!");
        }
        catch (Exception err) {
            // If any error occured during the automation, print the error message and quit the driver
            System.out.printf("Error: %s%n", err.getMessage());
            driver.quit();
        }
    }
}
