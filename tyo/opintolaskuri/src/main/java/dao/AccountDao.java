/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;
import laskuri.account;
/**
 *
 * @author Kuningas
 */
public interface AccountDao {
    account make(account acc) throws Exception;
    account findName(String name);
    List<account> getAll();
}
