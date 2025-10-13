package Stacks;


//Decoding using recursion

public class Additional {
    public static String decodeString(String str) {
        return decode(str, new int[]{0}); // Start decoding from index 0
    }

    private static String decode(String str, int[] index) {
        StringBuilder result = new StringBuilder();

        while (index[0] < str.length() && str.charAt(index[0]) != ']') {
            char ch = str.charAt(index[0]);

            if (Character.isDigit(ch)) {
                // Parse the number
                int count = 0;
                while (index[0] < str.length() && Character.isDigit(str.charAt(index[0]))) {
                    count = count * 10 + (str.charAt(index[0]) - '0');
                    index[0]++;
                }

                // Skip the opening bracket '['
                index[0]++; 

                // Decode the substring inside the brackets
                String decodedSubstring = decode(str, index);

                // Repeat the decoded substring `count` times
                while (count-- > 0) {
                    result.append(decodedSubstring);
                }

                // Skip the closing bracket ']'
                index[0]++;
            } else {
                // If the current character is not a digit, just append it
                result.append(ch);
                index[0]++;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String str = "3[a2[c1[d]e]f]";
        System.out.println(decodeString(str)); // Expected output: "accdeccdefaccdeccdefaccdeccdef"
    }
}
