import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by marcinkarmelita on 23/03/17.
 */
public class BankingOperationTest {

    BankingOperation fixture;

    @Before
    public void setUp() throws Exception {
        fixture = new BankingOperation();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test(expected = RuntimeException.class)
    public void transferOperationException() throws Exception {
        // (MK): Balance at newly created account equals 0
        Product fromProduct = new BankAccount("765984327574385");
        Product toProduct = new BankAccount("45378783429");
        BankingOperation bankingOperation = new BankingOperation();
        bankingOperation.transferOperation(200, fromProduct, toProduct);
    }

    @Test
    public void transferOperationSuccess() throws Exception {
        // (MK): Balance at newly created account equals 0
        Product fromProduct = new BankAccount("765984327574385");
        Product toProduct = new BankAccount("45378783429");
        fromProduct.addCash(500);
        BankingOperation bankingOperation = new BankingOperation();
        bankingOperation.transferOperation(200, fromProduct, toProduct);
    }

    @Test
    public void incomingCashOperation() throws Exception {
        Product toProduct = new BankAccount("45378783429");
        BankingOperation bankingOperation = new BankingOperation();
        bankingOperation.incomingCashOperation(500, toProduct);
        assertEquals(toProduct.getBalance(), 500, 0.1);
    }

    @Test(expected = RuntimeException.class)
    public void outcomingCashOperationException() throws Exception {
        Product fromProduct = new BankAccount("45378783429");
        BankingOperation bankingOperation = new BankingOperation();
        bankingOperation.outcomingCashOperation(200, fromProduct);
    }

    @Test
    public void outcomingCashOperationSuccess() throws Exception {
        Product fromProduct = new BankAccount("45378783429");
        fromProduct.addCash(500);
        BankingOperation bankingOperation = new BankingOperation();
        bankingOperation.outcomingCashOperation(200, fromProduct);
    }

}