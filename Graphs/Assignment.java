



/*
 * Word Ladder
 */

 /*
  * Step 1: Initialization
Queue (BFS) = [TOON]
Distance Map: {TOON: 1} (distance from start)
Step 2: First BFS Iteration
Current Word: TOON
Distance: 1
Check Adjacent Words in Dictionary:
POON is adjacent (T → P changes) ✅
Update Queue & Distance Map:
Queue: [POON]
Distance Map: {TOON: 1, POON: 2}
Step 3: Second BFS Iteration
Current Word: POON
Distance: 2
Check Adjacent Words:
POIN is adjacent (O → I changes) ✅
Update Queue & Distance Map:
Queue: [POIN]
Distance Map: {TOON: 1, POON: 2, POIN: 3}
Step 4: Third BFS Iteration
Current Word: POIN
Distance: 3
Check Adjacent Words:
POIE is adjacent (N → E changes) ✅
Update Queue & Distance Map:
Queue: [POIE]
Distance Map: {TOON: 1, POON: 2, POIN: 3, POIE: 4}
Step 5: Fourth BFS Iteration
Current Word: POIE
Distance: 4
Check Adjacent Words:
PLIE is adjacent (O → L changes) ✅
Update Queue & Distance Map:
Queue: [PLIE]
Distance Map: {TOON: 1, POON: 2, POIN: 3, POIE: 4, PLIE: 5}
Step 6: Fifth BFS Iteration
Current Word: PLIE
Distance: 5
Check Adjacent Words:
PLEE is adjacent (I → E changes) ✅
Update Queue & Distance Map:
Queue: [PLEE]
Distance Map: {TOON: 1, POON: 2, POIN: 3, POIE: 4, PLIE: 5, PLEE: 6}
Step 7: Sixth BFS Iteration
Current Word: PLEE
Distance: 6
Check Adjacent Words:
PLEA is adjacent (E → A changes) ✅
Update Queue & Distance Map:
Queue: [PLEA]
Distance Map: {TOON: 1, POON: 2, POIN: 3, POIE: 4, PLIE: 5, PLEE: 6, PLEA: 7}
Step 8: Seventh BFS Iteration
Current Word: PLEA
Distance: 7
Target Found! 🎯
Return 7 as the shortest transformation length.
  */

 public class Assignment {

    public class WordLadder {
    
        // Function to check if two words differ by only one character
        private static boolean isAdjacent(String word1, String word2) {
            if (word1.length() != word2.length()) return false;
            
            int diffCount = 0;
            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    diffCount++;
                    if (diffCount > 1) return false;
                }
            }
            return diffCount == 1;
        }
    
        // BFS function to find the shortest transformation sequence length
        public static int shortestWordLadder(String start, String target, Set<String> dictionary) {
            if (!dictionary.contains(target)) return 0;
    
            Queue<String> queue = new LinkedList<>();
            queue.add(start);
            
            Map<String, Integer> distance = new HashMap<>();
            distance.put(start, 1);
    
            while (!queue.isEmpty()) {
                String current = queue.poll();
                int currDist = distance.get(current);
    
                for (String word : dictionary) {
                    if (!distance.containsKey(word) && isAdjacent(current, word)) {
                        queue.add(word);
                        distance.put(word, currDist + 1);
    
                        if (word.equals(target)) {
                            return distance.get(word); // Found the target
                        }
                    }
                }
            }
            return 0; // No transformation sequence found
        }
    
        public static void main(String[] args) {
            Set<String> dictionary = new HashSet<>(Arrays.asList(
                "POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN"
            ));
    
            String start = "TOON";
            String target = "PLEA";
    
            int result = shortestWordLadder(start, target, dictionary);
            System.out.println("Shortest Transformation Sequence Length: " + result);
        }
    }
 }




//Assignment 2

// public class Assignment {

//   public static void main(String[] args) {
    
//   }
// }