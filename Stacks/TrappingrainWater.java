package Stacks;

import java.util.Stack;

public class TrappingrainWater {
    public static int trapWater(int[] height) {
        // Initialize a stack to store indices
        Stack<Integer> stack = new Stack<>();
        int totalWater = 0;

        // Traverse through the array
        for (int i = 0; i < height.length; i++) {
            // While the stack is not empty and the current height is greater than the top of the stack
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop(); // The bar at the top of the stack

                // If the stack becomes empty after popping, no left boundary exists
                if (stack.isEmpty()) {
                    break;
                }

                // Calculate the distance between the current bar and the left boundary
                int distance = i - stack.peek() - 1;

                // Calculate the bounded height of the water trapped
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];

                // Add the trapped water for this section
                totalWater += distance * boundedHeight;
            }

            // Push the current index onto the stack
            stack.push(i);
        }

        for(int i=0; i<stack.size(); i++){
            System.out.println(stack.peek());
        }

        return totalWater;
    }

    public static void main(String[] args) {
        int[] height = {7, 0, 4, 2, 5, 0, 6, 4, 0, 5};
        System.out.println("Total water trapped: " + trapWater(height)); // Output: 25
    }
}


//Try to dry run on small array like 3, you will get to know the anwer, when ever you get any question try to dry run on small condition then go for large if u get success


/*
 * i = 0, height[0] = 7
Stack is empty.

Push 0 → stack = [0]

i = 1, height[1] = 0
height[1] < height[stack.peek()] → 0 < 7 → push 1

Stack → [0, 1]

i = 2, height[2] = 4
height[2] > height[1] (top of stack)

Pop 1 → top = 1, now stack = [0]

Left boundary exists (stack not empty)

Distance = 2 - 0 - 1 = 1

Bounded height = min(4, 7) - 0 = 4

Water added = 1 * 4 = 4

totalWater = 4

→ Push 2 → stack = [0, 2]

i = 3, height[3] = 2
height[3] < height[2] → push 3

stack = [0, 2, 3]

i = 4, height[4] = 5
height[4] > height[3] = 2 → pop 3

Distance = 4 - 2 - 1 = 1

Bounded height = min(5, 4) - 2 = 2

Water = 1 * 2 = 2

totalWater = 6

height[4] > height[2] = 4 → pop 2

Distance = 4 - 0 - 1 = 3

Bounded height = min(5, 7) - 4 = 1

Water = 3 * 1 = 3

totalWater = 9

→ Push 4 → stack = [0, 4]

i = 5, height[5] = 0
height[5] < height[4] → push 5

stack = [0, 4, 5]

i = 6, height[6] = 6
height[6] > height[5] = 0 → pop 5

Distance = 6 - 4 - 1 = 1

Bounded height = min(6, 5) - 0 = 5

Water = 1 * 5 = 5

totalWater = 14

height[6] > height[4] = 5 → pop 4

Distance = 6 - 0 - 1 = 5

Bounded height = min(6, 7) - 5 = 1

Water = 5 * 1 = 5

totalWater = 19

→ Push 6 → stack = [0, 6]

i = 7, height[7] = 4
height[7] < height[6] → push 7

stack = [0, 6, 7]

i = 8, height[8] = 0
height[8] < height[7] → push 8

stack = [0, 6, 7, 8]

i = 9, height[9] = 5
height[9] > height[8] = 0 → pop 8

Distance = 9 - 7 - 1 = 1

Bounded height = min(5, 4) - 0 = 4

Water = 1 * 4 = 4

totalWater = 23

height[9] > height[7] = 4 → pop 7

Distance = 9 - 6 - 1 = 2

Bounded height = min(5, 6) - 4 = 1

Water = 2 * 1 = 2

totalWater = 25

→ Push 9 → stack = [0, 6, 9]
 */