package Arrays.Sorting;

public class CountSort {
    public static void countSort(int number[]) {

        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < number.length; i++) {
            largest = Math.max(largest, number[i]);
        }

        int count[] = new int[largest + 1];
        for (int i = 0; i < number.length; i++) {
            count[number[i]]++;
        }

        // Sorting
        int j = 0;
        for (int i = count.length - 1; i > 0; i--) {
            while (count[i] > 0) {
                number[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void printArr(int numbers[]) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        System.out.println();
    }

    public static void main(String[] args){
        int arr[] = {1, 4, 1, 3, 2, 4, 3, 7};
        countSort(arr);
        printArr(arr);
    }
}
