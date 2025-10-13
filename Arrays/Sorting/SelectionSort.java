package Arrays.Sorting;

public class SelectionSort {
    
    public static void selectionSort(int number[]) {
        for (int i = 0; i < number.length - 1; i++) {
            int minpos = i;
            for (int j = i + 1; j < number.length; j++) {
                if (number[minpos] > number[j]) {
                    minpos = j;
                }
            }
            // swap

            int temp = number[minpos];
            number[minpos] = number[i];
            number[i] = temp;

        }

        for (int i = 0; i < number.length; i++) {
            System.out.println(number[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int numbers[] = { 5, 4, 1, 3, 2 };
        selectionSort(numbers);
    }
}
