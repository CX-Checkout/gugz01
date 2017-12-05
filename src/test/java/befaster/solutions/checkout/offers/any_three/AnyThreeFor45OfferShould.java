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

    // S = 20
    // T = 20
    // X = 17
    // Y = 20
    // Z = 21
    @Test
    @Parameters({
            "A, 0, A",
            "STX, 12, ", // 20 + 20 + 17
            "XTS, 12, ", // 17 + 20 + 20
            "XYZ, 13, ", // 21 + 20 + 17
            "TXY, 12, ", // 21 + 20 + 17
            "XTSA, 12, A",
            "XTSTA, 15, XA",    // 21 + 20 + 17 + 21
            "TXYTXY, 24, ",     // (21 + 20 + 17) * 2
            "TXYTXYAB, 24, AB", // (21 + 20 + 17) * 2
            "SSSZ, 16, S",     // 20 + 20 + 20 + 21 = 81 - 45 = 36
    })
    public void
    return_45_if_any_3_of_S_T_X_Y_Z(String skus, int discount, String remainingSkus) {
        DiscountResult discountResult = anyThreeFor45Offer.discountFor(skus);
        assertThat(discountResult.discount, is(discount));
        assertThat(discountResult.remainingSkus, is(remainingSkus));
    }

}
