public class Main {
    public static void main(String[] args) {
        ShippingCalculator calc = new ShippingCalculator();
        String methods[] = {"standard", "express", "pickup"};
        Order order = new Order(6.7);

        for (String method : methods)
        {
            double cost = calc.cost(order, method);
            System.out.printf("Cost is $%.2f\n", cost);
        }
    }
}
