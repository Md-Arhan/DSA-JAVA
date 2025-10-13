package Greedy;

public class BookAllocation {

        // Function to check if we can allocate books with the given maxPages per student
        public static boolean canAllocateBooks(int[] books, int n, int m, int maxPages) {
            int studentCount = 1;  // Start with one student
            int currentPages = 0;
    
            for (int i = 0; i < n; i++) {
                // If adding this book exceeds maxPages, allocate to the next student
                if (currentPages + books[i] > maxPages) {
                    studentCount++;
                    currentPages = books[i];
                    // If students exceed m, return false
                    if (studentCount > m) {
                        return false;
                    }
                } else {
                    currentPages += books[i];
                }
            }
            return true;
        }
    
        // Function to find the minimum possible maximum pages
        public static int allocateBooks(int[] books, int n, int m) {
            int left = 0, right = 0;
            // Set left as the max pages in a single book, right as the total pages in all books
            for (int i = 0; i < n; i++) {
                left = Math.max(left, books[i]);
                right += books[i];
            }
    
            int result = right;
            // Binary search to find the minimum maxPages that can be allocated
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (canAllocateBooks(books, n, m, mid)) {
                    result = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
    
            return result;
        }
    
        public static void main(String[] args) {
            int books[] = {12, 34, 67, 90};  // Books with number of pages
            int n = books.length;  // Number of books
            int m = 2;  // Number of students
    
            System.out.println("Minimum maximum pages per student: " + allocateBooks(books, n, m));
        }
}



//Dry run

/*

 * 🔁 Binary Search Steps:
✅ Try mid = (90 + 203) / 2 = 146
Check if we can allocate books with max 146 pages per student.

Student 1:

12 → total = 12

+34 → total = 46

+67 → total = 113

+90 → exceeds 146 → ❌ start Student 2
Student 2:

90 → total = 90 ✅
✔ Students used: 2 (OK)

➡ canAllocateBooks = true, update result = 146, and search left: right = 145

✅ Try mid = (90 + 145) / 2 = 117
Student 1:

12 → 12

+34 → 46

+67 → 113

+90 → too much → new student

Student 2:

90 → total = 90 ✅
✔ Students used: 2 → OK

➡ canAllocateBooks = true, update result = 117, search left: right = 116

✅ Try mid = (90 + 116) / 2 = 103
Student 1:

12 → 12

+34 → 46

+67 → too much → Student 2

Student 2:

67 → 67

+90 → too much → ❌ new student (3 students needed)

✖ More than 2 students → not allowed
➡ canAllocateBooks = false, search right: left = 104

✅ Try mid = (104 + 116) / 2 = 110
Same process — we end up needing 3 students again.

➡ canAllocateBooks = false, left = 111

✅ Try mid = 113
Student 1: 12 + 34 = 46, +67 = 113 ✅
Student 2: 90 ✅
✔ 2 students → OK

➡ canAllocateBooks = true, result = 113, right = 112

✅ Try mid = 111, mid = 112
Still require 3 students → Not OK

✅ Final Result:
After binary search ends, we find the minimum possible max pages per student is 113.


 */




//Recognization for Binary Search on answer

 /*
  * Signs It's a "Binary Search on Answer" Question
1. You’re asked to minimize or maximize something.
Example:

"Minimize the maximum..."

"Find the least number such that..."

"Max number of people that can be seated..."

"Maximum minimum distance..."

➡ These hint at a range of possible answers.

2. The answer lies in a continuous range, not a specific element.
You’re not searching in the array,

You’re searching over a range of numeric values (like 1 to 10⁹).

3. You can write a helper function to check if a solution is valid.
This is the key 🔑

You can define:

java
Copy
Edit
boolean isValid(int mid)
to test whether a certain value satisfies the condition.


  */