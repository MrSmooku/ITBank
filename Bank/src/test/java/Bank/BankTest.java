package Bank;

import Client.Client;
import Product.BankAccount;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by krzysztof on 23/03/2017.
 */
public class BankTest {


    Bank bank = null;

    @Before
    public void setUp() throws Exception {
        bank = new Bank();
    }

    @After
    public void tearDown() throws Exception {
        bank = null;
    }

    @Test
    public void createClient() throws Exception {
        assertNotNull(bank.createClient("Adam", "Mickiewicz", "Polska"));
    }

    @Test
    public void addProductForClient() throws Exception {
        Client client = bank.createClient("Adam", "Mickiewicz", "Polska");
        BankAccount product = new BankAccount(client.getId());

        assertEquals(product.getId(), bank.addProductForClient(product));
    }

//    @Test
//    public void transferOperation() throws Exception {
//        Client.Client client1 = bank.createClient("Adam", "Mickiewicz", "Polska");
//        Client.Client client2 = bank.createClient("Jan", "Kochanowski", "Polska");
//        Product.BankAccount product1 = new Product.BankAccount(client1.getId());
//        Product.BankAccount product2 = new Product.BankAccount(client2.getId());
//
//        product1.addCash(200.0);
//
//        bank.addProductForClient(product1);
//        bank.addProductForClient(product2);
//
//        assertTrue(bank.transferOperation(200, product1.getId(), product2.getId()),true);
//    }
}
