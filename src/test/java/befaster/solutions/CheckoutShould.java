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
            "a, -1",
            "ABCs, -1",
            ", -1",
    })
    public void
    return_minus_one_for_any_invalid_input(String skus, int price) {
        assertThat(Checkout.checkout(skus), is(price));
        assertThat(Checkout.checkout(""), is(-1));
    }

    @Test
    public void
    return_minus_one_for_empty_input() {
        assertThat(Checkout.checkout(null), is(-1));
        assertThat(Checkout.checkout(""), is(-1));
    }

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

    @Test
    @Parameters({
            "AAA, 130",
            "AAAAAA, 260",
            "AAAA, 180",
            "AAAB, 160",
    })
    public void
    return_multi_price_for_A(String skus, int price) {
        assertThat(Checkout.checkout(skus), is(price));
    }

    @Test
    @Parameters({
            "BB, 45",
            "BBBB, 90",
            "BBB, 75",
            "BBA, 95",
    })
    public void
    return_multi_price_for_B(String skus, int price) {
        assertThat(Checkout.checkout(skus), is(price));
    }

}
