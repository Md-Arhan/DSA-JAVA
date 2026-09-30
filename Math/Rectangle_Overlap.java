class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0] < rec2[2] &&
               rec2[0] < rec1[2] &&
               rec1[1] < rec2[3] &&
               rec2[1] < rec1[3];
    }
}


/*
========================================================
836. RECTANGLE OVERLAP
========================================================

KEY IDEA:
Two axis-aligned rectangles overlap if they have:

    1. Positive overlap on X-axis
    AND
    2. Positive overlap on Y-axis

Think:

        X overlap
            +
        Y overlap
            ↓
     RECTANGLES OVERLAP


========================================================
1. WHAT IS [x1, y1, x2, y2]?
========================================================

[x1, y1] = Bottom-left
[x2, y2] = Top-right


Example:

rec = [0, 0, 2, 2]


              (2,2)
                ●
                ┌─────────┐
                │         │
                │         │
                │         │
                └─────────┘
              ●
            (0,0)


X-axis: 0 → 2
Y-axis: 0 → 2


========================================================
2. OVERLAPPING RECTANGLES
========================================================

rec1 = [0,0,2,2]
rec2 = [1,1,3,3]


                 3,3
                  ●
                  ┌──────────┐
                  │   R2     │
                  │          │
          2,2     │    ┌─────┼──┐
            ●     │    │█████│  │
            ┌─────┼────┼█████│  │
            │ R1  │████│█████│  │
            │     │████│█████│  │
            └─────┼────┘     │  │
                  │          │  │
                  └──────────┴──┘
                 1,1


████ = COMMON / OVERLAPPING AREA


The rectangles share an actual area.

Therefore:

    true


========================================================
3. UNDERSTAND IT USING X AND Y
========================================================

X-axis:

rec1:   0 ───────── 2
rec2:       1 ───────── 3
                ↑
          common: 1 → 2

So X overlaps.


Y-axis:

rec1:   0 ───────── 2
rec2:       1 ───────── 3
                ↑
          common: 1 → 2

So Y overlaps.


Therefore:

    X overlap = YES
    Y overlap = YES

            ↓

    RECTANGLE OVERLAPS


========================================================
4. TOUCHING AT AN EDGE
========================================================

rec1 = [0,0,1,1]
rec2 = [1,0,2,1]


       R1             R2
    ┌───────┐       ┌───────┐
    │       │       │       │
    │       │       │       │
    │       │       │       │
    └───────┘       └───────┘
            ↑
         x = 1


They only TOUCH.

They don't share any width.

Therefore:

    X overlap = NO
    Y overlap = YES

Since BOTH are required:

    false


IMPORTANT:

    TOUCHING ≠ OVERLAPPING


========================================================
5. TOUCHING AT A CORNER
========================================================

rec1 = [0,0,1,1]
rec2 = [1,1,2,2]


    R2
    ┌───────┐
    │       │
    │       │
    └───────●
            │
            │
    ┌───────●
    │       │
    │   R1  │
    └───────┘


They only touch at ONE POINT.

Common area = 0

Therefore:

    false


========================================================
6. COMPLETELY SEPARATE
========================================================

rec1 = [0,0,1,1]
rec2 = [2,2,3,3]


    R2
    ┌───────┐
    │       │
    │       │
    └───────┘


    R1
    ┌───────┐
    │       │
    │       │
    └───────┘


No common area.

Therefore:

    false


========================================================
7. HOW DO WE CHECK X OVERLAP?
========================================================

Suppose:

rec1:

    left1 = rec1[0]
    right1 = rec1[2]

rec2:

    left2 = rec2[0]
    right2 = rec2[2]


Drawing:

    rec1
    0 ───────────── 2
           1 ───────────── 3
               rec2


Check:

    left1 < right2
    &&
    left2 < right1


For the example:

    0 < 3  → true
    1 < 2  → true

Therefore X overlaps.


========================================================
8. HOW DO WE CHECK Y OVERLAP?
========================================================

Suppose:

rec1:

    bottom1 = rec1[1]
    top1    = rec1[3]

rec2:

    bottom2 = rec2[1]
    top2    = rec2[3]


Drawing:

    rec1:  0 ───────── 2
    rec2:      1 ───────── 3


Check:

    bottom1 < top2
    &&
    bottom2 < top1


For the example:

    0 < 3  → true
    1 < 2  → true

Therefore Y overlaps.


========================================================
9. FINAL CONDITION
========================================================

X overlap:

    rec1[0] < rec2[2] &&
    rec2[0] < rec1[2]

Y overlap:

    rec1[1] < rec2[3] &&
    rec2[1] < rec1[3]


Therefore:

    rec1[0] < rec2[2] &&
    rec2[0] < rec1[2] &&
    rec1[1] < rec2[3] &&
    rec2[1] < rec1[3]


========================================================
10. JAVA CODE
========================================================

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        return rec1[0] < rec2[2] &&
               rec2[0] < rec1[2] &&
               rec1[1] < rec2[3] &&
               rec2[1] < rec1[3];
    }
}


========================================================
11. WHY "<" AND NOT "<="?
========================================================

Because we need POSITIVE AREA.

Example:

    R1          R2
    ┌─────┐     ┌─────┐
    │     │     │     │
    │     │     │     │
    └─────┘     └─────┘
          ↑
        touching


X ranges:

    R1: 0 → 1
    R2: 1 → 2

Check:

    R2.left < R1.right

    1 < 1

    false


Perfect!

Because they only touch.

If we used <=:

    1 <= 1

    true

That would be WRONG.


========================================================
12. MOST IMPORTANT MEMORY TRICK
========================================================

             RECTANGLE
                 │
          ┌──────┴──────┐
          ↓             ↓
       X-axis         Y-axis
       overlap        overlap
          │             │
          └──────┬──────┘
                 ↓
               BOTH
                 ↓
             OVERLAP


X:

    left1 < right2
    &&
    left2 < right1


Y:

    bottom1 < top2
    &&
    bottom2 < top1


REMEMBER:

    X overlap + Y overlap = Rectangle overlap

    Use "<" because touching does NOT count.


========================================================
13. COMPLEXITY
========================================================

Time:  O(1)

Space: O(1)


No loops.
No extra data structures.

Just 4 comparisons.
*/