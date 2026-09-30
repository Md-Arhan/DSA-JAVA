class Solution {

    class Pair {
        int idx;
        int t;

        Pair(int idx, int t) {
            this.idx = idx;
            this.t = t;
        }
    }

    public int minJumps(int[] nums) {

        int n = nums.length;

        if(n == 1) return 0;

        int max = 0;

        for(int val : nums) {
            max = Math.max(max, val);
        }

        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);

        if(max >= 0) isPrime[0] = false;
        if(max >= 1) isPrime[1] = false;

        for(int i = 2; i * i <= max; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        Queue<Pair> q = new LinkedList<>();

        boolean[] vis = new boolean[n];
        boolean[] usedPrime = new boolean[max + 1];

        q.add(new Pair(0, 0));
        vis[0] = true;

        while(!q.isEmpty()) {

            Pair curr = q.poll();

            int i = curr.idx;

            if(i == n - 1) {
                return curr.t;
            }

            // left
            if(i > 0 && !vis[i - 1]) {
                vis[i - 1] = true;
                q.add(new Pair(i - 1, curr.t + 1));
            }

            // right
            if(i < n - 1 && !vis[i + 1]) {
                vis[i + 1] = true;
                q.add(new Pair(i + 1, curr.t + 1));
            }

            if(isPrime[nums[i]] && !usedPrime[nums[i]]) {

                int p = nums[i];

                for(int j = p; j <= max; j += p) {

                    if(map.containsKey(j)) {

                        for(int idx : map.get(j)) {

                            if(!vis[idx]) {
                                vis[idx] = true;
                                q.add(new Pair(idx, curr.t + 1));
                            }
                        }
                    }
                }

                usedPrime[p] = true;
            }
        }

        return -1;
    }
}


/*
Core Idea
BFS

Used when:

all edges have equal weight

Usually every edge cost = 1.

Goal:

minimum number of moves/edges
Dijkstra

Used when:

edge weights are different

Goal:

minimum total cost */