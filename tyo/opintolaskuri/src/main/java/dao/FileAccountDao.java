/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import laskuri.account;
/**
 *
 * @author Kuningas
 */
public class FileAccountDao implements AccountDao {
    private ArrayList<account> accounts;
    private String file;
    /**
     * Konstruktori accountdaolle
     * @param file
     * @throws Exception 
     */
    public FileAccountDao(String file) throws Exception {
        accounts = new ArrayList<>();
        this.file = file;
        try {
            Scanner r = new Scanner(new File(file));
            while (r.hasNextLine()) {
                String[] p = r.nextLine().split(";");
                account n = new account(p[0],p[1],Integer.valueOf(p[2]),Double.valueOf(p[3]));
                
                accounts.add(n);
            }
        } catch (Exception e) {
            FileWriter w = new FileWriter(new File(file));
            w.close();
        }
    }
    private void save() throws Exception {
        try(FileWriter w = new FileWriter(new File(file))) {
            for(account acc : accounts) {
                w.write(acc.getName() + ";" + acc.getPass() + ";" + acc.getCredit() + ";" + acc.getAvr() + "\n");
            }
        }
    }
    /**
     * Tulostaa kaikki accountit
     * @return 
     */
    @Override
    public ArrayList<account> getAll() {
        return accounts;
    }
    /**
     * Tarkistaa löytyykö kyseistä accountia järjestelmästä
     * @param name
     * @return 
     */
    @Override
    public account findName(String name) {
        return accounts.stream()
            .filter(a->a.getName()
            .equals(name))
            .findFirst()
            .orElse(null);
    }
    /**
     * Luo accountin muistiin
     * @param acc
     * @return
     * @throws Exception 
     */
     @Override
    public account make(account acc) throws Exception {
        accounts.add(acc);
        save();
        return acc;
    }  
    /**
     * Tallentaa nykyiset tiedot
     * @param accList
     * @throws Exception 
     */
    @Override
    public void synToFile(ArrayList<account> accList) throws Exception {
        if (accList == null) {
            return;
        }
      save();
    }
    
    
   
    }

