package befaster.solutions.checkout.offers;

import befaster.solutions.checkout.offers.DiscountResult;
import befaster.solutions.checkout.offers.TwoEsOffer;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class TwoEsOfferShould {

    @Test
    @Parameters({
            "EE, 0, "
    })
    public void
    return_discount_for_two_Es_offer(String skus, int discount, String remainingSkus) {
        DiscountResult discountResult = TwoEsOffer.discountFor(skus);
        assertThat(discountResult.discount, is(discount));
        assertThat(discountResult.remainingSkus, is(remainingSkus));
    }

}