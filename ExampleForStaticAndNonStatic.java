import org.w3c.dom.css.Counter;

public class ExampleForStaticAndNonStatic {
    class Counter {
    // Static variable - shared by all objects
    static int count = 0;

    // Non-static variable - unique for each object
    int id;

    // Constructor
    public Counter() {
        count++;    // Increase the shared counter every time a new object is created
        id = count; // Assign unique id to this object
    }

    // Static method to get count of objects created
    static int getCount() {
        return count;
    }

    // Non-static method to show this object's id
    void showId() {
        System.out.println("Object ID: " + id);
    }

    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();

        c1.showId(); // Object ID: 1
        c2.showId(); // Object ID: 2
        c3.showId(); // Object ID: 3

        // Access static method via class name - total objects created
        System.out.println("Total objects created: " + Counter.getCount()); // 3
    }
}

}


/*What’s happening here?
static int count — shared by all instances; it keeps track of how many objects were created.

Each time you create a new Counter(), constructor increments count.

Each object gets its own id based on the current count.

getCount() is static — you call it on the class, not an object.

showId() is non-static — shows id specific to that object.

Why count is static?
Because if it were non-static, each object would have its own separate count starting at 0, so you couldn't track the total number of objects created across all instances. */