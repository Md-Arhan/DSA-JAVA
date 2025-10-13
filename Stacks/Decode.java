package Stacks;

public class Decode {

    public static String decodeString(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch != ']') {
                s.push(ch);
            } else {
                // Build the string inside the brackets
                StringBuilder sb = new StringBuilder();
                while (!s.isEmpty() && s.peek() != '[') {
                    sb.insert(0, s.pop()); // Insert at the beginning to maintain correct order
                }

                String toRepeat = sb.toString();
                s.pop(); // Pop the '['

                // making StringBuilder empty
                sb = new StringBuilder();
                while (!s.isEmpty() && Character.isDigit(s.peek())) {
                    sb.insert(0, s.pop()); // Insert at the beginning to maintain correct order
                }

                int count = Integer.parseInt(sb.toString());

                while (count-- > 0) {
                    for (int j = 0; j < toRepeat.length(); j++) {
                        char c = toRepeat.charAt(j);
                        s.push(c);
                    }
                }
            }
        }

        // Collect the result from the stack
        StringBuilder result = new StringBuilder();
        while (!s.isEmpty()) {
            result.append(s.pop()); // Insert at the beginning to maintain correct order
        }

        result.reverse();
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "3[a2[s]]";
        System.out.println(decodeString(str)); // Expected output: "accdeccdefaccdeccdefaccdeccdef"
    }

}
