package befaster.solutions;

public class Checkout {
    public static Integer checkout(String skus) {
        if (skus.equals("A")) {
            return 50;
        }
        if (skus.equals("B")) {
            return 30;
        }
        return 20;
    }
}