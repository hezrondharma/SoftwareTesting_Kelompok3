package com.mycompany.project_kelompok3.scripts;

import com.mycompany.project_kelompok3.components.ServiceAdminPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ServiceAdminPageScript implements ISeleniumScript {
    private String[] imageUrls = {
            "/images/Fd1tlFOXEBYZVXV.jpg",
            "/images/nuro-r2-driverless-car-vehicle-permit-commercial-california-bay-area-iot-internet-of-things-smart-city-cities.jpg",
            "/images/featured-web-nuro.jpg",
    };

    private String[] serviceNames = {
            "Package Delivery",
            "Public Transportation",
            "Storage",
    };

    private String[] serviceContents = {
            "Nuro AI is capable of delivering goods and packages just fine. " +
                    "We power our zero-emission vehicles with 100% renewable energy, reducing gas powered trips to the store. " +
                    "We turned safety features inside-out. An industry-first external airbag and collapsible front end on the Nuro are designed to protect pedestrians and cyclists.",
            "Nuro AI can deliver anyone, and anything with ease to the target destination without hassle. " +
                    "With state of the art artificial intelligence, we can navigate the roads without worrying about damages or even worse, accidents",
            "Nuro AI can be customized to store goods indefinitely with comfort. " +
                    "With a built-in refrigeration system, we can store almost anything that can be contained inside it while maintaining the quality of the goods."
    };

    private String[] metaKeywords = {
            "Delivery,Package,AI,Safe",
            "Public,Transportation,Safe,Smart",
            "Storage,Modifiable,Spacious,Cool",
    };

    private String[] metaDescriptions = {
            "Best package delivery using AI",
            "The safest AI driven public transportation",
            "The most unique and useful storage unit",
    };

    @Override
    public void run(WebDriver driver) {
        // Initialize the loadable component of the page
        ServiceAdminPage serviceAdminPage = new ServiceAdminPage(driver);

        try {
            // Redirect the driver to the component's url.
            // If the redirect is unsuccessful, log the error and quit the driver.
            serviceAdminPage.get();

            // Loop the operation for each content that are going to be put into the website builder
            for (int i = 0; i < imageUrls.length; i++) {
                serviceAdminPage.showCreateModal();

                URL imageUrl = this.getClass().getResource(imageUrls[i]);
                if (imageUrl != null) {
                    File imageFile = new File(imageUrl.getPath().toString());

                    if (imageFile.exists()) {
                        serviceAdminPage.selectImage(imageFile.getPath());
                    }
                }

                serviceAdminPage.selectServiceLanguage(1);
                serviceAdminPage.inputServiceName(serviceNames[i]);
                serviceAdminPage.inputServiceContent(serviceContents[i]);

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0, 600);");
                Thread.sleep(1000);

                serviceAdminPage.inputSerial(i+1);
                serviceAdminPage.isFeatured(true);
                serviceAdminPage.isEnabled(true);
                serviceAdminPage.inputMetaKeywords(metaKeywords[i]);
                serviceAdminPage.inputMetaDescription(metaDescriptions[i]);
                serviceAdminPage.sumbitService();

                Thread.sleep(4000);
            }
        }
        catch (Exception err) {
            // If any error occured during the automation, print the error message and quit the driver
            System.out.printf("Error: %s%n", err.getMessage());
            driver.quit();
        }
    }
}
