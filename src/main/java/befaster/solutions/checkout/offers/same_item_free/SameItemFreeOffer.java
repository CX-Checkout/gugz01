package befaster.solutions.checkout.offers.same_item_free;

import befaster.solutions.checkout.SKUs;
import befaster.solutions.checkout.offers.DiscountResult;
import befaster.solutions.checkout.offers.Offer;

import static befaster.solutions.checkout.SKUs.priceFor;
import static befaster.solutions.checkout.SKUs.skuQuantity;
import static org.apache.commons.lang3.StringUtils.repeat;

public class SameItemFreeOffer implements Offer {

    private final String sku;
    private final int numberOfItems;
    private final int discount;

    public SameItemFreeOffer(String sku, int numberOfItems, int discount) {
        this.sku = sku;
        this.numberOfItems = numberOfItems;
        this.discount = discount;
    }

    @Override
    public DiscountResult discountFor(String skus) {
        long quantityOfFs = skuQuantity(skus, sku);
        int numberOfTripleFs = (int) quantityOfFs / numberOfItems;
        String remainingSkus = "";
        if (numberOfTripleFs > 0) {
            String orderedSkus = SKUs.sort(skus);
            remainingSkus = orderedSkus.replaceAll(repeat(sku, numberOfItems), "");
            int totalDiscount = numberOfTripleFs * priceFor(sku);
            return new DiscountResult(totalDiscount, remainingSkus);
        }
        return new DiscountResult(0, skus);    }
}
