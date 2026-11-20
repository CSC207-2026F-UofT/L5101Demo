public class ShippingCalculator {
    public double cost(Order order, String method) {
        if (method.equals("standard")) {
            return getStandardCost(order);
        } else if (method.equals("express")) {
            return getExpressCost(order);
        } else if (method.equals("pickup")) {
            return getPickupCost(order);
        }
        throw new IllegalArgumentException(
                "Unknown method: " + method);
    }

    private static double getPickupCost(Order order) {
        return 0.0;
    }

    private static double getExpressCost(Order order) {
        return 15.0 + order.getWeight();
    }

    private static double getStandardCost(Order order) {
        return 5.0 + 0.5 * order.getWeight();
    }
}
