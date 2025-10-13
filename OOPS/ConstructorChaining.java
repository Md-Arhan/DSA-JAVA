
class ConstructorChaining {
    int x, y;

    // Constructor 1
    ConstructorChaining() {
            this(10); // Calls Constructor 2
            System.out.println("No-arg constructor called");
        }

    // Constructor 2
    ConstructorChaining(int a) {
            this(a, 20); // Calls Constructor 3
            System.out.println("Single parameter constructor called: " + a);
        }

    // Constructor 3
    ConstructorChaining(int a, int b) {
            this.x = a;
            this.y = b;
            System.out.println("Two parameter constructor called: " + a + ", " + b);
        }

    public static void main(String[] args) {
        // ConstructorChaining obj = new ConstructorChaining();
        
    }
}
