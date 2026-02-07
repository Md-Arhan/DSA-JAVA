public class MeetingsRooms_III {
    class Solution {

    class Meeting implements Comparable<Meeting> {
        int roomId;
        int timing;

        Meeting(int roomId, int timing) {
            this.roomId = roomId;
            this.timing = timing;
        }

        @Override
        public int compareTo(Meeting other) {
            if (this.timing == other.timing) {
                return this.roomId - other.roomId;
            }
            return this.timing - other.timing;
        }
    }

    public int mostBooked(int n, int[][] meetings) {
        int len = meetings.length;

        Arrays.sort(meetings, (a, b) -> {
            return a[0] - b[0];
        });

        PriorityQueue<Meeting> meet = new PriorityQueue<>();

        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for(int i=1; i<=n; i++){
            rooms.add(i);
        }

        int ans[] = new int[n+1];

        for(int i=0; i<len; i++){
            int start = meetings[i][0];
            int end = meetings[i][1];

            while(!meet.isEmpty() && meet.peek().timing <= start){
                rooms.add(meet.poll().roomId);
            }

            int duration = end - start;

            if(!rooms.isEmpty()){
                int roomNo = rooms.poll();
                ans[roomNo]++;

                meet.add(new Meeting(roomNo, end));
            }else{
                Meeting curr = meet.poll();
                ans[curr.roomId]++;
                curr.timing+=duration;
                meet.add(curr);
            }
        }
         
        int max = 0;
        int result = 0;

        for(int i=1; i<=n; i++){
             if(ans[i] > max){
                max = ans[i];
                result = i;
             }
        }

        return result-1;
    }
}
}
