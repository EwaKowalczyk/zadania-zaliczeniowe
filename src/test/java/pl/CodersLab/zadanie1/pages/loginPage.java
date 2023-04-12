package pl.CodersLab.zadanie1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    private static WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "field-email")
    private WebElement emailInput;

    @FindBy(id = "field-password")
    private WebElement passwdInput;

    @FindBy(id = "submit-login")
    private WebElement signInBtn;

    public void signIn() {
        emailInput.sendKeys("hdqwcrrmekdrpsuvyj@tpwlb.com");
        passwdInput.sendKeys("Ewa12345");
        signInBtn.click();
    }
}
