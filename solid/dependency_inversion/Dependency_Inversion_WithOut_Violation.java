package dowlath.io.solid.dependency_inversion;

import java.security.Key;

interface Keyboard{
    void connect();
}
class WiredKeyboard implements  Keyboard{
    public void connect(){
        System.out.println("Wired keyboard connected");
    }
}
class WirelessKeyboard implements Keyboard{

    @Override
    public void connect() {
        System.out.println("Wireless keyboard connected");
    }
}

class Computer{
    private Keyboard keyboard;
    
    public Computer(Keyboard keyboard){
        this.keyboard = keyboard;
    }
    
    public void start(){
        keyboard.connect();
    }
}


public class Dependency_Inversion_WithOut_Violation {
    public static void main(String[] args) {
        Keyboard wired = new WiredKeyboard();
        Computer pc1 = new Computer(wired);
        pc1.start();

        Keyboard wireless = new WirelessKeyboard();
        Computer pc2 = new Computer(wireless);
        pc2.start();
    }
}
