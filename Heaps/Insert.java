import java.util.*;

public class Insert {
     static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){   //O(logn)  //upheapify
            //add at last idx
            arr.add(data);

            int x = arr.size()-1;   //x is child index   //constant
            int par = (x-1)/2;      //parent index

            while (arr.get(x) < arr.get(par)) {  //O(logn)
                //Swap
                int temp = arr.get(x);
                
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x-1)/2;
            }
        }

        public int peek(){
           return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2 * i +1;
            int right = 2 * i +2;
            int min = i;

            if (left < arr.size() && arr.get(min) > arr.get(left)) {
                min = left;
            }

            if (right < arr.size() && arr.get(min) > arr.get(right)) {
                min = right;
            }

            if (min != i) {
                //Swap 
                int temp = arr.get(i);
                arr.set(i, arr.get(min));
                arr.set(min, temp);
 
                heapify(min);
            }
        }

        public int remove(){
            int data = arr.get(0);

            //Step 1 - Swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //Step 2 - delete last
            arr.remove(arr.size()-1);

            //Step 3 - heapify, downheapify 
            heapify(0);
            return data;

        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public class PriorityQueue<T extends Comparable<T>> {
    private List<T> heap = new ArrayList<>();

    public void add(T val) {
        heap.add(val);
        upheapify(heap.size() - 1);
    }

    private void upheapify(int idx) {
        int parent = (idx - 1) / 2;
        if (idx > 0 && heap.get(idx).compareTo(heap.get(parent)) < 0) {
            // swap
            T temp = heap.get(idx);
            heap.set(idx, heap.get(parent));
            heap.set(parent, temp);
            upheapify(parent);
        }
    }

    public T poll() {
        if (heap.size() == 0) return null;
        T top = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            downheapify(0);
        }
        return top;
    }

    private void downheapify(int idx) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        int smallest = idx;

        if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) {
            smallest = right;
        }
        if (smallest != idx) {
            T temp = heap.get(idx);
            heap.set(idx, heap.get(smallest));
            heap.set(smallest, temp);
            downheapify(smallest);
        }
    }
}


    
    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
    
       while (!h.isEmpty()) {   // Heap Sort - O(nlogn)
        System.out.println(h.peek());
        h.remove();
       }
    }
}
