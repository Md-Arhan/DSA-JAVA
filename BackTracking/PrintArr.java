package BackTracking;

public class PrintArr {

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void changeArr(int arr[], int i, int v) {
        // Base Case
        if (i == arr.length) {
            printArr(arr); // [1, 2, 3, 4, 5]
            return;
        }

        // Recursion (Work)
        arr[i] = v;
        changeArr(arr, i + 1, v + 1);
        arr[i] -= 2; // Back Tracking Step
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        changeArr(arr, 0, 1);
        printArr(arr); // [-1, 0, 1, 2, 3]
    }
}
