public class ShippingCalculator {
    public double cost(Order order, String method) {
        if (method.equals("standard")) {
            return 5.0 + 0.5 * order.getWeight();
        } else if (method.equals("express")) {
            return 15.0 + 1.0 * order.getWeight();
        } else if (method.equals("pickup")) {
            return 0.0;
        }
        throw new IllegalArgumentException(
                "Unknown method: " + method);
    }
}
