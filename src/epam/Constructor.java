package epam;

public class Constructor {
    private int value1;
    private int value2;

    // Default Constructor
    public Constructor() {
        value1 = 0;
        value2 = 0;
    }

    // One-argument Constructor
    public Constructor(int value) {
        this.value1 = value;
        
    }

    // Two-argument Constructor
    public Constructor(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    // Getter methods
    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }

    public static void main(String[] args) {
        Constructor obj1 = new Constructor();
        Constructor obj2 = new Constructor(5);
        Constructor obj3 = new Constructor(10, 20);

        System.out.println("Values in obj1: " + obj1.getValue1() + ", " + obj1.getValue2());
        System.out.println("Values in obj2: " + obj2.getValue1() + ", " + obj2.getValue2());
        System.out.println("Values in obj3: " + obj3.getValue1() + ", " + obj3.getValue2());
    }
}



