import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by marcinkarmelita on 28/04/17.
 */
public class OutcomingCashCommandTest {
    OutcomingCashCommand fixture;
    IProduct product;
    private Double delta = 0.001;
    @Before
    public void setUp() throws Exception {
        product = new BankAccount("owner");
        fixture = new OutcomingCashCommand(200.0, product);
    }

    @Test
    public void executeOK() throws Exception {
        product.addCash(200);
        Assert.assertEquals(product.getBalance(), 200.0, delta);
        fixture.execute();
        Assert.assertEquals(product.getBalance(), 0.0, delta);
    }

    @Test(expected = RuntimeException.class)
    public void executeNotOK() throws Exception {
        product.addCash(100.0);
        Assert.assertEquals(product.getBalance(), 100.0, delta);
        fixture.execute();
    }

    @Test(expected = RuntimeException.class)
    public void executeTwice() throws Exception {
        product.addCash(200.0);
        Assert.assertEquals(product.getBalance(), 200.0, delta);
        fixture.execute();
        fixture.execute();
    }

}