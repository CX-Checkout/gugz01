package befaster.solutions.checkout.offers.combined_item;

import befaster.solutions.checkout.offers.DiscountResult;
import befaster.solutions.checkout.offers.Offer;

import static befaster.solutions.checkout.SKUs.*;
import static org.apache.commons.lang3.StringUtils.repeat;

public class CombinedItemOffer implements Offer {

    private final String sku;
    private final int numberOfItems;
    private final String freeSku;

    CombinedItemOffer(String sku,
                      int numberOfItems,
                      String freeSku) {
        this.sku = sku;
        this.numberOfItems = numberOfItems;
        this.freeSku = freeSku;
    }

    public DiscountResult discountFor(String skus) {
        int numberOfOffers = skuQuantity(skus, sku) / numberOfItems;
        return numberOfOffers > 0
                    ? calculateDiscount(skus, numberOfOffers)
                    : noDiscount(skus);
    }

    private DiscountResult calculateDiscount(String skus, int numberOfOffers) {
        String remainingSkus = removeSKUsPartOfTheOffer(skus);
        int totalDiscount = 0;
        for (int i = 0; i < numberOfOffers; i++) {
            if (remainingSkus.contains(freeSku)) {
                totalDiscount += priceFor(freeSku);
                remainingSkus = remainingSkus.replaceFirst(freeSku, "");
            }
        }
        return new DiscountResult(totalDiscount, remainingSkus);
    }

    private DiscountResult noDiscount(String skus) {
        return new DiscountResult(0, skus);
    }

    private String removeSKUsPartOfTheOffer(String skus) {
        return sort(skus).replaceAll(repeat(sku, this.numberOfItems), "");
    }
}
