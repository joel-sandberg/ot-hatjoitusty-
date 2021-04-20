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
    public account(String name, String password) {
        this.name = name;
        this.password = password;
        this.credit = 0;
    }
    public void addCredit(int add) {
        this.credit += add;
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
