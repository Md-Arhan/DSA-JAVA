package Arrays;

public class ReversingArray {
    // Method to reverse an array
    public static int[] reverseNumber(int number[]) {
        int newArr[] = new int[number.length]; // New array with the same size as
        // input

        // Reverse the array
        for (int i = 0; i < number.length; i++) {
            newArr[i] = number[number.length - 1 - i];
        }
        return newArr; // Return the reversed array
    }

    public static void reverseNumbers(int numbers[]) {
        int first = 0, last = numbers.length - 1;

        while (first < last) {
            int temp = numbers[last];
            numbers[last] = numbers[first];
            numbers[first] = temp;

            first++;
            last--;
        }
    }

    public static void main(String[] args) {
        int number[] = { 10, 20, 30, 40, 50 }; // Input array

        // Call the reverseNumber method
        int reversedArray[] = reverseNumber(number);
        reverseNumbers(number);
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i] + " ");
        }
        System.out.println();

        // Print the reversed array
        System.out.print("Reversed Array: ");
        for (int i = 0; i < reversedArray.length; i++) {
            System.out.print(reversedArray[i] + " ");
        }
    }
}
