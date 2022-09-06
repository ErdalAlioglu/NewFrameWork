package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import pages.MovitaPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class MovitaStepDefinations {
    MovitaPage movitaPage=new MovitaPage();

    @Given("kullanici movita sayfasına gider")
    public void kullanici_movita_sayfasına_gider() throws IOException, InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));

    }
    @Then("kullanici movita anasayfada oldugunu dogrular")
    public void kullanici_movita_anasayfada_oldugunu_dogrular() throws IOException {
        String movitaTitle = Driver.getDriver().getTitle();
        System.out.println("movitaTitle = " + movitaTitle);


    }

    @And("kullanici movita logosu üzerine hoverover yapar")
    public void kullanici_movita_logosu_üzerine_hoverover_yapar() throws IOException {
ReusableMethods.hover(movitaPage.movitaLogo);


    }
    @Then("kullanici motita logosunun clickable olduğunu görür")
    public void kullanici_motita_logosunun_clickable_olduğunu_görür() throws IOException {
ReusableMethods.waitForClickablility(movitaPage.movitaLogo,5000);


    }
    @Then("kullanici movita logosunu tiklar")
    public void kullanici_movita_logosunu_tiklar() throws IOException {
       movitaPage.movitaLogo.click();
        ReusableMethods.getScreenshot("Anasayfa");
    }
    @Then("kullanici ekranda verilen stringi verify eder")
    public void kullanici_ekranda_verilen_stringi_verify_eder() throws IOException {
        String yazi=movitaPage.mainTextTurkish.getText();
        System.out.println("yazi = " + yazi);
    }
    @Then("kullanici sayfayi kapatir")
    public void kullanici_sayfayi_kapatir() {
        Driver.closeDriver();
    }


}