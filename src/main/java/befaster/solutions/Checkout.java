package befaster.solutions;

public class Checkout {
    public static Integer checkout(String skus) {

        if (skus.equals("A")) {
            return 50;
        }
        if (skus.equals("B")) {
            return 30;
        }
        if (skus.equals("C")) {
            return 20;
        }
        return 15;
    }
}