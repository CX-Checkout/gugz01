package befaster.solutions.checkout.offers;

import befaster.solutions.checkout.offers.combined_item.CombinedItemOffer;

public class TwoEsOffer extends CombinedItemOffer {

    public TwoEsOffer() {
        super("E", 2, 30, "B");
    }

//    public static DiscountResult discountFor(String skus) {
//        long quantityOfAs = SKUs.skuQuantity(skus, "E");
//        int numberOfDoubleEs = (int) quantityOfAs / 2;
//        if (numberOfDoubleEs > 0) {
//            String remainingSkus = SKUs.sort(skus).replaceAll("EE", "");
//            int discount = 0;
//            for (int i = 0; i < numberOfDoubleEs; i++) {
//                if (remainingSkus.contains("B")) {
//                    discount += 30;
//                    remainingSkus = remainingSkus.replaceFirst("B", "");
//                }
//            }
//            return new DiscountResult(discount, remainingSkus);
//        }
//        return new DiscountResult(0, skus);
//    }
}
