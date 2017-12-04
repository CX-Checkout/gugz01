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
    })
    public void
    return_minus_one_for_any_invalid_input(String skus, int price) {
        assertThat(Checkout.checkout(skus), is(price));
    }

    @Test
    public void
    return_minus_one_for_empty_input() {
        assertThat(Checkout.checkout(null), is(0));
        assertThat(Checkout.checkout(""), is(0));
    }

    @Test
    @Parameters({
            "A, 50",
            "B, 30",
            "C, 20",
            "D, 15",
            "E, 40",
            "F, 10",
            "G, 20",
            "H, 10",
            "I, 35",
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
            "AAAA, 180",
            "AAAB, 160",
    })
    public void
    return_price_for_three_As_offer(String skus, int price) {
        assertThat(Checkout.checkout(skus), is(price));
    }

    @Test
    @Parameters({
            "AAAAA, 200",
            "AAAAAA, 250",
            "AAAAAAB, 280",
    })
    public void
    return_price_for_five_As_offer(String skus, int price) {
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

    @Test
    @Parameters({
            "EE, 80",
            "EB, 70",
            "EEB, 80",
            "EEEEBBA, 210",
            "EEBBA, 160",
            "EEBBBA, 175", // EEB (80) + BB(45) + A(50) = 175
    })
    public void
    return_price_where_two_Es_will_give_a_free_B(String skus, int price) {
        assertThat(Checkout.checkout(skus), is(price));
    }

    @Test
    @Parameters({
            "FF, 20",
            "FFF, 20"
    })
    public void
    return_price_for_TWO_Fs_GET_ONE_F_FREE(String skus, int price) {
        assertThat(Checkout.checkout(skus), is(price));
    }


}
