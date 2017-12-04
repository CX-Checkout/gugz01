package befaster.solutions.checkout;

import java.util.HashMap;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Comparator.naturalOrder;

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
        skuPrices.put("F", 10);
        skuPrices.put("G", 20);
        skuPrices.put("H", 10);
        skuPrices.put("I", 35);
        skuPrices.put("J", 60);
        skuPrices.put("K", 80);
        skuPrices.put("L", 90);
        skuPrices.put("M", 15);
        skuPrices.put("N", 40);
        skuPrices.put("O", 10);
        skuPrices.put("P", 50);
        skuPrices.put("Q", 30);
        skuPrices.put("R", 50);
        skuPrices.put("S", 30);
        skuPrices.put("T", 20);
        skuPrices.put("U", 40);
        skuPrices.put("V", 50);
        skuPrices.put("W", 20);
        skuPrices.put("X", 90);
        skuPrices.put("Y", 10);
        skuPrices.put("Z", 50);
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

    public static long skuQuantity(String skus, String sku) {
        return asList(skus.split("")).stream().filter(s -> s.equals(sku)).count();
    }

    public static String sort(String input) {
        return asList(input.split(""))
                .stream()
                .sorted(naturalOrder())
                .collect(Collectors.joining());
    }
}