package befaster.solutions.checkout;

import befaster.solutions.checkout.offers.*;
import befaster.solutions.checkout.offers.multi_item.*;

import static com.google.common.base.Strings.isNullOrEmpty;

public class Checkout {

    static Offer threeQsOffer = new ThreeQsOffer();
    static Offer fivePsOffer = new FivePsOffer();
    static Offer twoKsOffer = new TwoKsOffer();
    static Offer tenHsOffer = new TenHsOffer();
    static Offer fiveHsOffer = new FiveHsOffer();
    static Offer twoBsOffer = new TwoBsOffer();
    static Offer fiveAsOffer = new FiveAsOffer();
    static Offer threeAsOffer = new ThreeAsOffer();

    public static Integer checkout(String skus) {
        if (isNullOrEmpty(skus)) return 0;
        if (!SKUs.valid(skus)) return -1;
        return SKUs.pricesFor(skus) - discounts(skus);
    }
    
    private static Integer discounts(String skus) {
        DiscountResult ThreeQsDiscount = threeQsOffer.discountFor(skus);
        DiscountResult FivePsDiscount = fivePsOffer.discountFor(ThreeQsDiscount.remainingSkus);
        DiscountResult TwoKsDiscount = twoKsOffer.discountFor(FivePsDiscount.remainingSkus);
        DiscountResult TenHsDiscount = tenHsOffer.discountFor(TwoKsDiscount.remainingSkus);
        DiscountResult FiveHsDiscount = fiveHsOffer.discountFor(TenHsDiscount.remainingSkus);
        DiscountResult TwoEsDiscount = TwoEsOffer.discountFor(FiveHsDiscount.remainingSkus);
        DiscountResult TwoBsDiscount = twoBsOffer.discountFor(TwoEsDiscount.remainingSkus);
        DiscountResult FiveAsDiscount = fiveAsOffer.discountFor(TwoBsDiscount.remainingSkus);
        DiscountResult ThreeAsDiscount = threeAsOffer.discountFor(FiveAsDiscount.remainingSkus);
        DiscountResult TwoFsAsDiscount = TwoFsOffer.discountFor(ThreeAsDiscount.remainingSkus);

        return FiveAsDiscount.discount +
                ThreeAsDiscount.discount +
                TwoBsDiscount.discount +
                TwoEsDiscount.discount +
                TwoFsAsDiscount.discount +
                FiveHsDiscount.discount +
                TenHsDiscount.discount +
                TwoKsDiscount.discount +
                FivePsDiscount.discount +
                ThreeQsDiscount.discount;
    }

}
