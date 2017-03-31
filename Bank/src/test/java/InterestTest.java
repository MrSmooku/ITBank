import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Damian on 17.03.2017.
 */
@RunWith(Parameterized.class)
public class InterestTest {

    Interest interest = null;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
                { InterestFrequency.yearly, 5, 1.05}, {InterestFrequency.quarterly, 5, 1.05094},{InterestFrequency.monthly,2,1.02019}
        });
    }

    private InterestFrequency interestFrequency;
    private int percent;
    private double expected;

    public InterestTest(InterestFrequency interestFrequency, int percent, double expected){
        this.interestFrequency = interestFrequency;
        this.percent = percent;
        this.expected = expected;
    }

    @Before
    public void setUp() throws Exception {
        interest = new Interest(this.interestFrequency,this.percent);
    }

    @After
    public void tearDown() throws Exception {
        interest = null;
    }

    @Test
    public void interestCalculationYearly() throws Exception {
        double calculatedInterest = interest.InterestCalculation(12);
        Assert.assertEquals(this.expected,calculatedInterest,0.0001);
    }


}