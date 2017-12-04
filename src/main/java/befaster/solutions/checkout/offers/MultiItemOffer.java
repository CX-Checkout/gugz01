package befaster.solutions.checkout.offers;

import befaster.solutions.checkout.SKUs;

public class MultiItemOffer {

    private final String sku;
    private final int numberOfItems;
    private final int discount;

    public MultiItemOffer(String sku, int numberOfItems, int discount) {
        this.sku = sku;
        this.numberOfItems = numberOfItems;
        this.discount = discount;
    }

    public DiscountResult discountFor(String skus) {
        long quantityOfAs = SKUs.skuQuantity(skus, sku);
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