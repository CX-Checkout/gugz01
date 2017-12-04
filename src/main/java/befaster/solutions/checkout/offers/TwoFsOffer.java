package befaster.solutions.checkout.offers;

import befaster.solutions.checkout.SKUs;

public class TwoFsOffer {

    public static DiscountResult discountFor(String skus) {
        long quantityOfFs = SKUs.skuQuantity(skus, "F");
        int numberOfTripleFs = (int) quantityOfFs / 3;
        String remainingSkus = "";
        if (numberOfTripleFs > 0) {
            String orderedSkus = SKUs.sort(skus);
            remainingSkus = orderedSkus.replaceAll("FFF", "");
            int discount = numberOfTripleFs * 10;
            return new DiscountResult(discount, remainingSkus);
        } 
        return new DiscountResult(0, skus);
    }
}