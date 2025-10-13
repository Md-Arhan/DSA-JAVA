package Arrays;

public class TrappedRainWater {
    public static int trappedWater(int height[]) {

        // Left max boundry
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];

        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
            System.out.print(leftMax[i] + " ");
        }
        System.out.println();

        // Right max boundry

        int rightMax[] = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];

        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
            System.out.print(rightMax[i] + " ");
        }
        System.out.println();

        // for(int i=0; i<height.length; i++){
        //     System.out.print(leftMax[i]  +" ");
        //     System.out.print(rightMax[i]+ " ");
        // }

        // loop
        int trappedWater = 0;
        for (int i = 0; i < height.length; i++) {
            // Water level = min(leftMax Boundry, rightMax Boundry)
            int waterLevel = Math.min(rightMax[i], leftMax[i]);

            // trappedWater = (waterLevel - height[i]);
            trappedWater = trappedWater + (waterLevel - height[i]);

        }

        return trappedWater;
    }

    public static void main(String[] args) {

        int height[] = { 7, 0, 4, 2, 5, 0, 6, 4 , 0, 5};

        System.out.println("The Trap water after raining is = " +
                trappedWater(height));

    }
}
