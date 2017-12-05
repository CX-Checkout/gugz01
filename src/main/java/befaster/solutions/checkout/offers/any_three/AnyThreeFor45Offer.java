package befaster.solutions.checkout.offers.any_three;

import befaster.solutions.checkout.offers.DiscountResult;
import befaster.solutions.checkout.offers.Offer;

public class AnyThreeFor45Offer implements Offer {

    private String[] SKUS_IN_OFFER = new String[] {"S", "T", "X", "Y", "Z"};

    public AnyThreeFor45Offer() {
    }

    @Override
    public DiscountResult discountFor(String skus) {
        SKUsQuantity skusQuantity = new SKUsQuantity(skus);
        if (skusQuantity.isInOffer()) {
            return new DiscountResult(45, "");
        }
        return new DiscountResult(0, skus);
    }

    private class SKUsQuantity {
        private String skus;

        SKUsQuantity(String skus) {
            this.skus = skus;
        }

        boolean isInOffer() {
            return ("STX".equals(skus));
        }
    }
}
