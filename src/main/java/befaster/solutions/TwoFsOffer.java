package befaster.solutions;

class TwoFsOffer {
    static DiscountResult discountFor(String skus) {
        long quantityOfFs = SKUs.skuQuantity(skus, "F");
        int numberOfTripleFs = (int) quantityOfFs / 3;
        if (numberOfTripleFs > 0) {
            String orderedSkus = SKUs.sort(skus);
            String remainingSkus = orderedSkus.replaceAll("FFF", "");
            int discount = numberOfTripleFs * 10;
            return new DiscountResult(discount, remainingSkus);
        }
        return new DiscountResult(0, skus);
    }
}
