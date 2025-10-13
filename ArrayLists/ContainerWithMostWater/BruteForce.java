package ContainerWithMostWater;

//TC = O(n^2)
public class BruteForce {
    static int max = Integer.MIN_VALUE;

    public static int mostWater(ArrayList<Integer> height) {
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int minHeight = Math.min(height.get(i), height.get(j));
                int width = j - i;
                int currWater = minHeight * width;
                max = Math.max(max, currWater);
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
