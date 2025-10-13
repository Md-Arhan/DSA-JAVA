/*Leet Code : 1791
Center of the node*/

// public class Assignment {

//     public static void main(String []args){
//         int a = edges[0][0];
//         int b = edges[0][1];

//         if (a == edges[0][0] || a==edges[1][1]) {
//             return a;
//         }else{
//             return b;
//         }
//     }
// }


/* Leet Code 997
 * Find the town judge
*/

// public class Assignment {

//     public static void main(String[] args) {
//         int indegree[] = new int[n+1];
//         int outdegree[] = new int[n+1];

//         for(int i=0; i<trust.length; i++){
//             int a = trust[i][0];
//             int b = trust[i][1];
//             // a->b
//             outdegree[a]++;
//             indegree[a]++;
//         }

//         for(int i=1; i<=n; i++){
//             if (outdegree[i]==0 && indegree[i]==n-1) {
//                 return i;
//             }
//         }
//     return -1
//     }
// }

 

/* Adjaceny List */

// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.Queue;

// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.Queue;

// public class Assignment {

//     static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj){
//         int n = adj.size();
//         Queue<Integer> q = new LinkedList<>();
//         ArrayList<Integer> ans = new ArrayList<>();
//         int vis[] = new int[n];

//         q.add(0);
        
//         while (!q.isEmpty()) {
//             int curr = q.remove();

//             ans.add(curr);

//            for (int conn : adj.get(curr)) {
//             /* for (int conn : adj.get(curr).size)
//              * that code would result in a compilation error in Java. Here's why:
//              * Since size() is an int, it's invalid to use it in an enhanced for loop.
//              */
//               if (vis[conn] == 0) {
//                 vis[conn] = 1;
//                 q.add(conn);
//               }
//            }
//         }
//         return ans;
//     }

//     public static void main(String[] args){

//     }
// }



//How to form a cycle

// import java.util.*;

// public class Assignment {

//     static boolean cycleUsingbfs(int source,ArrayList<ArrayList<Integer>> adj, boolean isVisited[]){
//         Queue<Integer> q = new LinkedList<>();
//         q.add(source);
//         isVisited[source] = true;

//         while (!q.isEmpty()) {
//             int curr = q.remove();
//             for (int conn : adj.get(curr)) {
//                 if (isVisited[conn] == true) {
//                     // there is a cycle
//                     return true;
//                 }else{
//                     isVisited[conn] = true;
//                     q.add(conn);
//                 }
//             }
//         }

//         return false;
//     }

//     public static boolean detectCycle(ArrayList<ArrayList<Integer>> adj, boolean vis[]){
//         for(int i=0; i<adj.size(); i++){
//             if (vis[i] == false) {
//                 boolean res = cycleUsingbfs(i, adj, vis);
//                 if (res == true) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }

//     public static void main(String[] args) {
        
//     }
// }



//Find Minimum Depth binary tree
// LeetCode : 111

// import BinaryTrees.Node;

// public class Assignment {

//     static int min = 0;

//     static void rec(Node curr, int level){
//         if (curr == null) {
//             return;        
//         }

//         if (curr.left == null && curr.right== null) {
//             if (level<min) {
//                 min = level;
//             }
//             return;
//         }

//         rec(curr.left, level+1);
//         rec(curr.right, level+1);
//     }

//     public int minDepth(Node root){
//         if (root == null) {
//             return 0;
//         }

//         rec(root, 1);
//     }

    
// }


//LeetCode : 785

// import java.util.LinkedList;
// import java.util.Queue;

// public class Assignment {

//     class Solution{
//         public static boolean isBapartite(int graph[][]){
//             int n = graph.length;
//             int col[] = new int[n];
//             for(int i=0; i<n; i++){
//                 col[i] = -1;
//             }

//             for(int i=0; i<n; i++){
//                 if (col[i] == -1) {
//                     boolean res = check(i, graph, col);
//                     if (res == false) {
//                         return true;
//                     }
//                 }
//             }
//           return false;
//         }

//         public static boolean check(int curr, int graph[][], int color[] ){
//             Queue<Integer> q = new LinkedList<>();
//             q.add(curr);
//             color[curr] = 0;

//             while (!q.isEmpty()) {
//                 int c = q.remove();
//                 int currCol = color[c];

