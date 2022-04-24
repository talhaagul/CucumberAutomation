package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.eo.Do;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.N11Page;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.WriteToTxt;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N11StepDefinitions {

    N11Page n11Page = new N11Page();
    Actions actions = new Actions(Driver.getDriver());
    Select select;

    @Given("Kullanici {string} sayfasina gider")
    public void kullanici_sayfasina_gider(String istenenUrl) {
        Driver.getDriver().get(ConfigurationReader.getProperty(istenenUrl));

        try {
            n11Page.anasayfaKonumBelirlemeTamamElementi.click();
        } catch (Exception e) {}
        try {
            n11Page.anasayfaAlertDahaSonraElementi.click();
        } catch (Exception e) {}

    }

    @Given("Mouse ile Header kismindaki Magazalar menusunun uzerine gelir")
    public void mouse_ile_header_kismindaki_magazalar_menusunun_uzerine_gelir() {
        actions.moveToElement(n11Page.anasayfaMagazalarMenuElementi).perform();
    }

    @Given("Magazalari gor secenegine tiklar")
    public void magazalari_gor_secenegine_tiklar() {
        n11Page.magazalarMenuMagazalariGorElementi.click();
    }

    @Then("A harfiyle baslayan magazalari listeler")
    public void a_harfiyle_baslayan_magazalari_listeler() {
        actions.moveToElement(n11Page.magazalarSayfasiAharfiyleBaslayanMagazalariListelemeElementi).click().perform();
        actions.moveToElement(n11Page.magazalarSayfasiTumMagazalarTablosu).perform();
    }

    @Then("Magazalari kaydeder")
    public void magazalari_kaydeder() throws IOException {
        List<String> tumMagazalarList = new ArrayList<>();
        for (int i=0; i< n11Page.magazalarSayfasiTumMagazalarListesi.size(); i++) {
            tumMagazalarList.add(n11Page.magazalarSayfasiTumMagazalarListesi.get(i).getText());
        }
        //System.out.println(tumMagazalarList);
        WriteToTxt.saveData(tumMagazalarList);
    }


    // TC02
    @Given("Arama kutusuna {string} yazar ve aratir")
    public void arama_kutusuna_yazar_ve_aratir(String aranacakMetin) {
         n11Page.anasayfaAramaKutusuElementi.sendKeys(aranacakMetin + Keys.ENTER);
    }

    @Then("Gelen sonuclari yorum sayisina gore siralar")
    public void gelen_sonuclari_yorum_sayisina_gore_siralar() {
        select = new Select(n11Page.aramaSayfasiSiralamaDropdownMenuElementi);
        select.selectByValue("REVIEWS");
    }

    @Then("Urunlerden ucretsiz kargo olanlari secer")
    public void urunlerden_ucretsiz_kargo_olanlari_secer() {
        n11Page.aramaSayfasiUcretsizKargoCheckboxElementi.click();
    }

    @Then("Sonuclardan birinci ve sonuncu olani sepete ekler")
    public void sonuclardan_birinci_ve_sonuncu_olani_sepete_ekler() {

       n11Page.urunListesi.get(0).click();
       n11Page.sepeteEkleButonu.click();
       Driver.getDriver().navigate().back();

       actions.moveToElement(n11Page.urunListesi.get(n11Page.urunListesi.size()-1)).perform();
       n11Page.urunListesi.get(n11Page.urunListesi.size()-1).click();

       try {
           select = new Select(n11Page.sonUrunRenkSecimiDropdown);
           select.selectByIndex(1);
           n11Page.sepeteEkleButonu.click();
       } catch (Exception e){
           n11Page.sepeteEkleButonu.click();
       }

    }

    @Then("Sepete gider ve en ucuz urunun adet sayisini {int} yapar")
    public void sepete_gider_ve_en_ucuz_urunun_adet_sayisini_yapar(Integer adet) {
        n11Page.sepetButonu.click();
        n11Page.musteriAydinlatmaMetniTamamButonu.click();

        List<String> fiyatlarListe = new ArrayList<>();
        for (int i=0; i< n11Page.sepettekiUrunFiyatlariListesi.size(); i++) {
            fiyatlarListe.add(n11Page.sepettekiUrunFiyatlariListesi.get(i).getText());
        }

        List<Integer> fiyatListesi2 = new ArrayList<>();
        for (int i=0; i< fiyatlarListe.size(); i++) {
            fiyatListesi2.add(Integer.parseInt(fiyatlarListe.get(i).replaceAll("\\D","")));
        }


        if (fiyatListesi2.get(1) > fiyatListesi2.get(0)){
            n11Page.sepettekiIlkUrunAdetArttırmaButonu.click();
        } else {
            n11Page.sepettekiIkinciUrunAdetArttırmaButonu.click();
        }

    }

    @Then("Misafir olarak odeme adimina ilerler")
    public void misafir_olarak_odeme_adimina_ilerler() {
        n11Page.sepetSatinAlButonu.click();
        n11Page.uyeOlmadanDevamEtLinki.click();
    }


    @And("Istenilen iletisim bilgilerini girer ve ödeme adimina gecer {string},{string},{string},{string},{string}")
    public void istenilenIletisimBilgileriniGirerVeÖdemeAdiminaGecer(String email, String ceptelefonu, String adSoyad, String adres, String ceptelefonu2) {
        n11Page.sepetEmailTextbox.sendKeys(email);
        select = new Select(n11Page.sepetIlkTelefonAlankoduDropdownMenu);
        select.selectByValue("+1");
        n11Page.sepetIlkTelefonNumarasiTextBox.sendKeys(ceptelefonu);
        n11Page.sepetDogrulaVeDevamEtButonu.click();

        //actions.moveToElement(n11Page.sepetFaturaBilgisiYazisi).perform();

        n11Page.sepetAdSoyadTextBox.sendKeys(adSoyad);

        select = new Select(n11Page.sepetIlSecimiDropdownMenu);
        select.selectByValue("2506");
        ReusableMethods.waitFor(1);

        select = new Select(n11Page.sepetIlceSecimiDropdownMenu);
        select.selectByValue("22718");
        ReusableMethods.waitFor(1);

        select = new Select(n11Page.sepetSemtSecimiDropdownMenu);
        select.selectByValue("5095");

        n11Page.sepetAcikAdresTextArea.sendKeys(adres);

        n11Page.sepetIkinciTelefonNumarasiTextBox.click();
        n11Page.sepetIkinciTelefonNumarasiTextBox.sendKeys(ceptelefonu2 + Keys.TAB + "90529747104" + Keys.TAB + "ev");

        n11Page.sepetOdemeyeGecButonu.click();

        Assert.assertTrue(n11Page.odemeSayfasiDogrulamaYazisi.isDisplayed());

    }
}
