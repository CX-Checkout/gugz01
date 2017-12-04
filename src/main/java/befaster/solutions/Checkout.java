package befaster.solutions;

import java.util.HashMap;

import static com.google.common.base.Strings.isNullOrEmpty;

public class Checkout {

    public static Integer checkout(String skus) {
        if (isNullOrEmpty(skus)) return 0;
        if (!SKUs.valid(skus)) return -1;
        HashMap<String, Integer> skusQuantity = skusQuantityFor(skus);
        return SKUs.pricesFor(skus) - discounts(skusQuantity);
    }
    
    private static Integer discounts(HashMap<String, Integer> skusQuantity) {
        int EDiscount = skusQuantity.getOrDefault("E", 0) / 2 * 30;
        int ADiscount = skusQuantity.getOrDefault("A", 0) / 3 * 20;
        int BDiscount = skusQuantity.getOrDefault("B", 0) / 2 * 15;
        int discount = ADiscount;
        if (EDiscount > BDiscount) {
            discount += EDiscount;
        } else {
            discount += BDiscount;
        }
        return discount;
    }

    private static HashMap<String, Integer> skusQuantityFor(String skus) {
        HashMap<String, Integer> skusQuantity = new HashMap<>();
        for (String sku : skus.split("")) {
            skusQuantity.put(sku, skusQuantity.getOrDefault(sku, 0) + 1);
        }
        return skusQuantity;
    }

    public class DiscountForAs {

        int priceFor(String skus) {
            long quantityOfAs = SKUs.skuQuantity(skus, "A");
            return (int) quantityOfAs / 3 * 20;
        }
    }
}
