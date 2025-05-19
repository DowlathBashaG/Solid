package dowlath.io.solid.interface_segregation;

interface Worker_1{
     void work();
     void eat();
}

class Human_1 implements Worker_1{

    @Override
    public void work() {
        System.out.println("Human working....");
    }

    @Override
    public void eat() {
        System.out.println("Human eating....");
    }
}

class Robot_1 implements Worker_1{

    @Override
    public void work() {
        System.out.println("Robot working.....");
    }

    @Override
    public void eat() {
        // This is not right way of handling.
        throw new UnsupportedOperationException("Robots do not eat.....!!! This operation not supported....!!!");
    }
}
public class InterfaceSegregation_Violation {
    public static void main(String[] args) {
        Human_1  human_1 = new Human_1();
        human_1.work();
        human_1.eat();

        Robot_1 robot_1 = new Robot_1();
        robot_1.work();
        robot_1.eat();;
    }
}
