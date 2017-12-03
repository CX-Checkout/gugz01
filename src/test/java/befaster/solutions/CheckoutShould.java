package befaster.solutions;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class CheckoutShould {

    @Test
    @Parameters({
            "A, 50",
            "B, 30",
            "C, 20",
            "D, 15",
    })
    public void
    return_individual_price_of_each_item(String skus, int price) {
        assertThat(Checkout.checkout(skus), is(price));
    }

    @Test
    @Parameters({
            "AA, 100",
            "ABCD, 115"
    })
    public void
    return_price_for_multiple_skus(String skus, int price) {
        assertThat(Checkout.checkout(skus), is(price));
    }

}
