
import dao.AccountDao;
import dao.FileAccountDao;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import laskuri.account;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
/**
 *
 * @author Kuningas
 */
public class Tests {
    @Rule
    public TemporaryFolder tempFold = new TemporaryFolder();
    
    account test;
    File file;
    AccountDao dao;
    public Tests() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        file = tempFold.newFile("test_accounts.txt");
        try (FileWriter tryFile = new FileWriter(file.getAbsolutePath())) {
            tryFile.write("testName;testPass;0;0.0\n");
        }
        
        dao = new FileAccountDao(file.getAbsolutePath());
        
        String jari = "jari";
        String password = "password";
        test = new account(jari, password);
    }
    
    @After
    public void tearDown() {
        file.delete();
    }

    @Test
     public void correctSizeAccounts() {
     List<account> accs = dao.getAll();
     assertEquals(1, accs.size());
     }
     
     @Test
     public void canFindAccount() {
     account account = dao.findName("testName");
     assertEquals("testName",account.getName());
     }
     @Test
     public void cannotFindAccount() {
     account account = dao.findName("pimppi");
     assertEquals(null,account);
     }
     @Test
     public void createAccName() {
         
         String out = test.getName();
         assertEquals("jari", out);
     }
     @Test
     public void createAccPass() {
         
         String out = test.getPass();
         assertEquals("password", out);
     }
     @Test
     public void createAccStartCredit() {
         
         int out = test.getCredit();
         assertEquals(0, out);
     }
     @Test
     public void createAccAddCredit() {
         
         test.addCredit(20, 1);
         int out = test.getCredit();
         assertEquals(20, out);
     }
     @Test
     public void createAccAddAlotCredit() {
         for(int i = 0; i <100; i++){
         test.addCredit(100, 1);
         }
         int out = test.getCredit();
         assertEquals(10000, out);
     }
     @Test
     public void createAccHasBc() {
         
         test.addCredit(200, 1);
         
         assertEquals(test.hasBc(), true);
     }
     @Test
     public void createAccHasMs() {
         
         test.addCredit(400, 1);
         
         assertEquals(test.hasMs(), true);
     }
     @Test
     public void createAccHasNotBc() {
         
         test.addCredit(100, 1);
         
         assertEquals(test.hasBc(), false);
     }
     @Test
     public void createAccHasNotMs() {
         
         test.addCredit(100, 1);
         
         assertEquals(test.hasMs(), false);
     }
     
}
