package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class N11Page {

    public N11Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//button[text()='Daha Sonra'])[1]")
    public WebElement anasayfaAlertDahaSonraElementi;

    @FindBy(xpath = "//div[text()='Tamam']")
    public WebElement anasayfaKonumBelirlemeTamamElementi;

    // Anasayfa
    @FindBy(xpath = "//span[@title='Mağazalar']")
    public WebElement anasayfaMagazalarMenuElementi;

    @FindBy(xpath = "//a[@title='Mağazaları Gör']")
    public WebElement magazalarMenuMagazalariGorElementi;

    @FindBy(xpath = "//input[@id='searchData']")
    public WebElement anasayfaAramaKutusuElementi;

    @FindBy(xpath = "//i[@class='icon iconBasket']")
    public WebElement sepetButonu;

    @FindBy(xpath = "//span[@class='btn btnBlack']")
    public WebElement musteriAydinlatmaMetniTamamButonu;

    @FindBy(xpath = "//span[text()='Satın Al']")
    public WebElement sepetSatinAlButonu;

    @FindBy(xpath = "(//span[text()='+'])[1]")
    public WebElement sepettekiIlkUrunAdetArttırmaButonu;

    @FindBy(xpath = "(//span[text()='+'])[2]")
    public WebElement sepettekiIkinciUrunAdetArttırmaButonu;

    // Magazalar
    @FindBy(xpath = "//span[@title='A']")
    public WebElement magazalarSayfasiAharfiyleBaslayanMagazalariListelemeElementi;

    @FindBy(xpath = "(//div[@class='sellerListHolder'])[4]")
    public WebElement magazalarSayfasiTumMagazalarTablosu;

    @FindBy(xpath = "(//div[@class='sellerListHolder'])[4]//ul//a")
    public List<WebElement> magazalarSayfasiTumMagazalarListesi;

    // Arama Sayfasi
    @FindBy(xpath = "//select[@id='sortingType']")
    public WebElement aramaSayfasiSiralamaDropdownMenuElementi;

    @FindBy(xpath = "//input[@id='freeShippingOption']")
    public WebElement aramaSayfasiUcretsizKargoCheckboxElementi;

    @FindBy(xpath = "//*[text()='Sepete Ekle']")
    public WebElement sepeteEkleButonu;

    @FindBy(xpath = "//select[@id='699830111']")
    public WebElement sonUrunRenkSecimiDropdown;

    @FindBy(xpath = "//div[@id='view']//div[@class='columnContent ']//div//a")
    public List<WebElement> urunListesi;

    @FindBy(xpath = "//td[@class='prodPrice']//div//div[@class='priceArea']//span")
    public List<WebElement> sepettekiUrunFiyatlariListesi;

    @FindBy(xpath = "//a[@title='Üye Olmadan Devam Et']")
    public WebElement uyeOlmadanDevamEtLinki;

    @FindBy(xpath = "//input[@id='guestEmail']")
    public WebElement sepetEmailTextbox;

    @FindBy(xpath = "//select[@id='countryDialCode']")
    public WebElement sepetIlkTelefonAlankoduDropdownMenu;

    @FindBy(xpath = "//input[@id='gsmNumber']")
    public WebElement sepetIlkTelefonNumarasiTextBox;

    @FindBy(xpath = "//*[text()='Doğrula ve Devam Et']")
    public WebElement sepetDogrulaVeDevamEtButonu;

    @FindBy(xpath = "(//input[@id='fullName'])[1]")
    public WebElement sepetAdSoyadTextBox;

    @FindBy(xpath = "//select[@name='shippingAddress.cityId']")
    public WebElement sepetIlSecimiDropdownMenu;

    @FindBy(xpath = "//select[@name='shippingAddress.districtId']")
    public WebElement sepetIlceSecimiDropdownMenu;

    @FindBy(xpath = "//select[@name='shippingAddress.neighborhoodId']")
    public WebElement sepetSemtSecimiDropdownMenu;

    @FindBy(xpath = "//textarea[@name='shippingAddress.address']")
    public WebElement sepetAcikAdresTextArea;

    @FindBy(xpath = "//input[@name='shippingAddress.gsm']")
    public WebElement sepetIkinciTelefonNumarasiTextBox;

    @FindBy(xpath = "//input[@name='shippingAddress.tcId']")
    public WebElement sepetTCNoTextBox;

    @FindBy(xpath = "//input[@name='shippingAddress.title']")
    public WebElement sepetAdresBasligiTextBox;

    @FindBy(xpath = "//span[@id='js-goToPaymentBtn']")
    public WebElement sepetOdemeyeGecButonu;

    @FindBy(xpath = "//h3[text()='Ödeme Seçenekleri']")
    public WebElement odemeSayfasiDogrulamaYazisi;


    @FindBy(xpath = "//h3[text()='FATURA BİLGİLERİ']")
    public WebElement sepetFaturaBilgisiYazisi;

}
