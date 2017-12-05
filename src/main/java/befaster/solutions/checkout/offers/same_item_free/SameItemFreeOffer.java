package befaster.solutions.checkout.offers.same_item_free;

import befaster.solutions.checkout.SKUs;
import befaster.solutions.checkout.offers.DiscountResult;
import befaster.solutions.checkout.offers.Offer;

public class SameItemFreeOffer implements Offer {

    @Override
    public DiscountResult discountFor(String skus) {
        long quantityOfFs = SKUs.skuQuantity(skus, "F");
        int numberOfTripleFs = (int) quantityOfFs / 3;
        String remainingSkus = "";
        if (numberOfTripleFs > 0) {
            String orderedSkus = SKUs.sort(skus);
            remainingSkus = orderedSkus.replaceAll("FFF", "");
            int discount = numberOfTripleFs * 10;
            return new DiscountResult(discount, remainingSkus);
        }
        return new DiscountResult(0, skus);    }
}
