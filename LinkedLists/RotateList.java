public class RotateList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int n = 0;
        ListNode dem = head;

        while (dem != null) {
            n++;
            dem = dem.next;
        }

        /*
         * In this case you dont have to count k rotations every time , you just have to
         * calculate k%n rotations ,where is n is number of nodes.
         */
        k = k % n;

        while (k != 0) {
            ListNode temp = head;
            ListNode left = head;
            ListNode prev = null;

            while (temp.next != null) {
                prev = temp;
                temp = temp.next;
            }

            temp.next = left;
            head = temp;
            prev.next = null;
            k--;
        }

        return head;
    }
}



/*
List: head = [1, 2, 3]
List length n = 3

Now try:

k = 3 → k % n = 0 → no rotation

k = 4 → 4 % 3 = 1 → rotate by 1 → [3, 1, 2]

k = 2000000000 → 2000000000 % 3 = 2 → rotate by 2 → [2, 3, 1]

So no matter how large k is, you only need to rotate k % n times to get the same result.

So k % n removes unnecessary full rotations.
 */



 /*
  * Just a tip but whenever you see rotation type position swapping ,
   remember there will be a pattern and it can be used to optimize your code.
   In this case you dont have to count k rotations every time , you just have to calculate k%n rotations
   ,where is n is number of nodes.
  */