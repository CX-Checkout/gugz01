package befaster.solutions.checkout;

import befaster.solutions.checkout.offers.DiscountResult;
import befaster.solutions.checkout.offers.Offer;
import befaster.solutions.checkout.offers.any_three.AnyThreeFor45Offer;
import befaster.solutions.checkout.offers.combined_item._2E_1B_Free_Offer;
import befaster.solutions.checkout.offers.combined_item._3N_1M_Free_Offer;
import befaster.solutions.checkout.offers.combined_item._3R_1Q_Free_Offer;
import befaster.solutions.checkout.offers.multi_item.*;
import befaster.solutions.checkout.offers.same_item_free._2F_1F_Free_Offer;
import befaster.solutions.checkout.offers.same_item_free._3U_1U_Free_Offer;

import static befaster.solutions.checkout.SKUs.pricesFor;
import static befaster.solutions.checkout.SKUs.valid;
import static com.google.common.base.Strings.isNullOrEmpty;

public class Checkout {

    static Offer[] offers = new Offer[] {
            new AnyThreeFor45Offer(),
            new _2E_1B_Free_Offer(),
            new _3N_1M_Free_Offer(),
            new _3R_1Q_Free_Offer(),
            new _2F_1F_Free_Offer(),
            new _3U_1U_Free_Offer(),
            new ThreeVsOffer(),
            new TwoVsOffer(),
            new ThreeQsOffer(),
            new FivePsOffer(),
            new TwoKsOffer(),
            new TenHsOffer(),
            new FiveHsOffer(),
            new TwoBsOffer(),
            new FiveAsOffer(),
            new ThreeAsOffer(),
    };

    public static Integer checkout(String skus) {
        if (isNullOrEmpty(skus)) return 0;
        if (!valid(skus)) return -1;
        return pricesFor(skus) - discounts(skus);
    }
    
    private static Integer discounts(String skus) {
        int totalDiscount = 0;
        DiscountResult offerDiscount;
        String remainingSKUs = skus;
        for (Offer offer : offers) {
            offerDiscount = offer.discountFor(remainingSKUs);
            remainingSKUs = offerDiscount.remainingSkus;
            totalDiscount += offerDiscount.discount;
        }
        return totalDiscount;

    }

}
