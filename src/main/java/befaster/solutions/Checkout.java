package befaster.solutions;

import java.util.HashMap;

public class Checkout {

    static HashMap<String, Integer> SKU_PRICE = createSKUIndividualPrices();

    private static HashMap<String, Integer> createSKUIndividualPrices() {
        HashMap<String, Integer> skuPrices = new HashMap<>();
        skuPrices.put("A", 50);
        skuPrices.put("B", 30);
        skuPrices.put("C", 20);
        skuPrices.put("D", 15);
        return skuPrices;
    }

    public static Integer checkout(String skus) {
        HashMap<String, Integer> skusQuantity = skusQuantityFor(skus);
        Integer totalPrice = 0;
        for (String sku : skus.split("")) {
            totalPrice += SKU_PRICE.get(sku);
        }
        totalPrice = applyDiscount(skusQuantity, totalPrice);
        return totalPrice;
    }

    private static Integer applyDiscount(HashMap<String, Integer> skusQuantity, Integer totalPrice) {
        int ADiscount = skusQuantity.getOrDefault("A", 0) / 3 * 20;
        return totalPrice - ADiscount;
    }

    private static HashMap<String, Integer> skusQuantityFor(String skus) {
        HashMap<String, Integer> skusQuantity = new HashMap<>();
        for (String sku : skus.split("")) {
            skusQuantity.put(sku, skusQuantity.getOrDefault(sku, 0) + 1);
        }
        return skusQuantity;
    }
}