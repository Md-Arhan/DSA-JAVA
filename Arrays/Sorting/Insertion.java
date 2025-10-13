package Arrays.Sorting;

public class Insertion {
    public static void insertionSort(int number[]) {
        for (int i = 1; i < number.length; i++) {
            int curr = number[i];
            int prev = i - 1;
            while (prev >= 0 && number[prev] > curr) {
                number[prev + 1] = number[prev];
                prev--; // -1 index
            }
            //insertion
            number[prev + 1] = curr;
        }
    }

    public static void printArr(int numbers[]) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int numbers[] = { 5, 4, 1, 3, 2 };
        insertionSort(numbers);
        printArr(numbers);
    }
}
