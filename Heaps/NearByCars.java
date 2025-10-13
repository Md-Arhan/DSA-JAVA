import java.util.PriorityQueue;

public class NearByCars {
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distSq;
        int idx;

        Point(int x, int y, int distSq, int idx){
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2){
            return this.distSq - p2.distSq;  // ascending Order
        }
    }

    public static void main(String[] args) {
        int pts[][] = {
            {3, 3},
            {5, -1},
            {-2, 4}
        };
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for(int i=0; i<pts.length; i++){
            int distSq = pts[i][0] * pts[i][0] +  pts[i][1] *  pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }

        //Nearest L Cars
        for(int i=0; i<k; i++){
            System.out.println("C" + pq.remove().idx);
        }
    }
}


/*
 * 1. Distance Between Two Points (Euclidean Distance)
If you have two points on a square or in the 2D plane:

Point A: (𝑥1,𝑦1)(x 1​,y 1 )

Point B: 
(𝑥2,𝑦2)(x 2,y 2​)

Then the distance between them is:

Distance
=(𝑥2−𝑥1)2+(𝑦2−𝑦1)2Distance= (x 2​ −x 1 ) 2 +(y 2​ −y 1 ) 2
 
​
 
This is the straight-line or Euclidean distance.

2. Diagonal of a Square
If you have a square of side length 
𝑠
s, and you want the distance from one corner to the opposite corner (i.e., the diagonal):

Diagonal=𝑠2+𝑠2=𝑠2Diagonal= s2+s 2 =s 2
​
 
Example: If side 𝑠=5s=5, then diagonal = 52≈7.075 2≈7.07

3. Perimeter and Area (Also Related to Distance)
Perimeter: Total length around the square
𝑃=4×𝑠
P=4×s
Area: Space inside the square

𝐴=𝑠2A=s 2
 
4. Manhattan Distance (Grid-Based Distance)
Used in some math problems (like pathfinding or in city grid layouts):

Manhattan Distance=∣𝑥2−𝑥1∣+∣𝑦2−𝑦1∣
Manhattan Distance=∣x 2−x 1∣+∣y 2−y 1∣
This only counts horizontal + vertical steps, not diagonal.
 */