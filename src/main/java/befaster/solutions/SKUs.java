package befaster.solutions;

import java.util.HashMap;

import static java.util.Arrays.asList;

public class SKUs {

    static final HashMap<String, Integer> SKU_PRICE = createSKUIndividualPrices();;
    static final String SKUS = allSKUs();

    private static HashMap<String, Integer> createSKUIndividualPrices() {
        HashMap<String, Integer> skuPrices = new HashMap<>();
        skuPrices.put("A", 50);
        skuPrices.put("B", 30);
        skuPrices.put("C", 20);
        skuPrices.put("D", 15);
        skuPrices.put("E", 40);
        return skuPrices;
    }

    private static String allSKUs() {
        String skus = "";
        for (String sku : SKU_PRICE.keySet()) {
            skus += sku;
        }
        return skus;
    }

    static boolean valid(String skus) {
        for (String sku : skus.split("")) {
            if (!SKUS.contains(sku)) return false;
        }
        return true;
    }

    static int priceFor(String sku) {
        return SKU_PRICE.getOrDefault(sku, 0);
    }

    static int pricesFor(String skus) {
        Integer totalPrice = 0;
        for (String sku : skus.split("")) {
            totalPrice += SKUs.priceFor(sku);
        }
        return totalPrice;
    }

    static long skuQuantity(String skus, String sku) {
        return asList(skus.split("")).stream().filter(s -> s.equals(sku)).count();
//        HashMap<String, Integer> skusQuantity = new HashMap<>();
//        for (String sku : skus.split("")) {
//            skusQuantity.put(sku, skusQuantity.getOrDefault(sku, 0) + 1);
//        }
//        return skusQuantity.getOrDefault("A", 0);
    }
}