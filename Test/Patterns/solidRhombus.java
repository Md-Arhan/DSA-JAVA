package Test.Patterns;

public class solidRhombus {

    public static void solidRhombuss(int n){

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        solidRhombuss(5);
        
    }
}
