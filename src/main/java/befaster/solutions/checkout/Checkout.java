package befaster.solutions.checkout;

import befaster.solutions.checkout.offers.DiscountResult;
import befaster.solutions.checkout.offers.Offer;
import befaster.solutions.checkout.offers.combined_item._2E_1B_Free_Offer;
import befaster.solutions.checkout.offers.combined_item._3N_1M_Free_Offer;
import befaster.solutions.checkout.offers.combined_item._3R_1Q_Free_Offer;
import befaster.solutions.checkout.offers.multi_item.*;
import befaster.solutions.checkout.offers.same_item_free._2F_1F_Free_Offer;
import befaster.solutions.checkout.offers.same_item_free._3U_1U_Free_Offer;

import static com.google.common.base.Strings.isNullOrEmpty;

public class Checkout {

    static Offer _3V_offer  = new ThreeVsOffer();
    static Offer _2V_offer  = new TwoVsOffer();
    static Offer _3Q_offer  = new ThreeQsOffer();
    static Offer _5P_offer  = new FivePsOffer();
    static Offer _2K_offer  = new TwoKsOffer();
    static Offer _10H_offer = new TenHsOffer();
    static Offer _5H_offer  = new FiveHsOffer();
    static Offer _2B_offer  = new TwoBsOffer();
    static Offer _5A_offer  = new FiveAsOffer();
    static Offer _3A_offer  = new ThreeAsOffer();
    static Offer _2E_1B_Free_Offer = new _2E_1B_Free_Offer();
    static Offer _3N_1M_Free_Offer = new _3N_1M_Free_Offer();
    static Offer _3R_1Q_Free_Offer = new _3R_1Q_Free_Offer();
    static Offer _2F_1F_Free_Offer = new _2F_1F_Free_Offer();
    static Offer _3U_1U_Free_Offer = new _3U_1U_Free_Offer();

    public static Integer checkout(String skus) {
        if (isNullOrEmpty(skus)) return 0;
        if (!SKUs.valid(skus)) return -1;
        return SKUs.pricesFor(skus) - discounts(skus);
    }
    
    private static Integer discounts(String skus) {
        DiscountResult _3U_1U_Free_discount = _3U_1U_Free_Offer.discountFor(skus);
        DiscountResult _2F_1F_Free_discount  = _2F_1F_Free_Offer.discountFor(_3U_1U_Free_discount.remainingSkus);
        DiscountResult _3R_1Q_Free_discount = _3R_1Q_Free_Offer.discountFor(_2F_1F_Free_discount.remainingSkus);
        DiscountResult _3N_1M_Free_discount = _3N_1M_Free_Offer.discountFor(_3R_1Q_Free_discount.remainingSkus);
        DiscountResult _3V_discount  = _3V_offer.discountFor(_3N_1M_Free_discount.remainingSkus);
        DiscountResult _2V_discount  = _2V_offer.discountFor(_3V_discount.remainingSkus);
        DiscountResult _3Q_discount  = _3Q_offer.discountFor(_2V_discount.remainingSkus);
        DiscountResult _5P_discount  = _5P_offer.discountFor(_3Q_discount.remainingSkus);
        DiscountResult _2K_discount  = _2K_offer.discountFor(_5P_discount.remainingSkus);
        DiscountResult _10H_discount = _10H_offer.discountFor(_2K_discount.remainingSkus);
        DiscountResult _5H_discount  = _5H_offer.discountFor(_10H_discount.remainingSkus);
        DiscountResult _2E_discount  = _2E_1B_Free_Offer.discountFor(_5H_discount.remainingSkus);
        DiscountResult _2B_discount  = _2B_offer.discountFor(_2E_discount.remainingSkus);
        DiscountResult _5A_discount  = _5A_offer.discountFor(_2B_discount.remainingSkus);
        DiscountResult _3A_discount  = _3A_offer.discountFor(_5A_discount.remainingSkus);

        return _5A_discount.discount +
                _3A_discount.discount +
                _2B_discount.discount +
                _2E_discount.discount +
                _2F_1F_Free_discount.discount +
                _5H_discount.discount +
                _10H_discount.discount +
                _2K_discount.discount +
                _5P_discount.discount +
                _3Q_discount.discount +
                _2V_discount.discount +
                _3V_discount.discount +
                _3N_1M_Free_discount.discount +
                _3R_1Q_Free_discount.discount +
                _3U_1U_Free_discount.discount;
    }

}
