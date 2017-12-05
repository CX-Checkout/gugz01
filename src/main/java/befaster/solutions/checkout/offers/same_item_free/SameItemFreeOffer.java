package befaster.solutions.checkout.offers.same_item_free;

import befaster.solutions.checkout.SKUs;
import befaster.solutions.checkout.offers.DiscountResult;
import befaster.solutions.checkout.offers.Offer;

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
        long quantityOfFs = SKUs.skuQuantity(skus, sku);
        int numberOfTripleFs = (int) quantityOfFs / numberOfItems;
        String remainingSkus = "";
        if (numberOfTripleFs > 0) {
            String orderedSkus = SKUs.sort(skus);
            remainingSkus = orderedSkus.replaceAll("FFF", "");
            int discount = numberOfTripleFs * 10;
            return new DiscountResult(discount, remainingSkus);
        }
        return new DiscountResult(0, skus);    }
}