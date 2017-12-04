package befaster.solutions;

public class TwoEsOffer {
    static DiscountResult discountFor(String skus) {
        long quantityOfAs = SKUs.skuQuantity(skus, "E");
        int numberOfDoubleEs = (int) quantityOfAs / 2;
        if (numberOfDoubleEs > 0) {
            String orderedSkus = SKUs.sort(skus);
            String remainingSkus = orderedSkus.replaceAll("EE", "");
            for (int i = 0; i < numberOfDoubleEs; i++) {
                remainingSkus = remainingSkus.replaceFirst("B", "");
            }
            int discount = numberOfDoubleEs * 30;
            return new DiscountResult(discount, remainingSkus);
        }
        return new DiscountResult(0, skus);
    }
}
