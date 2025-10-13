import java.util.PriorityQueue;

public class WeakestSoldier {
    static class Row implements Comparable<Row> {
        int soldier;
        int i;

        Row(int soldier, int i){
            this.soldier = soldier;
            this.i = i;
        }

        @Override
        public int compareTo(Row r2){
            if (this.soldier == r2.soldier) {
                return this.i - r2.i;
            }else{
                return this.soldier = r2.soldier;
            }
        }
    }
    public static void main(String[] args) {
        int soldiers[][] = {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0 ,0}
        };

        int k =2;

        PriorityQueue<Row> pq = new PriorityQueue<>();

        for(int i=0; i<soldiers.length; i++){
            int count = 0;
            for(int j=0; j<soldiers[0].length; j++){
                count+=soldiers[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(count, i));
        }

        for(int i=0; i<k; i++){
            System.out.println("R" + pq.remove().i);
        }
    }
}