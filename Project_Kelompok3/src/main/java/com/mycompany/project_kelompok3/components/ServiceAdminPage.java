package com.mycompany.project_kelompok3.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ServiceAdminPage extends LoadableComponent<ServiceAdminPage> {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[text()=' Add Service']")
    private WebElement createModalButton;

    @FindBy(name = "image")
    private WebElement serviceImageInput;

    @FindBy(name = "user_language_id")
    private WebElement serviceLanguageInput;

    @FindBy(name = "name")
    private WebElement serviceNameInput;

    @FindBy(xpath = "//textarea[@class='note-codable']")
    private WebElement serviceContentInput;

    @FindBy(name = "serial_number")
    private WebElement serviceSerialInput;

    @FindBy(name = "featured")
    private WebElement serviceFeatured;

    @FindBy(xpath = "//input[@name = 'detail_page']")
    private List<WebElement> serviceEnabledInputs;

    @FindBy(name = "meta_keywords")
    private WebElement serviceMetaInput;

    @FindBy(name = "meta_description")
    private WebElement serviceMetaDescription;

    @FindBy(id = "submitBtn")
    private WebElement serviceSubmitInput;

    public ServiceAdminPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);

        PageFactory.initElements(driver, this);
    }

    public void showCreateModal() {
        wait.until(ExpectedConditions.visibilityOf(createModalButton));
        wait.until(ExpectedConditions.elementToBeClickable(createModalButton));
        createModalButton.click();
    }

    public void selectImage(String imagePath) {
        wait.until(ExpectedConditions.visibilityOf(serviceImageInput));
        serviceImageInput.sendKeys(imagePath);
    }

    @Override
    protected void load() {
        driver.get("https://gruplm.com/user/services?language=en");
        driver.manage().window().maximize();
    }

    @Override
    protected void isLoaded() throws Error {
        Assertions.assertEquals(driver.getCurrentUrl(), "https://gruplm.com/user/services?language=en");
    }
}
