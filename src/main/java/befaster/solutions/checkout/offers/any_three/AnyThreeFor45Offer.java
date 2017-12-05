package befaster.solutions.checkout.offers.any_three;

import befaster.solutions.checkout.offers.DiscountResult;
import befaster.solutions.checkout.offers.Offer;

import java.util.HashMap;
import java.util.Map;

public class AnyThreeFor45Offer implements Offer {

    private String[] SKUS_IN_OFFER = new String[] {"S", "T", "X", "Y", "Z"};

    public AnyThreeFor45Offer() {
    }

    @Override
    public DiscountResult discountFor(String skus) {
        SKUsQuantity skusQuantity = new SKUsQuantity(skus);

        if (skusQuantity.isInOffer()) {
            return new DiscountResult(12, "");
        }
        return new DiscountResult(0, skus);
    }

    private class SKUsQuantity {

        private Map<String, Integer> skuQuantity = new HashMap<>();
        private String skus;

        SKUsQuantity(String skus) {
            this.skus = skus;
            populateQuantity(skus);
        }

        private void populateQuantity(String skus) {
            for (String s : skus.split("")) {
                if ("STXYZ".contains(s)) {
                    skuQuantity.put(s, skuQuantity.getOrDefault(s, 0) + 1);
                }
            }
        }

        boolean isInOffer() {
            Integer total= skuQuantity.values()
                                    .stream()
                                    .reduce(0, (a, b) -> a + b);
            return total >= 3;
        }
    }
}
