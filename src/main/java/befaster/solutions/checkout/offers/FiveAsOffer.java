package befaster.solutions.checkout.offers;

import befaster.solutions.checkout.SKUs;

public class FiveAsOffer {

    public static DiscountResult discountFor(String skus) {
        long quantityOfAs = SKUs.skuQuantity(skus, "A");
        int numberOfFiveAs = (int) quantityOfAs / 5;
        if (numberOfFiveAs > 0) {
            String orderedSkus = SKUs.sort(skus);
            String remainingSkus = orderedSkus.replaceAll("AAAAA", "");
            int discount = numberOfFiveAs * 50;
            return new DiscountResult(discount, remainingSkus);
        }
        return new DiscountResult(0, skus);
    }
}