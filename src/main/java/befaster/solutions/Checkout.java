package befaster.solutions;

import static com.google.common.base.Strings.isNullOrEmpty;

public class Checkout {

    public static Integer checkout(String skus) {
        if (isNullOrEmpty(skus)) return 0;
        if (!SKUs.valid(skus)) return -1;
        return SKUs.pricesFor(skus) - discounts(skus);
    }
    
    private static Integer discounts(String skus) {
        DiscountResult TwoEsDiscount = TwoEsOffer.discountFor(skus);
        DiscountResult TwoBsDiscount = TwoBsOffer.discountFor(TwoEsDiscount.remainingSkus);
        DiscountResult FiveAsDiscount = FiveAsOffer.discountFor(TwoBsDiscount.remainingSkus);
        DiscountResult ThreeAsDiscount = ThreeAsOffer.discountFor(FiveAsDiscount.remainingSkus);

        return FiveAsDiscount.discount +
                ThreeAsDiscount.discount +
                TwoBsDiscount.discount +
                TwoEsDiscount.discount;
    }

}
