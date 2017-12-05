package befaster.solutions.checkout.offers.multi_item;

import befaster.solutions.checkout.offers.DiscountResult;
import befaster.solutions.checkout.offers.Offer;

import static befaster.solutions.checkout.SKUs.skuQuantity;
import static befaster.solutions.checkout.SKUs.sort;
import static org.apache.commons.lang3.StringUtils.repeat;

public class MultiItemOffer implements Offer {

    private final String sku;
    private final int numberOfItems;
    private final int discount;

    public MultiItemOffer(String sku, int numberOfItems, int discount) {
        this.sku = sku;
        this.numberOfItems = numberOfItems;
        this.discount = discount;
    }

    @Override
    public DiscountResult discountFor(String skus) {
        int numberOfMultipleItems = skuQuantity(skus, sku) / numberOfItems;
        if (numberOfMultipleItems > 0) {
            String remainingSkus = removeSKUsPartOfTheOffer(skus);
            int totalDiscount = numberOfMultipleItems * discount;
            return new DiscountResult(totalDiscount, remainingSkus);
        }
        return new DiscountResult(0, skus);
    }

    private String removeSKUsPartOfTheOffer(String skus) {
        return sort(skus).replaceAll(repeat(sku, numberOfItems), "");
    }
}
