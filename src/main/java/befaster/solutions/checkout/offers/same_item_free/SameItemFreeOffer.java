package befaster.solutions.checkout.offers.same_item_free;

import befaster.solutions.checkout.offers.DiscountResult;
import befaster.solutions.checkout.offers.Offer;

import static befaster.solutions.checkout.SKUs.*;
import static org.apache.commons.lang3.StringUtils.repeat;

public class SameItemFreeOffer implements Offer {

    private final String sku;
    private final int numberOfItems;

    SameItemFreeOffer(String sku, int numberOfItems) {
        this.sku = sku;
        this.numberOfItems = numberOfItems;
    }

    @Override
    public DiscountResult discountFor(String skus) {
        int numberOfOffers = skuQuantity(skus, sku) / numberOfItems;
        return numberOfOffers > 0
                    ? calculateDiscount(skus, numberOfOffers)
                    : noDiscount(skus);
    }

    private DiscountResult calculateDiscount(String skus, int numberOfOffers) {
        String remainingSkus = removeSKUsPartOfTheOffer(skus);
        int totalDiscount = numberOfOffers * priceFor(sku);
        return new DiscountResult(totalDiscount, remainingSkus);
    }

    private DiscountResult noDiscount(String skus) {
        return new DiscountResult(0, skus);
    }

    private String removeSKUsPartOfTheOffer(String skus) {
        return sort(skus).replaceAll(repeat(sku, numberOfItems), "");
    }
}
