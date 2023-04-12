package pl.CodersLab.zadanie2.pages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class shopSteps {
    WebDriver driver;
    @Given("I'm on a shop main page")
    public void iMOnAShopMainPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl");
    }

    @When("I go to the login page")
    public void iGoToTheLoginPage() {
        mainPage mainPage = new mainPage(driver);
        mainPage.logIn();
    }

    @And("I log in using my email {string} and password {string}")
    public void iLogInUsingMyEmailAndPassword(String email, String passwd) {
        loginPage loginPage = new loginPage(driver);
        loginPage.signIn();
    }

    @And("I choose clothes category")
    public void iChooseClothesCategory() {
        userPage userPage = new userPage(driver);
        userPage.clothesCategory();
    }

    @And("I add sweater size {string} and quantity {string} to the cart")
    public void iAddSweaterToTheCart(String size, String quantity) {
        shoppingPage shoppingPage = new shoppingPage(driver);
        shoppingPage.addingSweater();
        shoppingPage.chooseSize(size);
        shoppingPage.chooseQuantity(quantity);
        shoppingPage.addToCart();
    }


    @And("I go to cart checkout")
    public void iGoToCartCheckout() {
        cartPage cartPage = new cartPage(driver);
        cartPage.cartCheckout();
        cartPage.proceed();
    }

    @And("I confirm the address")
    public void iConfirmTheAddress() {
        cartPage cartPage = new cartPage(driver);
        cartPage.setAddressDelivery();
    }

    @And("I choose shipping method")
    public void iChooseShippingMethod(){
        cartPage cartPage = new cartPage(driver);
        cartPage.chooseShippingMethod();
    }

    @And("I choose payment option")
    public void iChoosePaymentOption(){
        cartPage cartPage = new cartPage(driver);
        cartPage.choosePaymentOption();
        cartPage.agreeToTheTerms();
    }

    @And("I order with an obligation to pay")
    public void iOrderWithAnObligationToPay(){
        cartPage cartPage = new cartPage(driver);
        cartPage.confirmThePayment();
    }

    @Then("I do screenshot with order confirmation")
    public void iDoScreenshotWithOrderConfirmation() throws IOException {
        //Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(0)).takeScreenshot(driver);
        ImageIO.write(fpScreenshot.getImage(),"PNG",new File("C://Users/Tester/CodersLab/Automatic/zaliczenie — kopia/FullPageScreenshot.png"));
    }

    @And("I close the browser")
    public void iCloseTheBrowser() {
        driver.quit();
    }
}
