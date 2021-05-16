# Testausdokumentti
## Yksikkötestaus
Testiluokkia on vain yksi. Se testaa ohjelman kahta oleellista luokkaa account ja FileAccountDao. Dao luokan testaus toimii hyödyntäen TemporaryFolder-ruleja. Accoount-luokkaa testataan kaikin mahdollisin tavoin, tosin se sisältää suurimmaksi osaksi vain gettereitä ja settereitä, joten testattavaa ei ole paljoa. 

Ohessa kuva testiraportista. 

![image](https://user-images.githubusercontent.com/62245568/118405378-51d64c80-b680-11eb-888c-acec2495c188.png)

## Muu testaus
Sovelluksen ui on testailtu täysin manuaalisesti. 

## Sovellukseen jääneet ongelmat 
* Sovellukseen ei pysty avaamisen jälkeen välittömästi kirjautumaan, jokin käyttäjä täytyy luoda ensin.
* Jos sovellukseen luo käyttäjän, tämän jälkeen toisen ja sitten yrittää kirjautua ensimmäisellä, näytetään väärän käyttäjän opintopisteet. 
