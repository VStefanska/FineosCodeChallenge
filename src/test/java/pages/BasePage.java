package pages;

import org.openqa.selenium.support.PageFactory;

import static support.Driver.getDriver;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    //In this class will be stored all the elements and methods that are common for all application pages
}