//                 for (int conn : graph[c]) {
//                     if (color[conn] == -1) {
//                         color[conn] = 1- currCol;
//                         q.add(conn);
//                     }else{
//                         if (currCol == color[conn]) {
//                             return false;
//                         }
//                     }
//                 }
//             }
//             return true;
//         }
//     }
// }



//Kahn's Algorithm
/* Topolgical Sort */

// import java.util.*;

// public class Assignment {

//     static ArrayList<Integer> topSort(ArrayList<ArrayList<Integer>> adj){
//         int n = adj.size();
//         int indegree[] = new int[n];

//         for(int curr=0; curr<n; curr++){
//             for (int conn : adj.get(curr)) {
//                 indegree[conn]++;
//             }
//         }

//         Queue<Integer> q = new LinkedList<>();
//         for(int i=0; i<indegree.length; i++){
//             if(indegree[i] == 0){
//                 q.add(i);
//             }
//         }

//         ArrayList<Integer> ans = new ArrayList<>();
//         while (!q.isEmpty()) {
//             int curr = q.remove();
//             ans.add(curr);
//             for(int conn : adj.get(curr)){
//                 indegree[conn]--;
//                 if (indegree[conn] == 0) {
//                     q.add(conn);
//                 }
//             }
//         }
//         return ans;
//     }

//     public static void main(String[] args) {
        
//     }
// }



//Detect cycle in directed Graph


// public class Assignment {

//     static boolean topSort(ArrayList<ArrayList<Integer>> adj){
//         int n = adj.size();
//         int indegree[] = new int[n];

//         for(int curr=0; curr<n; curr++){
//             for (int conn : adj.get(curr)) {
//                 indegree[conn]++;
//             }
//         }

//         Queue<Integer> q = new LinkedList<>();
//         for(int i=0; i<indegree.length; i++){
//             if(indegree[i] == 0){
//                 q.add(i);
//             }
//         }

//         ArrayList<Integer> ans = new ArrayList<>();
//         while (!q.isEmpty()) {
//             int curr = q.remove();
//             ans.add(curr);
//             for(int conn : adj.get(curr)){
//                 indegree[conn]--;
//                 if (indegree[conn] == 0) {
//                     q.add(conn);
//                 }
//             }
//         }
//         if (ans.size() == n) {
//             return false;    //no cycle  
//         }else{
//             return true;     // cycle found
//         }
//     }

//     public static void main(String[] args) {
        
//     }
// }


//Course Schedule
//207

/*
1 → 0: adj[0] = [1], indegree[1] = 1
2 → 1: adj[1] = [2], indegree[2] = 1
3 → 2: adj[2] = [3], indegree[3] = 1
Now, we have:

java
Copy
Edit
adj = [[1], [2], [3], []] // adjacency list representation
indegree = [0, 1, 1, 1]   // in-degree counts
Step 2: Initialize queue with nodes having indegree = 0
We add courses with indegree = 0 to the queue:

Course 0 has indegree = 0, so q = [0]
Step 3: Process nodes in queue
q = [0]
Dequeue 0, add it to ans: ans = [0]
Reduce indegree[1] → 0, enqueue 1
q = [1]
Dequeue 1, add it to ans: ans = [0, 1]
Reduce indegree[2] → 0, enqueue 2
q = [2]
Dequeue 2, add it to ans: ans = [0, 1, 2]
Reduce indegree[3] → 0, enqueue 3
q = [3]
Dequeue 3, add it to ans: ans = [0, 1, 2, 3]
Step 4: Check result
Since ans.size() == n (4), return true.
 */

// public class Assignment {

//     public boolean canFinish(int n, int [][]pre){
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         int indegree[] = new int[n];
//         for(int i=0; i<n; i++){
//             adj.add(new ArrayList<>());
//         }

//         for(int i=0; i<pre.length; i++){
//             int a = pre[i][0];
//             int b = pre[i][1];
//             //b->a
//             adj.get(b).add(a);
//             indegree[a]++;
//         }

//         Queue<Integer> q = new LinkedList<>();
//         for(int i=0; i<n; i++){

//                 if (indegree[i] ==0) {
//                     q.add(i);
//                 }
            
//         }

