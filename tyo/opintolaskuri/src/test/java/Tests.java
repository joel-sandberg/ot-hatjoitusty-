/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import laskuri.laskeMain;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import laskuri.ui.ui;
import laskuri.account;
/**
 *
 * @author Kuningas
 */
public class Tests {
    account test;
    public Tests() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        String jari = "jari";
         String password = "password";
         test = new account(jari, password);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
     
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
