package befaster.solutions.checkout.offers;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class TwoFsOfferShould {

    @Test
    @Parameters({
            "FF, 0, FF",
            "FFF, 10, ",
            "FFFF, 10, F",
            "FFFFFF, 20, ",
            "FFFFFFFF, 20, FF"
    })
    public void
    return_price_for_TWO_Fs_GET_ONE_F_FREE(String skus, int discount, String remainingSkus) {
        DiscountResult discountResult = TwoFsOffer.discountFor(skus);
        assertThat(discountResult.discount, is(discount));
        assertThat(discountResult.remainingSkus, is(remainingSkus));
    }

}