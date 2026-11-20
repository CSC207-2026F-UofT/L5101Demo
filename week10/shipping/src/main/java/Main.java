public class Main {
    public static void main(String[] args) {
        ShippingCalculator calc = new ShippingCalculator();
        Order order = new Order(6.7);
        double cost = calc.cost(order, "standard");
        System.out.printf("Cost is $%.2f\n", cost);
    }
}
