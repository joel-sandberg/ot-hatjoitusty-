# Studies App
Sovelluksen avulla on tarkoitus voida pitää kirjaa opinnoistasi. Sovelluksessa voi olla usempi käyttäjä. Luotuasi käyttäjän sovellukseen voit lisäillä kursseja eri opintopistemäärillä ja eri arvosanoilla. Sovellus laskee arvosanoista keskiarvon ja kertoo riittävätkö opintopistemääräsi kandidaatin- tai maisterintutkintoon. Sovelluksen pysyväistallennuksen luomisessa on otettu mallia [referenssisovelluksesta.](https://github.com/mluukkai/OtmTodoApp)

En saa itse omalla tietokoneella luotua .jar tiedostoa auki, mutta ohjelman saa toimimaan ainakin netbeansin vihreästä napista.

## Dokumentaatio

* [Vaatimusmäärittely](https://github.com/joel-sandberg/ot-hatjoitusty-/blob/master/dokumentaatio/alustavamaarittely.md)
* [Työaikakirjanpito](https://github.com/joel-sandberg/ot-hatjoitusty-/blob/master/dokumentaatio/ty%C3%B6aikakirjanpito.md)
* [Arkkitehtuuri](https://github.com/joel-sandberg/ot-hatjoitusty-/blob/master/dokumentaatio/arkkitehtuuri.md)
* [Käyttöohje](https://github.com/joel-sandberg/ot-hatjoitusty-/blob/master/dokumentaatio/k%C3%A4ytt%C3%B6ohje.md)
## Itse sovellus
[Studies App](https://github.com/joel-sandberg/ot-hatjoitusty-/tree/master/tyo/opintolaskuri)
## Releaset
* [Viikko 6](https://github.com/joel-sandberg/ot-hatjoitusty-/releases/tag/viikko6)
* [Viikko 5](https://github.com/joel-sandberg/ot-hatjoitusty-/releases/tag/viikko5)

## Komentorivitoiminnot
* Testit voi ajaa komennolla mvn test 
* Checkstylen voit suorittaa komennolla mvn jxr:jxr checkstyle:checkstyle. 
* Testikattavuuden taas komennolla mvn jacoco:report. 
* JavaDoc generointi komennolla mvn javadoc:javadoc (En saa tätä itse toimimaan)
* Suoritettava .jar generoidaan komennolla mvn package
