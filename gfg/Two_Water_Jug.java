class Solution {
    
    private int GCD(int a, int b){
        if(b == 0){
            return a;
        }
        return GCD(b, a%b);
    }
    
    private int solve(int CupA, int CupB, int d){
        int from = CupA;
        int to = 0;
        int step = 1;
        
        while(from != d && to != d){
            int temp = Math.min(from, CupB - to);
            to+=temp;
            from-=temp;
            step++;
            
            if(from == d || to == d){
                return step;
            }
            
            if(from == 0){
                from = CupA;
                step++;
            }
            
            if(to == CupB){
                to = 0;
                step++;
            }
        }
        
        return step;
    }
    
    public int minSteps(int m, int n, int d) {
        // code here
        if(d > Math.max(m, n))return -1;
        
        if(d % GCD(m, n) != 0) return -1;
        
        int ans1 = solve(m, n, d);
        int ans2 = solve(n, m, d);
        
        return Math.min(ans1, ans2);
    }
}


/*
GCD is the smallest amount you can ever isolate

Once you can isolate:

1 → everything possible
2 → only multiples of 2
k → only multiples of k


Intuition (Think in "chunks")

GCD = 2 means:

👉 Both jugs are made of 2-liter chunks

4 = 2 + 2
6 = 2 + 2 + 2

So no matter what you do:
👉 you can only rearrange chunks of size 2

❌ You can’t create a 1-liter difference


9, 18 GCD is 9
common is 9 liter jug which can't fix the d liter jug

You’re very close — just tweak the wording a bit to make the idea precise.

🧠 What’s really happening

It’s not that:

“9 liter jug can’t fix 12”

👉 The real idea is:

Both jugs can only measure water in chunks of 9 liters (the GCD
Think like this:

9L jug → made of one 9-unit block
18L jug → made of two 9-unit blocks

👉 You only have 9-unit blocks

So you can build:

1 block → 9  
2 blocks → 18  
3 blocks → 27  

❌ But you can’t break a block into 3*/