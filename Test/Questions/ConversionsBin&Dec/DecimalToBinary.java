package Test.Questions.ConversionsBinDec;

public class DecimalToBinary {
    // Decimal to binary

    public static void decToBin(int decNum) {
        int pow = 0;
        int binNum = 0;

        while (decNum > 0) {
            int rem = decNum % 2;
            binNum = binNum + (rem * (int) Math.pow(10, pow));

            pow++;
            decNum = decNum / 2;
        }
        System.out.println(binNum);
    }

     public static String decimalToBinary(int decimal) {
        if (decimal == 0) return "0";
        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 2;  // Get remainder  //The remainder tells us the current binary bit.
            binary.insert(0, remainder);  // Insert at the beginning // because binary digits are generated in reverse order
            decimal = decimal / 2;        // Divide by 2  // We reduce the number by dividing it by 2 — discarding any remainder
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        decToBin(15);
    }
}


/*
 * Step	decNum	rem = decNum % 2	binNum = binNum + (rem * 10^pow)	pow++	decNum / 2
  1 	15    	15 % 2 = 1	                   0 + (1 × 10⁰) = 1	      1  	15 / 2 = 7
  2 	7	    7 % 2 = 1	                   1 + (1 × 10¹) = 11	      2  	7 / 2 = 3
  3 	3	    3 % 2 = 1	                   11 + (1 × 10²) = 111	      3  	3 / 2 = 1
  4 	1	    1 % 2 = 1	                   111 + (1 × 10³) = 1111	  4  	1 / 2 = 0

 */