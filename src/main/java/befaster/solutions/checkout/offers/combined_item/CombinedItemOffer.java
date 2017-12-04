package befaster.solutions.checkout.offers.combined_item;

import befaster.solutions.checkout.SKUs;
import befaster.solutions.checkout.offers.DiscountResult;

public class CombinedItemOffer {

    private final String sku;
    private final int numberOfItems;
    private final int discount;
    private final String freeSku;

    public CombinedItemOffer(String sku,
                             int numberOfItems,
                             int discount,
                             String freeSku) {

        this.sku = sku;
        this.numberOfItems = numberOfItems;
        this.discount = discount;
        this.freeSku = freeSku;
    }

    public DiscountResult discountFor(String skus) {
        long quantityOfAs = SKUs.skuQuantity(skus, "E");
        int numberOfDoubleEs = (int) quantityOfAs / 2;
        if (numberOfDoubleEs > 0) {
            String remainingSkus = SKUs.sort(skus).replaceAll("EE", "");
            int discount = 0;
            for (int i = 0; i < numberOfDoubleEs; i++) {
                if (remainingSkus.contains("B")) {
                    discount += 30;
                    remainingSkus = remainingSkus.replaceFirst("B", "");
                }
            }
            return new DiscountResult(discount, remainingSkus);
        }
        return new DiscountResult(0, skus);
    }
}
