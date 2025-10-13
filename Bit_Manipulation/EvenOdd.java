public class EvenOdd {
    public static void main(String[] args) {
        int n = 100;

        if((n & 1) == 0){
            System.out.println(n + " is Even Number");
        }else{
            System.out.println( n + " is odd Number");
        }
    }
}
