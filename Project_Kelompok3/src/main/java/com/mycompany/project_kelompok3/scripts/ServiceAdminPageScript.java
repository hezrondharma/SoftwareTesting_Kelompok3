package com.mycompany.project_kelompok3.scripts;

import com.mycompany.project_kelompok3.components.ServiceAdminPage;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.net.URL;

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
                File imageFile = new File(imageUrl.toString());

                serviceAdminPage.selectImage(imageUrl.toString());
            }
        }
        catch (Exception err) {
            // If any error occured during the automation, print the error message and quit the driver
            System.out.printf("Error: %s%n", err.getMessage());
            driver.quit();
        }
    }
}