//         ArrayList<Integer> ans = new ArrayList<>();
//         while (!q.isEmpty()) {
//             int curr = q.remove();
//             ans.add(curr);

//             for(int conn : adj.get(curr)){
//                 indegree[conn]--;
//                 if (indegree[conn] == 0) {
//                     q.add(conn);
//                 }
//             }
//         }
//         if (ans.size()==n) {
//             return true;
//         }else{
//             return false;
//         }
//     }

//     public static void main(String args[]){
    
//     }
// }



 /* Course Schedule
  * Leet Code 207
  */

//   public class Assignment {

//     public boolean canFinish(int n, int[][] prerequisites){
//         List<List<Integer>> adj = new ArrayList<>();
//         for(int i=0; i<n; i++){
//             adj.add(new ArrayList<>());
//         }
//         for (int edge[] : prerequisites) {
//             adj.get(edge[0]).add(edge[1]);
//         }

//         Set<Integer> topSort = new LinkedHashSet<>();

//         boolean[] vis = new boolean[n];
//         for(int src = 0; src<n; src++){
//             if (vis[src] == false) {
//                 boolean cycle = dfs(src, vis, adj, topSort);
//                 if (cycle) {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }

//     public static boolean dfs(int src, boolean vis[], List<List<Integer>> adj, Set<Integer> topSort){
//         if (vis[src] == true) {
//             if (topSort.contains(src)) {
//                 return false;
//             }else{
//                 return true;
//             }
//         }
//         vis[src] = true;

//         for(int i=0; i<adj.get(src).size(); i++){
//                 boolean cycle = dfs(i, vis, adj, topSort);
//                 if (cycle == true) {
//                  return true;
            
//            }
//         }
//         topSort.add(src);   ///postOrder
//         return false;
//     }
  
//     public static void main(String args[]){

//     }
//   }



//Rotten Oranges
/* Leet code 994 
 * Shortest using bfs
*/

// import java.util.*;

// public class Assignment {

//     static class Pair{
//       int r;
//       int c;
//       int t;

//       Pair(int r, int c, int t){
//         this.r  = r;
//         this.c = c;
//         this.t = t;
//       }
//     }

//     public int orangeRotting(int[][] grid){
//       Queue<Pair> q = new ArrayDeque<>();

//       int fresh = 0, maxTime = 0;

//       for(int i=0; i<grid.length; i++){
//         for(int j=0; j<grid[0].length; j++){
//           if (grid[i][j] == 2) {
//             q.add(new Pair(i, j, 0));
//           }else if (grid[i][j] ==1) {
//             fresh++;
//           }
//         }
//       }

//       int dr[] = {-1, 1, 0, 0};
//       int dc[] = {0, 0 , -1, 1};

//       while (!q.isEmpty()) {
//          Pair curr = q.remove();

//          for(int d=0; d<dr.length; d++){
//             int r = curr.r + dr[d];
//             int c = curr.c + dc[d];

//             if (r >=0 && r < grid.length && c>=0 && c < grid[0].length && grid[r][c] == 1) {
//               q.add(new Pair(r, c, curr.t+1));
//               grid[r][c] = 2;
//               maxTime = curr.t + 1;
//               fresh--;
//             }
//          }
//       }

//       if (fresh>0) {
//         return -1;
//       }

//       return maxTime;
//     }
// }




//Disjoint set union

// class DSU{
//   int[] parent;
//   int[] weight;

//   DSU(int n){
//     this.parent = new int[n];
//     for(int i=0; i<n; i++){
//       parent[i] = i;
//     }
//     this.weight = new int[n];
//     for(int i=0; i<n; i++){
//       weight[i] = 1;
//     }
//   }

//   // path compression
//   int find(int idx){
//     if (parent[idx] == idx)return idx;
//     return parent[idx] =  find(parent[idx]);   //caching
//   }

//   //weightes compression
//   void union(int a, int b){
//     int pa = find(a);
//     int pb = find(b);

//     if (pa == pb) {
//       return;
//     }

//     if(weight[pa] > weight[pb]){
//       parent[pb] = pa;
//       weight[pa] += weight[pb];
//     }else{
//       parent[pa] = pb;
//       weight[pb] += weight[pa];
//     }
//   }
// }

// public class Assignment {

//   public static void main(String[] args) {
    
//   }
// }



