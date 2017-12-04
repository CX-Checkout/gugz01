package befaster.solutions.checkout.offers;

import befaster.solutions.checkout.SKUs;

public class ThreeAsOffer {

    public static DiscountResult discountFor(String skus) {
        long quantityOfAs = SKUs.skuQuantity(skus, "A");
        int numberOfTripleAs = (int) quantityOfAs / 3;
        if (numberOfTripleAs > 0) {
            String orderedSkus = SKUs.sort(skus);
            String remainingSkus = orderedSkus.replaceAll("AAA", "");
            int discount = numberOfTripleAs * 20;
            return new DiscountResult(discount, remainingSkus);
        }
        return new DiscountResult(0, skus);
    }
}