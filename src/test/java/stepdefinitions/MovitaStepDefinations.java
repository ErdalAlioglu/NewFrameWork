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



    //MQA-32
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

    //MQA -33

    @When("kullanici sayfayi asagi indirir ve besinci sectionda durur")
    public void kullanici_sayfayi_asagi_indirir_ve_besinci_sectionda_durur() throws InterruptedException {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        Thread.sleep(2000);
    }
    @Then("kullanici cozumler kisminda bulunan dort bolume hover over yapar ve strigleri verify eder")
    public void kullanici_cozumler_kisminda_bulunan_dort_bolume_hover_over_yapar_ve_strigleri_verify_eder() {


        Assert.assertTrue(movita.okul_servis_araclari_takip_sistemi.isDisplayed());
        Assert.assertTrue(movita.Kamerali_Arac_Takip_ve_Mobil_Kamera_Görüntüleme_Sistemi.isDisplayed());
        Assert.assertTrue(movita.kisi_bilgilendirme_servisi.isDisplayed());
        Assert.assertTrue(movita.kisi_nesne_hayvan_takip_sistemi.isDisplayed());
    }
    @Then("kullanici “Kisi Bilgilendirme Sistemi” click edince “Kisi Bilgilendirme Sistemi” verify eder")
    public void kullanici_kisi_bilgilendirme_sistemi_click_edince_kisi_bilgilendirme_sistemi_verify_eder() throws InterruptedException {
   movita.kisi_bilgilendirme_string_b.click();
   Assert.assertTrue(movita.kisi_bilgilendirme_tiklama.isDisplayed());
   Thread.sleep(2000);
   movita.anasayfa.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        Thread.sleep(2000);

    }

    @Then("kullanici {string} uzerine hover over yapar arkaplan renk degisimini verify eder")
    public void kullanici_uzerine_hover_over_yapar_arkaplan_renk_degisimini_verify_eder(String string) {
        String color_before = movita.yediden_yetmise.getCssValue("background-color");
        String color_b_hex = Color.fromString(color_before).asHex();

        ReusableMethods.hover(movita.yediden_yetmise);
        ReusableMethods.waitForVisibility(movita.yediden_yetmise, 500);

        String color_after = movita.yediden_yetmise.getCssValue("background-color");
        String color_a_hex = Color.fromString(color_after).asHex();
        Assert.assertNotEquals(color_a_hex, color_b_hex);
    }
    @Then("kullanici {string} yazini click eder {string} stringini verify eder")
    public void kullanici_yazini_click_eder_stringini_verify_eder(String string, String string2) {
movita.yediden_yetmise_clk.click();
Assert.assertTrue(movita.yediden_yetmise_string.isDisplayed());
        movita.anasayfa.click();

    }

    @And("kullanici kisi nesne hayvan takip sistemi click edince stringi verify eder")
    public void kullaniciKisiNesneHayvanTakipSistemiClickEdinceStringiVerifyEder() throws InterruptedException {
        movita.kisi_nesne_hayvan_takip_sistemi_strin_b.click();
        Assert.assertTrue(movita.kisi_nesne_hayvan_takip_sistemi_tiklama.isDisplayed());
        Thread.sleep(2000);
        movita.anasayfa.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        Thread.sleep(2000);
    }
}
