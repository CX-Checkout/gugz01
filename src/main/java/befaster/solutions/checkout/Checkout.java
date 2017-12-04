package befaster.solutions.checkout;

import befaster.solutions.checkout.offers.*;

import static com.google.common.base.Strings.isNullOrEmpty;

public class Checkout {

    static Offer twoBsOffer = new TwoBsOffer();
    static Offer fiveAsOffer = new FiveAsOffer();
    static Offer threeAsOffer = new ThreeAsOffer();

    public static Integer checkout(String skus) {
        if (isNullOrEmpty(skus)) return 0;
        if (!SKUs.valid(skus)) return -1;
        return SKUs.pricesFor(skus) - discounts(skus);
    }
    
    private static Integer discounts(String skus) {
        DiscountResult TwoEsDiscount = TwoEsOffer.discountFor(skus);
        DiscountResult TwoBsDiscount = twoBsOffer.discountFor(TwoEsDiscount.remainingSkus);
        DiscountResult FiveAsDiscount = fiveAsOffer.discountFor(TwoBsDiscount.remainingSkus);
        DiscountResult ThreeAsDiscount = threeAsOffer.discountFor(FiveAsDiscount.remainingSkus);
        DiscountResult TwoFsAsDiscount = TwoFsOffer.discountFor(ThreeAsDiscount.remainingSkus);

        return FiveAsDiscount.discount +
                ThreeAsDiscount.discount +
                TwoBsDiscount.discount +
                TwoEsDiscount.discount +
                TwoFsAsDiscount.discount;
    }

}
