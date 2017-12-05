package befaster.solutions.checkout;

import befaster.solutions.checkout.offers.DiscountResult;
import befaster.solutions.checkout.offers.Offer;
import befaster.solutions.checkout.offers.any_three.Offer_Any_3_For_45;
import befaster.solutions.checkout.offers.combined_item.Offer_2E_1B_Free;
import befaster.solutions.checkout.offers.combined_item.Offer_3N_1M_Free;
import befaster.solutions.checkout.offers.combined_item.Offer_3R_1Q_Free;
import befaster.solutions.checkout.offers.multi_item.*;
import befaster.solutions.checkout.offers.same_item_free.Offer_2F_1F_Free;
import befaster.solutions.checkout.offers.same_item_free.Offer_3U_1U_Free;

import static befaster.solutions.checkout.SKUs.pricesFor;
import static befaster.solutions.checkout.SKUs.valid;
import static com.google.common.base.Strings.isNullOrEmpty;

public class Checkout {

    static Offer[] offers = new Offer[] {
            new Offer_Any_3_For_45(),
            new Offer_2E_1B_Free(),
            new Offer_3N_1M_Free(),
            new Offer_3R_1Q_Free(),
            new Offer_2F_1F_Free(),
            new Offer_3U_1U_Free(),
            new Offer_3V_For_130(),
            new Offer_2V_For_90(),
            new Offer_3Q_For_80(),
            new Offer_5P_For_200(),
            new Offer_2K_For_120(),
            new Offer_10H_For_80(),
            new Offer_5H_For_45(),
            new Offer_2B_For_45(),
            new Offer_5A_For_200(),
            new Offer_3A_For_130(),
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