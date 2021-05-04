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

Toiminnallisuutta tuo luokka Service. Luokka tuo erilaisia metodeja kuten sisään- ja uloskirjautumisen. 

## Tietojen pysyväistallennus
Sovellukseen psytyy tallentamaan käyttäjiä ja näiden opintopisteet, sekä keskiarvot pysyvät muistissa. Nämä tallentuvat tekstitiedostoon accounts.txt. Tällä hetkellä tosin avattaessa sovellus uudestaan, tyhjenee koko accounts.txt tiedosto. 
