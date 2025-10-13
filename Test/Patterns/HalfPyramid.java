package Test.Patterns;

public class HalfPyramid {
    public static void main(String[] args) {
        for (int line = 1; line <= 4; line++) {
            for (int star = 1; star <= line; star++) {
                System.out.print(star);
            }
            System.out.println();
        }
    }
}
