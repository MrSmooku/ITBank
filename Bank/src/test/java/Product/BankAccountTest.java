package Product;

import Product.BankAccount;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

/**
 * Created by marcinkarmelita on 17/03/17.
 */

// TODO (MK): Add missing tests.

public class BankAccountTest {

    BankAccount fixture;

    @Before
    public void setUp() throws Exception {
        fixture = new BankAccount("ownerID");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void addCashCheckBalance() throws Exception {
        assumeTrue(fixture.getBalance() == 0);
        fixture.addCash(200);
        assertEquals(200, fixture.getBalance(), 0.1);
    }

    @Test(expected = Exception.class)
    public void getCash0Balance() throws Exception {
        assumeTrue(fixture.getBalance() == 0.0);
        fixture.getCash(100);
    }


    @Test
    public void getCash() throws Exception {
        fixture.addCash(200);
        assumeTrue(fixture.getBalance() == 200);
        fixture.getCash(200);
    }

    @Test
    public void closeAccountAndGetCash() throws Exception {
        fixture.balance = 200;
        assumeTrue(fixture.getBalance() == 200);
        double cash = fixture.close(5);
        assertEquals(0.0, fixture.getBalance(), 0.1);
        assertEquals(200.0, cash, 0.1);
    }

}