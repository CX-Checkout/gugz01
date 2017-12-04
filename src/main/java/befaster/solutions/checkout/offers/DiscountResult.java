package befaster.solutions.checkout.offers;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.MULTI_LINE_STYLE;

public class DiscountResult {
    public final int discount;
    public final String remainingSkus;

    public DiscountResult(int discount, String remainingSkus) {
        this.discount = discount;
        this.remainingSkus = remainingSkus;
    }

    @Override
    public String toString() {
        return reflectionToString(this, MULTI_LINE_STYLE);
    }
}