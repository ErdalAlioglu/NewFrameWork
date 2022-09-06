package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MovitaPage {
    public MovitaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//div[text()=\"Kurumsal\"]")
    public WebElement kurumsalMenu;

    @FindBy(xpath = "(//ul[@class=\"sub-menu-container\"])[1]")
    public List<WebElement> subKurumsalMenu;

    @FindBy(id = "logo")
    public WebElement movitaLogo;

    @FindBy(xpath = "//div[text()=\"Mobil Vasıta İzleme Takip Sistemi\"]")
    public WebElement mainTextTurkish;


    @FindBy(xpath = "//*[@id=\"dropdownMenuButton\"]")
    public WebElement dropdownMenubutton;
    @FindBy(xpath = "//a[@class=\"dropdown-item\"][2]")
    public WebElement logo_eng;

    @FindBy(xpath = "//div[text()=\"Mobile Vehicle Traking System\"]")
    public WebElement mainTextEnglish;



}
