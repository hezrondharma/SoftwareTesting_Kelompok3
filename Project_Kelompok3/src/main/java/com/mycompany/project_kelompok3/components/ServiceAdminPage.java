package com.mycompany.project_kelompok3.components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    @FindBy(xpath = "//div[@role='textbox'][@class='note-editable card-block']")
    private WebElement serviceContentInput;

    @FindBy(name = "serial_number")
    private WebElement serviceSerialInput;

    @FindBy(name = "featured")
    private WebElement serviceFeatured;

    @FindBy(xpath = "//input[@name = 'detail_page']")
    private List<WebElement> serviceEnabledInputs;

    @FindBy(xpath = "//div[@class='bootstrap-tagsinput']")
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

    public void selectServiceLanguage(int index) {
        List<WebElement> options = serviceLanguageInput.findElements(By.tagName("option"));

        wait.until(ExpectedConditions.visibilityOf(serviceLanguageInput));
        serviceLanguageInput.click();

        wait.until(ExpectedConditions.visibilityOf(options.get(index)));
        options.get(index).click();
    }

    public void inputServiceName(String name) {
        wait.until(ExpectedConditions.visibilityOf(serviceNameInput));
        serviceNameInput.sendKeys(name);
    }

    public void inputServiceContent(String content) {
        wait.until(ExpectedConditions.visibilityOf(serviceContentInput));
        serviceContentInput.sendKeys(content);
    }

    public void inputSerial(int index) {
        wait.until(ExpectedConditions.visibilityOf(serviceSerialInput));
        serviceSerialInput.sendKeys(Integer.toString(index));
    }

    public void isFeatured(Boolean state) {
        if ((!state && serviceFeatured.isSelected()) || (state && !serviceFeatured.isSelected())) {
            wait.until(ExpectedConditions.visibilityOf(serviceFeatured));
            wait.until(ExpectedConditions.elementToBeClickable(serviceFeatured));
            serviceFeatured.click();
        }
    }

    public void isEnabled(Boolean state) {
        if (state) {
            wait.until(ExpectedConditions.visibilityOf(serviceEnabledInputs.get(0)));
            wait.until(ExpectedConditions.elementToBeClickable(serviceEnabledInputs.get(0)));
            serviceEnabledInputs.get(0).click();
        }
        else {
            wait.until(ExpectedConditions.visibilityOf(serviceEnabledInputs.get(0)));
            wait.until(ExpectedConditions.elementToBeClickable(serviceEnabledInputs.get(0)));
            serviceEnabledInputs.get(1).click();
        }
    }

    public void inputMetaKeywords(String keywords) {
        wait.until(ExpectedConditions.visibilityOf(serviceMetaInput));

        WebElement textBox = serviceMetaInput.findElement(By.tagName("input"));
        textBox.sendKeys(keywords);
    }

    public void inputMetaDescription(String description) {
        wait.until(ExpectedConditions.visibilityOf(serviceMetaDescription));
        serviceMetaDescription.sendKeys(description);
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
