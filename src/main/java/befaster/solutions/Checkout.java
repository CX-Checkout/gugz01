package befaster.solutions;

import static com.google.common.base.Strings.isNullOrEmpty;

public class Checkout {

    public static Integer checkout(String skus) {
        if (isNullOrEmpty(skus)) return 0;
        if (!SKUs.valid(skus)) return -1;
        return SKUs.pricesFor(skus) - discounts(skus);
    }
    
    private static Integer discounts(String skus) {
        int EDiscount = discountForEs(skus);
        DiscountResult ADiscount = discountForA(skus);
        int BDiscount = discountForBs(skus);
        
        int discount = ADiscount.discount;
        if (EDiscount > BDiscount) {
            discount += EDiscount;
        } else {
            discount += BDiscount;
        }
        return discount;
    }

    private static DiscountResult discountForA(String skus) {
        DiscountForAs discountForAs = new DiscountForAs();
        return discountForAs.priceFor(skus);
    }

    private static int discountForBs(String skus) {
        DiscountForBs discountForBs = new DiscountForBs();
        return discountForBs.priceFor(skus);
    }

    private static int discountForEs(String skus) {
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
        int priceFor(String skus) {
            long quantityOfAs = SKUs.skuQuantity(skus, "B");
            return (int) quantityOfAs / 2 * 15;
        }
    }

    public static class DiscountForEs {
        int priceFor(String skus) {
            long quantityOfAs = SKUs.skuQuantity(skus, "E");
            return (int) quantityOfAs / 2 * 30;
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
