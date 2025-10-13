package Arrays;

public class PairsInArray {
    
    public static void pairs(int numbers[]) {
        int totalPairs = 0;
        for (int i = 0; i < numbers.length; i++) {
            // int curr = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                System.out.print("(" + numbers[i] + "," + numbers[j] + ")");
                totalPairs++;
            }
            System.out.println();
        }
        System.out.println("totalPairs = " + totalPairs);
    }

    public static void main(String[] args) {
        int number[] = { 2, 4, 6, 8, 10 };

        pairs(number);
    }
}
