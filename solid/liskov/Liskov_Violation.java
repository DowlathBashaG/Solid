package dowlath.io.solid.liskov;

class Bird_1{
    public void fly(){
        System.out.println("Flying......");
    }
}

class Sparrow_1 extends Bird_1{
    @Override
    public void fly(){
        System.out.println("Sparrow can fly....");
    }
}

class Penguin_1 extends Bird_1{
    @Override
    public void fly(){
        throw new UnsupportedOperationException("Penguin can not fly....");
    }
}
public class Liskov_Violation {
    public static void main(String[] args) {
        Bird_1 penguin = new Penguin_1();
        Bird_1 sparrow = new Sparrow_1();

        sparrow.fly();
        penguin.fly(); // This will break at runtime.
    }
}
