package pl.CodersLab.zadanie2.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class shoppingPage {

    private  final  WebDriver driver;

    public shoppingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div//a/img[contains(@alt , 'Brown bear printed sweater')]")
    private WebElement sweater;
    @FindBy (id = "group_1")
    private WebElement sizeChoose;

    //@FindBy(id = "group_1")
    //private List<WebElement> sizeChoose;
    @FindBy(css = "[title~='S']")
    private WebElement sizeS;
//    @FindBy(css = "[title~='M']")
//    private WebElement sizeM;
//    @FindBy(css = "[title~='L']")
//    private WebElement sizeL;
//    @FindBy(css = "[title~='XL']")
//    private WebElement sizeXL;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityWantedInput;

    @FindBy(css = ".btn.btn-primary.add-to-cart")
    private WebElement addToCartBtn;

    public void addingSweater(){
        sweater.click();
    }
    public void chooseSize(String size) {
        sizeChoose.click();
        sizeS.click();
    }

    public void chooseQuantity(String quantity) {
        quantityWantedInput.clear();

        //nadpisuje wartość w inpucie
        quantityWantedInput.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), quantity);
    }

    public void addToCart() {
        addToCartBtn.click();
    }
}

