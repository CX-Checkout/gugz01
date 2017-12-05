package befaster.solutions.checkout.offers.combined_item;

import befaster.solutions.checkout.offers.DiscountResult;
import befaster.solutions.checkout.offers.Offer;

import static befaster.solutions.checkout.SKUs.*;
import static org.apache.commons.lang3.StringUtils.repeat;

public class CombinedItemOffer implements Offer {

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
        long quantityOfAs = skuQuantity(skus, sku);
        int numberOfDoubleEs = (int) quantityOfAs / numberOfItems;
        if (numberOfDoubleEs > 0) {
            String remainingSkus = sort(skus).replaceAll(repeat(sku, numberOfItems), "");
            int totalDiscount = 0;
            for (int i = 0; i < numberOfDoubleEs; i++) {
                if (remainingSkus.contains(freeSku)) {
                    totalDiscount += priceFor(freeSku);
                    remainingSkus = remainingSkus.replaceFirst(freeSku, "");
                }
            }
            return new DiscountResult(totalDiscount, remainingSkus);
        }
        return new DiscountResult(0, skus);
    }
}
