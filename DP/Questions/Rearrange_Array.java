class Solution {
    boolean isSorted(int arr[])
    {
        int len=arr.length;
        for(int i=0;i<len-1;i++)
        {
            if(arr[i+1]!=arr[i]+1)
            return false;
        }
        return true;
    }
    int minOperations(int[] b) {
        // code here
        int len=b.length;
        int count=0;
        int arr[]=new int[len];
        for(int i=0;i<len;i++)
        arr[i]=i+1;
        
        do
        {
            int next[]=new int[len];
            for(int i=0;i<len;i++)
            next[b[i]-1] = arr[i];
            
            arr=next;
            count++;
        }
        while(!isSorted(arr));
        return count;
    }
};

/*
Meaning:

Take arr[i] and put it at the destination position given by b[i].

Since Java uses zero-based indexing, destination index is:

b[i] - 1

From b:

b = [2, 3, 1, 5, 4]

the movements are:

Element at position 1 → position 2
Element at position 2 → position 3
Element at position 3 → position 1
Element at position 4 → position 5
Element at position 5 → position 4



nPr means permutation.

We use nPr when:

We have n items and want to arrange/select r items where order matters.


*/