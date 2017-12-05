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
public class OfferAny3For45Should {

    private Offer anyThreeFor45Offer;

    @Before
    public void initialise() {
        anyThreeFor45Offer = new Offer_Any_3_For_45();
    }

    // S = 20
    // T = 20
    // X = 17
    // Y = 20
    // Z = 21
    @Test
    @Parameters({
            "A, 0, A",
            "STX, 12, ", 
            "XTS, 12, ",
            "XYZ, 13, ",
            "TXY, 12, ",
            "XTSA, 12, A",
            "XTSTA, 15, XA",
            "TXYTXY, 24, ",
            "TXYTXYAB, 24, AB",
            "SSSZ, 16, S",
            "STXS, 15, X",
            "STXZ, 16, X",
    })
    public void
    return_45_if_any_3_of_S_T_X_Y_Z(String skus, int discount, String remainingSkus) {
        DiscountResult discountResult = anyThreeFor45Offer.discountFor(skus);
        assertThat(discountResult.discount, is(discount));
        assertThat(discountResult.remainingSkus, is(remainingSkus));
    }

}