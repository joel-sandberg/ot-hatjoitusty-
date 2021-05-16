
package dao;
import java.util.ArrayList;
import java.util.List;
import laskuri.account;
/**
 *
 * @author Kuningas
 */
public interface AccountDao {
    account make(account acc) throws Exception;
    account findName(String name);
    ArrayList<account> getAll();
    void synToFile(ArrayList<account> accList)throws Exception;
}
