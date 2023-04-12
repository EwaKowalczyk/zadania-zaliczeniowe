package pl.CodersLab.zadanie1.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.awt.SystemColor.text;

public class addressesPage {

    private final WebDriver driver;

    public addressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section[@id = 'content']/div/a")
    private WebElement newAddress;

    @FindBy(css = "a[href$='id_address=215']")
    private WebElement updateBtn;

    @FindBy(id = "field-alias")
    private WebElement aliasInput;
    @FindBy(id = "field-address1")
    private WebElement addressInput;
    @FindBy(id = "field-city")
    private WebElement cityInput;
//    @FindBy(id = "field-id_state")
//    private WebElement stateList;
//    @FindBy(xpath = "//select[contains(@name, 'id_state')]/option[contains(@value, '55')]")
//    private WebElement stateListValue;
    @FindBy(id = "field-postcode")
    private WebElement postalCodeInput;
    @FindBy(id = "field-id_country")
    private WebElement countryList;
    @FindBy(xpath = "//select[contains(@name, 'id_country')]/option[contains(@value, '17')]")
    private WebElement countryListValue;
    @FindBy(id = "field-phone")
    private WebElement phoneInput;
    @FindBy(css = "button.form-control-submit")
    private WebElement submitBtn;

    @FindBy(css = "div.address-body")
    private static WebElement address;
    @FindBy(xpath = "//div/a[contains(@data-link-action, 'delete-address')]")
    private WebElement deleteAddressBtn;

    public void addressForm(String alias, String address, String city, String postalCode, String country, String phone){
        aliasInput.sendKeys(alias);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
//        stateList.click();
//        stateListValue.click();
        postalCodeInput.sendKeys(postalCode);
        countryList.click();
        countryListValue.click();
        phoneInput.sendKeys(phone);
        submitBtn.click();
    }

    public void createAddress() {
        newAddress.click();
    }

    public static String  getFirstAddressAsText() {
        String firstAddress = address.getText();
        return firstAddress;
    }

    public void deleteAddress() {
        deleteAddressBtn.click();
    }


}
