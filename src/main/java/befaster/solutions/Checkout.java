package befaster.solutions;

import java.util.HashMap;

public class Checkout {

    static HashMap<String, Integer> SKU_PRICE;

    public static Integer checkout(String skus) {
        SKU_PRICE = createSKUIndividualPrices();
        HashMap<String, Integer> skusQuantity = skusQuantityFor(skus);
        return priceWithoutDiscounts(skus) - discounts(skusQuantity);
    }

    private static HashMap<String, Integer> createSKUIndividualPrices() {
        HashMap<String, Integer> skuPrices = new HashMap<>();
        skuPrices.put("A", 50);
        skuPrices.put("B", 30);
        skuPrices.put("C", 20);
        skuPrices.put("D", 15);
        return skuPrices;
    }

    private static Integer priceWithoutDiscounts(String skus) {
        Integer totalPrice = 0;
        System.out.println("SKU_PRICE = " + SKU_PRICE);
        for (String sku : skus.split("")) {
            System.out.println("sku = " + sku);
            totalPrice += SKU_PRICE.get(sku);
        }
        return totalPrice;
    }

    private static Integer discounts(HashMap<String, Integer> skusQuantity) {
        int ADiscount = skusQuantity.getOrDefault("A", 0) / 3 * 20;
        int BDiscount = skusQuantity.getOrDefault("B", 0) / 2 * 15;
        return ADiscount + BDiscount;
    }

    private static HashMap<String, Integer> skusQuantityFor(String skus) {
        HashMap<String, Integer> skusQuantity = new HashMap<>();
        for (String sku : skus.split("")) {
            skusQuantity.put(sku, skusQuantity.getOrDefault(sku, 0) + 1);
        }
        return skusQuantity;
    }
}
