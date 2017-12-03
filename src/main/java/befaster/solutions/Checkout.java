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
        return SKU_PRICE.get(skus);
    }
}
