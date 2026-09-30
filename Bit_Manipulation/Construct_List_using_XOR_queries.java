class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        int xor = 0;
        for(int i=0;i<queries.length;i++){
            if(queries[i][0]==1){
                xor ^= queries[i][1]; 
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0^xor);
        for(int i=0;i<queries.length;i++){
            int op = queries[i][0];
            int ele = queries[i][1];
            if(op==0){
                ans.add(ele^xor);
            }
            else{
                xor ^= ele;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}

/*
Core Idea

Instead of applying XOR to every element every time, maintain one variable called xor.

xor = cumulative XOR still to be applied
Step 1: Find the final XOR
for(all queries)
    if(type == 1)
        xor ^= value;

Now xor contains the XOR of all type-1 queries.

Example:

1 2
1 5
1 3

xor = 2 ^ 5 ^ 3
Step 2: Add the initial element

Initially the list is

[0]

Store

0 ^ xor

instead of 0.

Step 3: Process queries again
If query is 0 x (insert)

Store

x ^ xor

Why?

Because xor represents all future XOR operations that this newly inserted element will experience.

If query is 1 x

Do

xor ^= x;

Why?

Because you've now passed this XOR operation.

It is no longer a future XOR, so remove it from xor.

One Line to Remember

xor always represents the XOR operations that are still remaining (future XORs).

That's the entire trick.

Mental Picture

Suppose

Queries:

0 5
1 2
0 7
1 3
First pass
xor = 2 ^ 3 = 1
Second pass
Start xor = 1

Insert 5
store 5^1

Pass XOR 2
xor = 1^2 = 3

Insert 7
store 7^3

Pass XOR 3
xor = 3^3 = 0

Done.

5-Second Revision
1. Calculate total XOR of all type-1 queries.

2. xor = future XORs.

3. Insert x as x ^ xor.

4. Whenever a type-1 query is crossed,
   remove it from future:
       xor ^= value

5. Sort and return.

This is the key observation you need to remember during revision:

Never update the whole list. Keep a running xor of the XOR operations that are yet to happen, and encode each inserted value with that xor.manh */