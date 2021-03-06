package befaster.solutions.checkout;

import java.util.HashMap;
import java.util.function.BinaryOperator;

import static java.util.Arrays.stream;

public class SKUs {

    private static final HashMap<String, Integer> SKU_PRICE = createSKUIndividualPrices();;
    private static final String SKUS = allSKUs();

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
        skuPrices.put("K", 70);
        skuPrices.put("L", 90);
        skuPrices.put("M", 15);
        skuPrices.put("N", 40);
        skuPrices.put("O", 10);
        skuPrices.put("P", 50);
        skuPrices.put("Q", 30);
        skuPrices.put("R", 50);
        skuPrices.put("S", 20);
        skuPrices.put("T", 20);
        skuPrices.put("U", 40);
        skuPrices.put("V", 50);
        skuPrices.put("W", 20);
        skuPrices.put("X", 17);
        skuPrices.put("Y", 20);
        skuPrices.put("Z", 21);
        return skuPrices;
    }

    private static String allSKUs() {
        return SKU_PRICE.keySet()
                        .stream()
                        .reduce("", sumAll());
    }

    static boolean valid(String skus) {
        return stream(skus.split("")).allMatch(SKUS::contains);
    }

    public static int priceFor(String sku) {
        return SKU_PRICE.getOrDefault(sku, 0);
    }

    static int pricesFor(String skus) {
        return stream(skus.split(""))
                    .map(SKUs::priceFor)
                    .reduce(0, (a, b) -> a + b);
    }

    public static int skuQuantity(String skus, String sku) {
        return (int) stream(skus.split(""))
                        .filter(s -> s.equals(sku))
                        .count();
    }

    public static String sort(String input) {
        return stream(input.split(""))
                    .sorted()
                    .reduce("", sumAll());
    }

    private static BinaryOperator<String> sumAll() {
        return (a, b) -> a + b;
    }
}
