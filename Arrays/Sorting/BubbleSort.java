package Arrays.Sorting;

public class BubbleSort {
    public static void bubbleSort(int numbers[]) {

        for (int turn = 0; turn < numbers.length - 1; turn++) {
            boolean isFalse = false;  //modified BubbleSort
            for (int j = 0; j < numbers.length - 1 - turn; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    isFalse = true;
                }

            }
            if(isFalse == false){
                break;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    } 

    public static void printArr(int numbers[]){
    for(int i=0; i<numbers.length; i++){
    System.out.println(numbers[i]);
    }
    System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 5, 4, 1, 3, 2 };
        bubbleSort(arr);
        // printArr(arr);
    }
}
