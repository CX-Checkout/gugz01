package befaster.solutions;

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
//            "FF, 0, ",
            "FFF, 10, "
    })
    public void
    return_price_for_TWO_Fs_GET_ONE_F_FREE(String skus, int discount, String remainingSkus) {
        DiscountResult discountResult = TwoFsOffer.discountFor(skus);
        assertThat(discountResult.discount, is(discount));
        assertThat(discountResult.remainingSkus, is(remainingSkus));
    }

}
