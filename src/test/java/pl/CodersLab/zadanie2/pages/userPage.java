package pl.CodersLab.zadanie2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class userPage {
    private final WebDriver driver;

    public userPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[title~=Addresses]")
    private WebElement addressesLink;

    @FindBy(id = "category-3")
    private WebElement clothes;

    public void addresses() {
        addressesLink.click();
    }

    public void clothesCategory(){
        clothes.click();
    }

}
