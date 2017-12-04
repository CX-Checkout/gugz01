package befaster.solutions;

import java.util.HashMap;

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

}
