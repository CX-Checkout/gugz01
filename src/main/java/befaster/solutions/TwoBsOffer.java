package befaster.solutions;

public class TwoBsOffer {
    static DiscountResult discountFor(String skus) {
        long quantityOfAs = SKUs.skuQuantity(skus, "B");
        int numberOfDoubleBs = (int) quantityOfAs / 2;
        if (numberOfDoubleBs > 0) {
            String orderedSkus = SKUs.sort(skus);
            String remainingSkus = orderedSkus.replaceAll("BB", "");
            int discount = numberOfDoubleBs * 15;
            return new DiscountResult(discount, remainingSkus);
        }
        return new DiscountResult(0, skus);
    }
}
