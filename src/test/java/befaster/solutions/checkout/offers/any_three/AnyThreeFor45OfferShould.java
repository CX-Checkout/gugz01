package befaster.solutions.checkout.offers.any_three;

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
public class AnyThreeFor45OfferShould {

    private Offer anyThreeFor45Offer;

    @Before
    public void initialise() {
        anyThreeFor45Offer = new AnyThreeFor45Offer();
    }

    @Test
    @Parameters({
            "A, 0, A",
            "STX, 45, ",
            "XTS, 45, ",
            "XTSA, 45, A",
    })
    public void
    return_45_if_any_3_of_S_T_X_Y_Z(String skus, int discount, String remainingSkus) {
        DiscountResult discountResult = anyThreeFor45Offer.discountFor(skus);
        assertThat(discountResult.discount, is(discount));
        assertThat(discountResult.remainingSkus, is(remainingSkus));
    }

}
