package stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.MovitaPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MovitaStepDefinations {
    MovitaPage movita = new MovitaPage();
    WebElement dropdownMenubutton;
    Select select;

    @Given("kullanici movita sayfasına gider")
    public void kullanici_movita_sayfasına_gider() {
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
    }

    @Then("kullanici movita anasayfada oldugunu dogrular")
    public void kullanici_movita_anasayfada_oldugunu_dogrular() {
        String expected = "GİRİŞ YAP";
        String actual = movita.giris.getText();
        Assert.assertEquals(expected, actual);
    }

    @Then("kullanici movita logosu üzerine hoverover yapar")
    public void kullanici_movita_logosu_üzerine_hoverover_yapar() {
        ReusableMethods.hover(movita.movitaLogo);
    }

    @Then("kullanici motita logosunun clickable olduğunu görür")
    public void kullanici_motita_logosunun_clickable_olduğunu_görür() {
        ReusableMethods.waitForClickablility(movita.movitaLogo, 3000);
    }

    @Then("kullanici movita logosunu tiklar")
    public void kullanici_movita_logosunu_tiklar() {
        {
            movita.movitaLogo.click();
        }
    }

    @Then("kullanici ekranda verilen stringi verify eder")
    public void kullanici_ekranda_verilen_stringi_verify_eder() {
        ReusableMethods.waitForVisibility(movita.mainTextTurkish, 10);
        Assert.assertTrue(movita.mainTextTurkish.isDisplayed());
    }

   /* @Then("kullanici sayfayi asagi indirir")
    public void kullanici_sayfayi_asagi_indirir(String element) throws InterruptedException {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(element, Keys.PAGE_DOWN)
                .perform();
        Thread.sleep(100);

        WebDriver driver = new FirefoxDriver();
        driver.navigate().to(" http://movita.com.tr"); // Web sitesi URL'sini belirtin

        // Selenium JavascriptExecutor kullanarak uygulamada Kaydırma yapmak için
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(3, document.body.scrollHeight*0.5)");
         }
    */



    //yeni case
    @When("kullanici sayfayi asagi indirir ve dorduncu sectionda durur")
    public void kullanici_sayfayi_asagi_indirir_ve_dorduncu_sectionda_durur() throws InterruptedException {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        Thread.sleep(5000);

    }
    @Then("kullanici verilen String ve sayisal verileri dogrular")
    public void kullanici_verilen_string_ve_sayisal_verileri_dogrular() {

        System.out.println(movita.satirKod900K.getText());
        System.out.println(movita.memnunMusteri1500.getText());
        System.out.println(movita.yillikDeneyim5.getText());
        System.out.println(movita.cozumler20.getText());
        System.out.println(movita.mobilMovitaText.getText());





    }
    @Then("kullanici arrow sign üzerinde hoverover yapar")
    public void kullanici_arrow_sign_üzerinde_hoverover_yapar() {
        ReusableMethods.clickWithTimeOut(movita.arrow,300);
    }
    @Then("kullanici arrow sign üzerinde renk degisikligini dogrular")
    public void kullanici_arrow_sign_üzerinde_renk_degisikligini_dogrular() {
        String color_before = movita.arrow.getCssValue("background-color");
        String color_b_hex = Color.fromString(color_before).asHex();

        ReusableMethods.hover(movita.arrow);
        ReusableMethods.waitForVisibility(movita.arrow, 500);

        String color_after = movita.arrow.getCssValue("background-color");
        String color_a_hex = Color.fromString(color_after).asHex();
        Assert.assertNotEquals(color_a_hex, color_b_hex);
    }
    @Then("kullanici arrow sign tiklar")
    public void kullanici_arrow_sign_tiklar() {
       movita.arrow.click();
    }
    @Then("kullanici arrow sign tiklayinca verilen stringi dogrular")
    public void kullanici_arrow_sign_tiklayinca_verilen_stringi_dogrular() {
        ReusableMethods.waitForVisibility(movita.hitapedencozümler,100);
        Assert.assertTrue("Tüm Sektörlere Hitap Eden Çözümler",movita.hitapedencozümler.isDisplayed());

    }

}
