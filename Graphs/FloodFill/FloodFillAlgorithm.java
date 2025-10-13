package FloodFill;
public class FloodFillAlgorithm {

    // O(m*n)
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis = new boolean[image.length][image[0].length];
        if (image[sr][sc] != color) { // Avoid unnecessary calls if it's already the target color
            helper(image, sr, sc, color, vis, image[sr][sc]);
        }
        return image;
    }

    public void helper(int[][] image, int sr, int sc, int color, boolean[][] vis, int orgCol) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgCol) {
            return;
        }

        vis[sr][sc] = true; // Mark as visited
        image[sr][sc] = color; // Fill with new color

        // Left
        helper(image, sr, sc - 1, color, vis, orgCol);
        // Right
        helper(image, sr, sc + 1, color, vis, orgCol);
        // Up
        helper(image, sr - 1, sc, color, vis, orgCol);
        // Down
        helper(image, sr + 1, sc, color, vis, orgCol);
    }

    public static void main(String args[]) {
        FloodFillAlgorithm obj = new FloodFillAlgorithm();
        int[][] image = {
            {1, 1, 0, 0},
            {1, 1, 0, 0},
            {0, 0, 2, 2},
            {0, 0, 2, 2}
        };
        int sr = 1, sc = 1, color = 3;

        System.out.println("Original Image:");
        printImage(image);

        obj.floodFill(image, sr, sc, color);

        System.out.println("Updated Image:");
        printImage(image);
    }

    public static void printImage(int[][] image) {
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}
