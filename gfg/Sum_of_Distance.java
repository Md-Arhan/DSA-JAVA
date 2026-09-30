public class Sum_of_Distance {
    
}



/*
This is the key transformation

👉 Instead of computing each difference individually, you rewrite: (x - a) + (x - b) + (x - c)

as:x + x + x  -  (a + b + c)
🔥 Why this is powerful
Now you don’t need a loop.
You just need:
how many times x appears → count = i
sum of previous elements → prefix[i-1]

So:x + x + x = x * i

Final: left = x * i - (a + b + c)


Same idea for RIGHT side

Now suppose:

lst = [y, z]   (elements after idx)

We compute:

(y - x) + (z - x)

Expand:

= y - x + z - x
= (y + z) - (x + x)
💡 Again same pattern
= sum of elements - x * count

So:

right = (sum of right elements) - x * (number of elements)  


In short:


LEFT side (elements < idx):
∣idx−x∣=idx−x|idx - x| = idx - x∣idx−x∣=idx−x
So:
(idx - a) + (idx - b) = idx*count - (a + b)


RIGHT side (elements > idx):
∣idx−x∣=x−idx|idx - x| = x - idx∣idx−x∣=x−idx
So:
(a - idx) + (b - idx) = (a + b) - idx*count



🎯 One-line memory trick:


LEFT → idx first → idx * count - sum


RIGHT → sum first → sum - idx * count
 */