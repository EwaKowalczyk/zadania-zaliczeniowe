package pl.CodersLab.zadanie1.pages;

import org.openqa.selenium.By;
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

    public void addresses() {
        addressesLink.click();
    }
    }


