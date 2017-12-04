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
        int ADiscount = discountForA(skus);
        int BDiscount = discountForBs(skus);
        int discount = ADiscount;
        if (EDiscount > BDiscount) {
            discount += EDiscount;
        } else {
            discount += BDiscount;
        }
        return discount;
    }

    private static int discountForA(String skus) {
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
        int priceFor(String skus) {
            long quantityOfAs = SKUs.skuQuantity(skus, "A");
            return (int) quantityOfAs / 3 * 20;
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
}
