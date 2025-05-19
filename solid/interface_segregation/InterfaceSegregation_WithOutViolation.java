package dowlath.io.solid.interface_segregation;

interface Worker{
    void work();
}

interface Eatable{
    void eat();
}

class Human implements Worker,Eatable{

    @Override
    public void work() {
        System.out.println("Developer is coding.....");
    }

    @Override
    public void eat() {
        System.out.println("Developer is eating....");
    }
}

class Robot implements Worker{

    @Override
    public void work() {
        System.out.println("Robot is working.....");
    }
}
public class InterfaceSegregation_WithOutViolation {
    public static void main(String[] args) {
        Human human = new Human();
        human.work();
        human.eat();

        Robot robot = new Robot();
        robot.work();

    }
}
