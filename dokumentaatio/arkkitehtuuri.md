# Arkkitehtuurikuvaus
## Rakenne
Ohjelman rakenne on monitasoista ja pakkausrakenne seuraavanlaista:
![image](https://user-images.githubusercontent.com/62245568/117036762-76403980-ad0e-11eb-8c7d-4f9b6f9aed8b.png)

Käyttöliittymä sisältää kolme eri näkymää.
* Kirjautumisnäkymä
* "Luo käyttäjä"-näkymä
* Oma sivu 
Käyttöliittymä on totutettuu laskuri.ui kohtaan. Se käyttää javafx:ää, siinä tarkemmin sceneä. Käyttöliittymä on rakennettu luokassa laskuri.ui.ui
## Sovelluslogiikka
Sovelluksen loogisen datamallin tällä hetkellä muodostaa luokka account, joka sisältää jokaisen käyttäjän salasanan, nimen, opintopistemäärän, sekä opintojen keskiarvon. 

![image](https://user-images.githubusercontent.com/62245568/117037334-07afab80-ad0f-11eb-8bb4-9a8f60c1444d.png)


Toiminnallisuutta tuo luokka Service. Luokka tuo erilaisia metodeja kuten sisään- ja uloskirjautumisen. 

![image](https://user-images.githubusercontent.com/62245568/117037573-4e050a80-ad0f-11eb-8500-918c642a8f11.png)


## Tietojen pysyväistallennus
Sovellukseen psytyy tallentamaan käyttäjiä ja näiden opintopisteet, sekä keskiarvot pysyvät muistissa. Nämä tallentuvat tekstitiedostoon accounts.txt. Tällä hetkellä tosin avattaessa sovellus uudestaan, tyhjenee koko accounts.txt tiedosto. 
