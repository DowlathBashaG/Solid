package dowlath.io.solid.dependency_inversion;

class WiredKeyboard_1{
    public void connect(){
        System.out.println("Wired keyboard connected");
    }
}

//Violates DIP : Computer is tightly coupled to WiredKeyboard.

class Computer_1{
    private WiredKeyboard_1 keyboard = new WiredKeyboard_1(); // Tightly coupling.

    public void start(){
        keyboard.connect();
    }
}

public class Dependency_Inversion_Violation {
    public static void main(String[] args) {
     Computer_1 pc = new Computer_1();
     pc.start();
    }

}
