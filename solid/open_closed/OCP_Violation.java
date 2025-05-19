package dowlath.io.solid.open_closed;

// Violates OCP: Every time a new shape is added, we need to modify the existing class.

class AreaCalculator_1{
    public double calculateArea(String shape, double radius, double length,double breadth){
        if(shape.equals("circle")){
            return Math.PI * radius * radius;
        } else if(shape.equals("rectangle")){
            return length * breadth;
        }
        return 0;
    }
}
public class OCP_Violation {
    public static void main(String[] args) {
        AreaCalculator_1 calculator = new AreaCalculator_1();
        System.out.println("Circle Area: " + calculator.calculateArea("circle", 5, 0, 0));
    }
}
