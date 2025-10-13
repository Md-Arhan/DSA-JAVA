package Test.Patterns;

public class CharacterPyramid {
    public static void main(String[] args) {
        char alpha = 'A';
        for (int line = 1; line <= 5; line++) {
            for (int star = 1; star <= line; star++) {
                System.out.print(alpha);
                alpha++;
            }
            System.out.println();
        }
    }
}
