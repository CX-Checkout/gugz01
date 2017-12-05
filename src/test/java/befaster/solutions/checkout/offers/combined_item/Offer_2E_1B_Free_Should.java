package befaster.solutions.checkout.offers.combined_item;

import befaster.solutions.checkout.offers.DiscountResult;
import befaster.solutions.checkout.offers.Offer;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class Offer_2E_1B_Free_Should {

    private Offer twoEsOffer;

    @Before
    public void initialise() {
        twoEsOffer = new Offer_2E_1B_Free();
    }

    @Test
    @Parameters({
            "EE, 0, "
    })
    public void
    return_discount_for_two_Es_offer(String skus, int discount, String remainingSkus) {
        DiscountResult discountResult = twoEsOffer.discountFor(skus);
        assertThat(discountResult.discount, is(discount));
        assertThat(discountResult.remainingSkus, is(remainingSkus));
    }

}