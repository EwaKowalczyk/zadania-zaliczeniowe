package pl.CodersLab.zadanie2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartPage {

    private final WebDriver driver;

    public cartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class, 'cart-content-btn')]/a")
    private WebElement cartBtn;
    @FindBy(css = "a[href$='controller=order']")
    private WebElement proceedToCheckout;
    @FindBy(css = "[name~='id_address_delivery']")
    private WebElement addressDelivery;
    @FindBy(css = "[name~='confirm-addresses']")
    private WebElement addressContinueBtn;
    @FindBy(id = "delivery_option_2")
    private WebElement shippingBtn;
    @FindBy(css = "[name~='confirmDeliveryOption']")
    private WebElement deliveryContinueBtn;
    @FindBy(id = "payment-option-1")
    private WebElement payByCheck;
    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement privacyBtn;
    @FindBy(xpath = "//div[contains(@id, 'payment-confirmation')]/div/button")
    private WebElement paymentConfirmation;

    public void cartCheckout() {
        cartBtn.click();
    }

    public void proceed() {
        proceedToCheckout.click();
    }

    public void setAddressDelivery(){
        addressContinueBtn.click();
    }

    public void chooseShippingMethod() {
        deliveryContinueBtn.click();
    }

    public void choosePaymentOption() {
        payByCheck.click();
    }

    public void agreeToTheTerms(){
        privacyBtn.click();
    }

    public void confirmThePayment() {
        paymentConfirmation.click();
    }
}
