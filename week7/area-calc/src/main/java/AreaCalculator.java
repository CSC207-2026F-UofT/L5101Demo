public class AreaCalculator {
    public static double area(Shape[] shapes) {
        double total = 0.;

        for (Shape s : shapes) {
            total += s.area();
        }

        return total;
    }

    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];

        shapes[0] = new Rectangle(1, 2);
        shapes[1] = new Circle(3);
        shapes[2] = new Rectangle(4, 5);

        double total_area = area(shapes);

        System.out.println("Total area: " + total_area);
    }
}
