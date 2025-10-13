package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortByCharacter {
    public static void main(String[] args) {
        String s = "tree";
        int maxFreq = Integer.MIN_VALUE;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            }else{
                map.put(ch, 1);
            }
        }

        //Getting all the keys from map
        ArrayList<Character> keys = new ArrayList<>(map.keySet());

        PriorityQueue<Character> pq = new PriorityQueue<>((Character t, Character o) -> {
            return map.get(o) - map.get(t);
        });

        for(int i=0; i<keys.size(); i++){
            pq.add(keys.get(i));             // we are taking keys.get(i) not the map.get to get the value
        }

        // while (!pq.isEmpty()) {
        //     System.out.println(pq.remove());
        // }

        StringBuilder sb = new StringBuilder();

        while (pq.size() > 0) {
            char ch = pq.remove();
            int fre = map.get(ch);

            while (fre > 0) {
                sb.append(ch);
                fre--;
            }
        }

        for(int i=0; i<sb.length(); i++){
            System.out.print(sb.charAt(i));
        }
    }
}



/*

Insertions into the heap:
We are using a min-heap, meaning the element with lowest compareTo() result (i.e., highest priority) comes at the root.

Step 1: Insert (1,1)
Heap is empty → insert at root.

Heap:

scss

(1,1)
No comparisons needed.

Step 2: Insert (2,2)
Add (2,2) at the next available position (left child of root).

Heap now:

markdown

        (1,1)
       /
    (2,2)
Now, upheapify compares (2,2) with parent (1,1):

compareTo call: (2,2).compareTo(1,1)

Frequencies different → compare freq ascending:

this.freq - i2.freq = 2 - 1 = 1 > 0 → positive

Positive means (2,2) has lower priority than (1,1) → no swap.

Step 3: Insert (3,2)
Add (3,2) as the right child of root:

markdown

        (1,1)
       /     \
    (2,2)   (3,2)
Upheapify compares (3,2) with parent (2,2):

compareTo call: (3,2).compareTo(2,2)

Frequencies equal → compare values descending:

i2.val - this.val = 2 - 3 = -1 → negative

Negative means (3,2) has higher priority than (2,2) → so swap!

After swap:

markdown

        (1,1)
       /     \
    (3,2)   (2,2)
Now, continue upheapify — compare (3,2) with root (1,1):

compareTo call: (3,2).compareTo(1,1)

Freq: 2 vs 1 → 2 - 1 = 1 > 0 → positive

(3,2) has lower priority than (1,1) → no swap, upheapify ends.

Final heap:
markdown

        (1,1)
       /     \
    (3,2)   (2,2)
What happens inside the heap during insertion?
Heap keeps the element with lowest freq at the root.

When frequencies tie, it keeps the element with higher val higher in priority (i.e., closer to the root).

So (3,2) swaps above (2,2) because for equal freq, val descending means bigger val is higher priority.

Summary:
(1,1) with lowest freq stays at root.

(3,2) has same freq as (2,2), but bigger val, so it moves up above (2,2).

Heap property is maintained because every parent has higher priority (according to comparator) than its children.

 */




//Main Logic

/*Both during adding (upheapify) and removing (downheapify), the heap uses your comparator logic to decide how to arrange elements.

When adding: The comparator decides if the newly added element should swap up with its parent.

When removing: The comparator helps pick which child to swap down with the parent to maintain the heap order.

1. The comparator is part of each element’s class
Your Info class implements Comparable<Info>, which means every Info object knows how to compare itself to another Info.

When you do a.compareTo(b), the logic inside compareTo runs.

The heap calls compareTo whenever it needs to order two elements.

2. Heap operations rely on this comparison
The heap’s add method calls compareTo between child and parent during upheapify.

The heap’s poll or remove method calls compareTo between parent and children during downheapify.

At each comparison, the comparator logic runs fresh, comparing the current values of those elements.

3. Because every element knows how to compare, the heap simply calls compareTo when needed
It never stores “this element is smaller” or “this element is bigger” as fixed data.

Instead, it asks the elements: “hey, compare yourself to this other one!” and acts based on the returned value.

4. If elements change, comparator reflects that automatically
If an element’s freq or val changes (rare in heaps, but possible), the next compareTo call will use updated values.

So the heap’s order is always consistent with the comparator’s logic at the time of comparison.
 */




/*
Exactly! Every time the heap needs to decide the order between two elements—whether during insertion (upheapify), removal (downheapify), or any reordering—it invokes the comparator’s compareTo method to check their relative priority.

So:
The comparator runs fresh on each comparison, using the current values of those elements.
It does not store any priority ranking separately; it always calculates it on demand.
This ensures the heap order always reflects the comparator’s logic, even if elements’ internal values change (if that ever happens).
 */