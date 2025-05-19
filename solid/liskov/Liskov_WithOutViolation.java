package dowlath.io.solid.liskov;

abstract class Bird{
    abstract void makeSound();
}

interface FlyingBird{
    void fly();
}

class Sparrow extends Bird implements FlyingBird{

    @Override
    void makeSound() {
        System.out.println("Chirp Chirp !!!......");
    }

    @Override
    public void fly() {
        System.out.println("Sparrow is flying .....!!!");
    }
}

class Penguin extends Bird{

    @Override
    void makeSound() {
        System.out.println("Kee...Kee...!!!");
    }
}
public class Liskov_WithOutViolation {
    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        Bird penguin = new Penguin();

        sparrow.makeSound();
        penguin.makeSound();

        FlyingBird flyingBird = new Sparrow();
        flyingBird.fly();
    }
}
