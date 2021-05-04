/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskuri;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import dao.AccountDao;

/**
 *
 * @author Kuningas
 */
public class Service {
    private AccountDao dao;
    private account logged;
    /**
     * Konstruktori servicelle
     * @param dao 
     */
    public Service(AccountDao dao) {
        this.dao = dao;
    }
    /**
     * Kirjaa sisään
     * @param name
     * @return 
     */
    public boolean login(String name) {
        account acc = dao.findName(name);
        if (acc == null) {
            return false;
        } 
        logged = acc;
        return true;
    }
    /**
     * Tulostaa nyt kirjautuneen accountin
     * @return 
     */
    public account getLoggedAcc() {
        return logged;
    }
    /**
     * Kirjaa ulos
     */
    public void logout() {
        try {
            dao.synToFile(dao.getAll());
            logged = null;
        } catch (Exception ex) {
            logged = null;
        }
    }
    /**
     * Oikeesti luo accountin muistiin
     * @param name
     * @param pass
     * @return 
     */
    public boolean crtAccount(String name, String pass) {
        if (dao.findName(name) != null) {
            return false;
        }
        account nAcc = new account(name, pass);
        try {
            dao.make(nAcc);
        } catch(Exception e) {
            return false;
        }
        return true;
    }
}
