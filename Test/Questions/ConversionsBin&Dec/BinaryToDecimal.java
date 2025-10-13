package Test.Questions.ConversionsBinDec;

public class BinaryToDecimal {
    // Convert from Binary to Decimal

    public static void binDec(int binNum) {
        int pow = 0;
        int decNum = 0;

        for (; binNum > 0; pow++) {
            int lastDigit = binNum % 10;
            decNum = decNum + (lastDigit * (int) Math.pow(2, pow));

            binNum = binNum / 10;
        }
        System.out.println(decNum);
    }

    public static void binToDec(int binNum) {
        int pow = 0;
        int decNum = 0;

        while (binNum > 0) {
            int lastDigit = binNum % 10;
            decNum = decNum + (lastDigit * (int) Math.pow(2, pow));

            pow++;
            binNum = binNum / 10;
        }
        System.out.println(decNum);
    }

    public static void main(String[] args) {
        binToDec(101011);
        binToDec(101011);
    }
}
