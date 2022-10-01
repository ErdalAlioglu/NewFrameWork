@Movit
Feature: Movita Test

  Scenario: MQA-1anasayfaLogoTesti
    Given kullanici movita sayfasına gider
    Then kullanici movita anasayfada oldugunu dogrular
    And kullanici movita logosu üzerine hoverover yapar
    Then kullanici motita logosunun clickable olduğunu görür
    And kullanici movita logosunu tiklar
    Then kullanici ekranda verilen stringi verify eder