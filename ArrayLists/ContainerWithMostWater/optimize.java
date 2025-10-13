package ContainerWithMostWater;

public class optimize {
    // Optimize Approach //2 Pointer Approach
    // TC = O(n)

    static int max = Integer.MIN_VALUE;

    public static int mostWater(ArrayList<Integer> height) {
        int lp = 0;
        int rp = height.size() - 1;

        while (lp < rp) {
            int minHeight = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int currWater = minHeight * width;
            max = Math.max(max, currWater);

            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();

        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(mostWater(height));

    }
}