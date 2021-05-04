/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskuri;

/**
 *
 * @author Kuningas
 */
public class account {
    private int credit;
    private String name;
    private String password;
    private int amount;
    private double graTot;
    private double avr;
    /**
     * Konstruktori accounteille
     * @param name
     * @param password
     * @param credit
     * @param avr 
     */
    public account(String name, String password, int credit, int avr) {
        this.name = name;
        this.password = password;
        this.credit = credit;
        this.amount = 0;
        this.graTot = 0;
        this.avr = avr;
    }
    /**
     * alternatiivinen konstruktori accounteille
     * @param name
     * @param password 
     */
    public account(String name, String password) {
        this.name = name;
        this.password = password;
        this.credit = 0;
        this.amount = 0;
        this.graTot = 0;
        this.avr = getAvr();
    }
    /**
     * Lisää opintopisteitä
     * @param add
     * @param grade 
     */
    public void addCredit(int add, double grade) {
        this.credit += add;
        this.amount++;
        this.graTot += grade;
    }
    /**
     * tulostaa kyseisen käyttäjän opintopisteet
     * @return 
     */
    public int getCredit() {
        return this.credit;
    }
    /**
     * tulostaa kyseisen käyttäjän nimen
     * @return 
     */
    public String getName() {
        return this.name;
    }
    /**
     * tulostaa kyseisen käyttäjän salasanan
     * @return 
     */
    public String getPass() {
        return this.password;
    }
    /**
     * Tulostaa kyseisen käyttäjän arvosanojen keskiarvon
     * @return 
     */
    public double getAvr() {
        if(this.graTot != 0) {
        return (this.graTot/this.amount);
        }
        return 0;
    }
    /**
     * Kertoo booleanina onko kyseisellä käyttäjällä maisteriin riittävä määrä opintopisteitä
     * @return 
     */
    public boolean hasMs() {
        if (this.credit >= 360) {
            return true;
        }
        return false;
    }
    /**
     * Kertoo booleanina onko kyseisellä käyttäjällä kandiin riittävä määr opintopisteitä
     * @return 
     */
    public boolean hasBc() {
        if (this.credit >= 180) {
            return true;
        }
        return false;
    }
    
}
