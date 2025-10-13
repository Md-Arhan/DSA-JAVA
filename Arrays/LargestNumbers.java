package Arrays;

public class LargestNumbers {
    public static int getlargest(int numbers[]) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        // System.out.println(largest);

        for (int i = 0; i < numbers.length; i++) {
            if (largest < numbers[i]) {
                largest = numbers[i];
            }
            if (smallest > numbers[i]) {
                smallest = numbers[i];
            }
        }
        System.out.println(smallest);
        return largest;
    }

    public static void main(String[] args) {
        int numbers[] = { 1, 2, 3, 4, 5, 6 };
        int res = getlargest(numbers);
        System.out.println(res);
    }
}
