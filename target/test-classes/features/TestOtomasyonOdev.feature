@X
Feature: TestOtomasyonOdev

  Background: n11 Anasayfasina gider
    Given Kullanici "n11Url" sayfasina gider

  Scenario: TC01_Odev1
    And Mouse ile Header kismindaki Magazalar menusunun uzerine gelir
    And Magazalari gor secenegine tiklar
    Then A harfiyle baslayan magazalari listeler
    And Magazalari kaydeder
    #Cok fazla magaza oldugu icin kayit islemi uzun surebilir
    #Magazalar Proje altında TumMagazalar.txt dosyasina kaydedilir
    #Ornek olarak 10 adet kaydedildi

  Scenario Outline: TC02_Odev2
    And Arama kutusuna "kulaklık" yazar ve aratir
    Then Gelen sonuclari yorum sayisina gore siralar
    And Urunlerden ucretsiz kargo olanlari secer
    And Sonuclardan birinci ve sonuncu olani sepete ekler
    Then Sepete gider ve en ucuz urunun adet sayisini 2 yapar
    And Misafir olarak odeme adimina ilerler
    And Istenilen iletisim bilgilerini girer ve ödeme adimina gecer "<Email>","<Ceptelefonu>","<AdSoyad>","<Adres>","<Ceptelefonu2>"
    Examples:
      |Email|Ceptelefonu|AdSoyad|Adres|Ceptelefonu2
      |catlaina.md.e9c.0.8@gmail.com|6156012063|Kenan Kara|merkez mahallesi|078538901
