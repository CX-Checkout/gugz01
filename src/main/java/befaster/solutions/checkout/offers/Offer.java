package befaster.solutions.checkout.offers;

public interface Offer {
    DiscountResult discountFor(String skus);
}
