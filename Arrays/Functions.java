package Arrays;

// Call by refernce or Call by value
public class Functions {
    public static void Update(int marks[], int n) {
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 1;
            // System.out.print(marks[i]);
        }
        n = 10;
        System.out.println(n);
    }

    public static void main(String[] args) {
        int marks[] = { 91, 95, 97 };
        int n = 5;
        Update(marks, n);
        System.out.println(n);

        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " "); // 92, 95, 98 => call by reference
        }
    }
}
