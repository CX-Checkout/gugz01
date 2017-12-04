package befaster.solutions;

import static com.google.common.base.Strings.isNullOrEmpty;

public class Checkout {

    public static Integer checkout(String skus) {
        if (isNullOrEmpty(skus)) return 0;
        if (!SKUs.valid(skus)) return -1;
        return SKUs.pricesFor(skus) - discounts(skus);
    }
    
    private static Integer discounts(String skus) {
        DiscountResult EDiscount = discountForEs(skus);
        DiscountResult BDiscount = discountForBs(EDiscount.remainingSkus);
        DiscountResult ADiscount = discountForA(BDiscount.remainingSkus);

        return ADiscount.discount + BDiscount.discount + EDiscount.discount;
    }

    private static DiscountResult discountForA(String skus) {
        DiscountForAs discountForAs = new DiscountForAs();
        return discountForAs.priceFor(skus);
    }

    private static DiscountResult discountForBs(String skus) {
        DiscountForBs discountForBs = new DiscountForBs();
        return discountForBs.priceFor(skus);
    }

    private static DiscountResult discountForEs(String skus) {
        DiscountForEs discountForEs = new DiscountForEs();
        return discountForEs.priceFor(skus);
    }

    public static class DiscountForAs {
        DiscountResult priceFor(String skus) {
            long quantityOfAs = SKUs.skuQuantity(skus, "A");
            int numberOfTripleAs = (int) quantityOfAs / 3;
            if (numberOfTripleAs > 0) {
                String orderedSkus = SKUs.sort(skus);
                String remainingSkus = orderedSkus.replaceAll("AAA", "");
                int discount = numberOfTripleAs * 20;
                return new DiscountResult(discount, remainingSkus);
            }
            return new DiscountResult(0, skus);
        }

    }

    public static class DiscountForBs {
        DiscountResult priceFor(String skus) {
            long quantityOfAs = SKUs.skuQuantity(skus, "B");
            int numberOfDoubleBs = (int) quantityOfAs / 2;
            if (numberOfDoubleBs > 0) {
                String orderedSkus = SKUs.sort(skus);
                String remainingSkus = orderedSkus.replaceAll("BB", "");
                int discount = numberOfDoubleBs * 15;
                return new DiscountResult(discount, remainingSkus);
            }
            return new DiscountResult(0, skus);
        }
    }

    public static class DiscountForEs {
        DiscountResult priceFor(String skus) {
            long quantityOfAs = SKUs.skuQuantity(skus, "E");
            int numberOfDoubleEs = (int) quantityOfAs / 2;
            if (numberOfDoubleEs > 0) {
                String orderedSkus = SKUs.sort(skus);
                String remainingSkus = orderedSkus.replaceAll("EE", "");
                for (int i = 0; i < numberOfDoubleEs; i++) {
                    remainingSkus = remainingSkus.replace("B", "");
                }
                int discount = numberOfDoubleEs * 30;
                return new DiscountResult(discount, remainingSkus);
            }
            return new DiscountResult(0, skus);
        }
    }

    public static class DiscountResult {
        private final int discount;
        private final String remainingSkus;

        DiscountResult(int discount, String remainingSkus) {
            this.discount = discount;
            this.remainingSkus = remainingSkus;
        }
    }
}
