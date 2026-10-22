public class AreaCalculator {
    public static double area(Rectangle[] shapes) {
        double total = 0.;

        for (Rectangle r : shapes) {
            total += r.getHeight() * r.getWidth();
        }

        return total;
    }

    public static void main(String[] args) {
        Rectangle[] shapes = new Rectangle[3];

        shapes[0] = new Rectangle(1, 2);
        shapes[1] = new Rectangle(3, 4);
        shapes[2] = new Rectangle(5, 6);

        double total_area = area(shapes);

        System.out.println("Total area: " + total_area);
    }
}
