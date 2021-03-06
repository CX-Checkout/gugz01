package befaster.solutions.checkout.offers.any_three;

import befaster.solutions.checkout.offers.DiscountResult;
import befaster.solutions.checkout.offers.Offer;

import java.util.ArrayList;
import java.util.List;

import static befaster.solutions.checkout.SKUs.priceFor;
import static java.lang.Math.abs;

public class Offer_Any_3_For_45 implements Offer {

    private static final int OFFER_PRICE = 45;

    @Override
    public DiscountResult discountFor(String skus) {
        SKUsQuantity skusQuantity = new SKUsQuantity(skus);
        return skusQuantity.discount();
    }

    private class SKUPrice {
        final String sku;
        final int price;

        public SKUPrice(String SKU, int price) {
            sku = SKU;
            this.price = price;
        }
    }

    private class SKUsQuantity {

        private static final String SKUS_IN_OFFER = "STXYZ";

        private List<SKUPrice> skuPrices = new ArrayList<>();
        private String skus;

        SKUsQuantity(String skus) {
            this.skus = skus;
            populateQuantity(skus);
        }

        private void populateQuantity(String skus) {
            for (String sku : skus.split("")) {
                if (SKUS_IN_OFFER.contains(sku)) {
                    skuPrices.add(new SKUPrice(sku, priceFor(sku)));
                    skuPrices.sort((a, b) -> (a.price > b.price) ? -1 : 1);
                }
            }
        }

        boolean isInOffer() {
            return skuPrices.size() >= 3;
        }

        public DiscountResult discount() {
            int numberOfOffers = 0;
            int totalPrice = 0;
            String remainingSKUs = skus;
            while (isInOffer()) {
                numberOfOffers++;
                int count = 3;
                while(count > 0) {
                    SKUPrice skuPrice = skuPrices.remove(0);
                    totalPrice += skuPrice.price;
                    remainingSKUs = remainingSKUs.replaceFirst(skuPrice.sku, "");
                    count--;
                }
            }

            int discount = 0;
            int maxToBePaid = OFFER_PRICE * numberOfOffers;
            if (totalPrice > maxToBePaid) {
                discount = abs(maxToBePaid - totalPrice);
            }
            return new DiscountResult(discount, remainingSKUs);
        }
    }
}
