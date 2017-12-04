package befaster.solutions.checkout.offers.multi_item;

import befaster.solutions.checkout.offers.DiscountResult;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class MultiItemOfferShould {

    @Test
    @Parameters({
            "A, 3, 20, AAA, 20, "
    })
    public void
    return_discount(String sku,
                    int numberOfItems,
                    int discount,
                    String inputSkus,
                    int totalDiscount,
                    String remainingSkus) {
        MultiItemOffer multiItemOffer = new MultiItemOffer(sku, numberOfItems, discount);

        DiscountResult discountResult = multiItemOffer.discountFor(inputSkus);

        assertThat(discountResult.discount, is(totalDiscount));
        assertThat(discountResult.remainingSkus, is(remainingSkus));
    }

}