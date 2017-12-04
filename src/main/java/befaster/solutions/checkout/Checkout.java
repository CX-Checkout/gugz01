package befaster.solutions.checkout;

import befaster.solutions.checkout.offers.*;
import befaster.solutions.checkout.offers.combined_item.ThreeNsFreeMOffer;
import befaster.solutions.checkout.offers.multi_item.*;

import static com.google.common.base.Strings.isNullOrEmpty;

public class Checkout {

    static Offer threeVsOffer = new ThreeVsOffer();
    static Offer twoVsOffer = new TwoVsOffer();
    static Offer threeQsOffer = new ThreeQsOffer();
    static Offer fivePsOffer = new FivePsOffer();
    static Offer twoKsOffer = new TwoKsOffer();
    static Offer tenHsOffer = new TenHsOffer();
    static Offer fiveHsOffer = new FiveHsOffer();
    static Offer twoBsOffer = new TwoBsOffer();
    static Offer fiveAsOffer = new FiveAsOffer();
    static Offer threeAsOffer = new ThreeAsOffer();
    static Offer twoEsOffer = new TwoEsOffer();
    static Offer three_Ns_Free_M_Offer = new ThreeNsFreeMOffer();

    public static Integer checkout(String skus) {
        if (isNullOrEmpty(skus)) return 0;
        if (!SKUs.valid(skus)) return -1;
        return SKUs.pricesFor(skus) - discounts(skus);
    }
    
    private static Integer discounts(String skus) {
        DiscountResult _3N_Free_M_discount = three_Ns_Free_M_Offer.discountFor(skus);
        DiscountResult _3V_discount = threeVsOffer.discountFor(_3N_Free_M_discount.remainingSkus);
        DiscountResult _2V_discount = twoVsOffer.discountFor(_3V_discount.remainingSkus);
        DiscountResult _3Q_discount = threeQsOffer.discountFor(_2V_discount.remainingSkus);
        DiscountResult _5P_discount = fivePsOffer.discountFor(_3Q_discount.remainingSkus);
        DiscountResult _2K_discount = twoKsOffer.discountFor(_5P_discount.remainingSkus);
        DiscountResult _10H_discount = tenHsOffer.discountFor(_2K_discount.remainingSkus);
        DiscountResult _5H_discount = fiveHsOffer.discountFor(_10H_discount.remainingSkus);
        DiscountResult _2E_discount = twoEsOffer.discountFor(_5H_discount.remainingSkus);
        DiscountResult _2B_discount = twoBsOffer.discountFor(_2E_discount.remainingSkus);
        DiscountResult _5A_discount = fiveAsOffer.discountFor(_2B_discount.remainingSkus);
        DiscountResult ThreeAsDiscount = threeAsOffer.discountFor(_5A_discount.remainingSkus);
        DiscountResult TwoFsAsDiscount = TwoFsOffer.discountFor(ThreeAsDiscount.remainingSkus);

        return _5A_discount.discount +
                ThreeAsDiscount.discount +
                _2B_discount.discount +
                _2E_discount.discount +
                TwoFsAsDiscount.discount +
                _5H_discount.discount +
                _10H_discount.discount +
                _2K_discount.discount +
                _5P_discount.discount +
                _3Q_discount.discount +
                _2V_discount.discount +
                _3V_discount.discount +
                _3N_Free_M_discount.discount;
    }

}
