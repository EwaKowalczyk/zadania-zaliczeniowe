package pl.CodersLab.zadanie1.pages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MySteps {

    WebDriver driver;
    @Given("I'm on a store main page")
    public void iMOnAStoreMainPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl");
    }

    @When("I go to login page")
    public void iGoToLoginPage() {
        mainPage mainPage = new mainPage(driver);
        mainPage.logIn();
    }

    @And("I log in using email {string} and password {string}")
    public void iLogInUsingEmailAndPassword(String email, String passwd) {
        loginPage loginPage = new loginPage(driver);
        loginPage.signIn();
    }

    @And("I go on addresses page")
    public void iGoOnAddressesPage() {
        userPage userPage = new userPage(driver);
        userPage.addresses();

    }

    @And("I go on Create new address")
    public void iGoOnCreateNewAddress() {
        addressesPage addressesPage = new addressesPage(driver);
        addressesPage.createAddress();
    }

    @And("I enter new address {string}, {string}, {string}, {string}, {string}, {string}")
    public void iEnterNewAddress(String alias, String address, String city, String postalCode, String country, String phone) {
        addressesPage addressesPage = new addressesPage(driver);
        addressesPage.addressForm(alias, address, city, postalCode, country, phone);
    }

    @Then("I verify created address {string}, {string}, {string}, {string}, {string}, {string}")
    public void iVerifyCreatedAddress(String alias, String address, String city, String postalCode, String country, String phone) {
            String addressAsText = addressesPage.getFirstAddressAsText();
            String expectedAddress = String.join("\n", alias + "\n" + "Ewa Ewa" + "\n" + address + "\n" + city + "\n"  + postalCode + "\n" + country + "\n" + phone);
            Assertions.assertEquals(expectedAddress, addressAsText);
        }

        @And("I close browser")
        public void iCloseBrowser() {
            driver.quit();
        }


}
