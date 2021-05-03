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
    private List<account> accounts;
    private String file;
    
    public FileAccountDao(String file) throws Exception {
        accounts = new ArrayList<>();
        this.file = file;
        try {
            Scanner r = new Scanner(new File(file));
            while (r.hasNextLine()) {
                String[] p = r.nextLine().split(";");
                account n = new account(p[0],p[1],Integer.valueOf(p[2]),Integer.valueOf(p[3]));
                
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
    @Override
    public List<account> getAll() {
        return accounts;
    }
    @Override
    public account findName(String name) {
        return accounts.stream()
            .filter(u->u.getName()
            .equals(name))
            .findFirst()
            .orElse(null);
    }
     @Override
    public account make(account acc) throws Exception {
        accounts.add(acc);
        save();
        return acc;
    }  
    public void update(account acc) throws Exception {
        try {
            Scanner r = new Scanner(new File(this.file));
            while (r.hasNextLine()) {
                String[] p = r.nextLine().split(";");
                int i = 0;
                if (p[i].equals(acc.getName())) {
                    
                }
            }
            } catch (Exception e) {
            FileWriter w = new FileWriter(new File(this.file));
            w.close();
        }
    }
}
