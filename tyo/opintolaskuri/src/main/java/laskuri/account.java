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
    public account(String name, String password) {
        this.name = name;
        this.password = password;
        this.credit = 0;
        this.amount = 0;
        this.graTot = 0;
    }
    public void addCredit(int add, int grade) {
        this.credit += add;
        this.amount++;
        this.graTot += grade;
    }
    public int getCredit() {
        return this.credit;
    }
    public String getName() {
        return this.name;
    }
    public String getPass() {
        return this.password;
    }
    public double getAvr() {
        if(this.graTot != 0) {
        return (this.graTot/this.amount);
        }
        return 0;
    }
    public boolean hasMs() {
        if (this.credit >= 360) {
            return true;
        }
        return false;
    }
    public boolean hasBc() {
        if (this.credit >= 180) {
            return true;
        }
        return false;
    }
}
