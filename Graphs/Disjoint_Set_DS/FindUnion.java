package Disjoint_Set_DS;

public class FindUnion {

    static int n =7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void intit(){
        for(int i=0; i<n; i++){
            par[i] = i;
        }
    }

    public static int find(int x){
        if (x==par[x]) {
           return x; 
        }

        //path compression
        return par[x] =  find(par[x]);
    }

    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        }else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        }else{
            par[parB] = parA;
        }
     }
    
    public static void main(String args[]){
       intit();
       System.out.println(3);
       union(1, 3);
       System.out.println(find(3));
       union(2, 4);
       union(3, 6);
       union(1, 4);
       System.out.println(find(3));
       System.out.println(find(4));
       union(1, 5);
    }
}




/*
 * Disjoin Set:
 * It is a Data Structure that keeps track of a set of elements partitioned into a number of non-overlapping (disjoint) subsets.
 * 
Main Idea of Disjoint Set
Imagine you have many groups (or sets) of people.
At first, each person is alone (in their own group)
Later, you keep merging people into groups.
And sometimes, you want to check:
“Are person A and person B in the same group?”

👉 Disjoint Set helps you:
1️⃣ Combine groups (union)
2️⃣ Check if two people are in the same group (find)

💡 Where do we need this?
In many real-world problems, especially in graphs, we often care about groups:

Kruskal’s algorithm (to build Minimum Spanning Tree):
Don’t connect nodes if they’re already in the same group — avoid cycles.

Cycle detection (in undirected graphs):
If you try to connect two nodes already in the same group, you form a cycle.

Connected components:
How many separate groups are there in the graph?


 */