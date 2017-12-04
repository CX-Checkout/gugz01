package befaster.solutions.checkout.offers;

import befaster.solutions.checkout.SKUs;

import static org.apache.commons.lang3.StringUtils.repeat;

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
        int numberOfTripleAs = (int) quantityOfAs / numberOfItems;
        if (numberOfTripleAs > 0) {
            String orderedSkus = SKUs.sort(skus);
            String remainingSkus = orderedSkus.replaceAll(repeat(sku, numberOfItems), "");
            int totalDiscount = numberOfTripleAs * discount;
            return new DiscountResult(totalDiscount, remainingSkus);
        }
        return new DiscountResult(0, skus);
    }
}
