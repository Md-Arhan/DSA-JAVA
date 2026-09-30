package DP.Questions;

public class LongestColourPath {
    import java.util.*;

class Solution {

    int longestPathLength = 0;

    public int longestPath(String s, int[][] edges) {

        int totalNodes = s.length();

        if (totalNodes == 1) {
            return 1;
        }

        List<List<Integer>> adjacencyList = buildGraph(edges, totalNodes);

        dfs(adjacencyList, 1, 0, s);

        return longestPathLength;
    }

    private int[] dfs(List<List<Integer>> adjacencyList,
                      int currentNode,
                      int parentNode,
                      String characters) {

        // Longest downward paths from the current node
        int sameCharacterPathLength = 1;
        int oneDifferencePathLength = 1;

        char currentCharacter = characters.charAt(currentNode - 1);

        List<Integer> neighboringNodes = adjacencyList.get(currentNode);

        for (int childNode : neighboringNodes) {

            if (childNode == parentNode) {
                continue;
            }

            int[] childPathLengths = dfs(
                    adjacencyList, childNode, currentNode, characters
            );

            int childSameCharacterPath = childPathLengths[0];
            int childOneDifferencePath = childPathLengths[1];

            int validSameCharacterExtension;
            int validOneDifferenceExtension;

            char childCharacter = characters.charAt(childNode - 1);

            if (currentCharacter == childCharacter) {

                validSameCharacterExtension = childSameCharacterPath;
                validOneDifferenceExtension = childOneDifferencePath;

            } else {

                validSameCharacterExtension = 0;
                validOneDifferenceExtension = childSameCharacterPath;
            }

            // Combine paths from the current node and its child
            longestPathLength = Math.max(
                    longestPathLength,
                    sameCharacterPathLength + validOneDifferenceExtension
            );

            longestPathLength = Math.max(
                    longestPathLength,
                    oneDifferencePathLength + validSameCharacterExtension
            );

            // Update the longest downward paths
            sameCharacterPathLength = Math.max(
                    sameCharacterPathLength,
                    1 + validSameCharacterExtension
            );

            oneDifferencePathLength = Math.max(
                    oneDifferencePathLength,
                    1 + validOneDifferenceExtension
            );
        }

        return new int[]{
                sameCharacterPathLength,
                oneDifferencePathLength
        };
    }

    private List<List<Integer>> buildGraph(int[][] edges, int totalNodes) {

        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int node = 0; node <= totalNodes; node++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int firstNode = edge[0];
            int secondNode = edge[1];

            adjacencyList.get(firstNode).add(secondNode);
            adjacencyList.get(secondNode).add(firstNode);
        }

        return adjacencyList;
    }
}
}


/*
LONGEST PATH IN A TREE — REVISION NOTES

Approach: DFS + Tree DP

1. CORE IDEA
- Use DFS to process children before their parent.
- Each node maintains two DP states.
- Use child results to update the current node's DP.
- Maintain a global maximum path length.

2. DP VARIABLES
- sameCharacterPathLength: DP state 0.
- oneDifferencePathLength: DP state 1.
- childSameCharacterPath: Child's state 0.
- childOneDifferencePath: Child's state 1.
- longestPathLength: Global maximum.

3. CHARACTER COMPARISON
If characters are the same:
    validSameCharacterExtension = childSameCharacterPath
    validOneDifferenceExtension = childOneDifferencePath

If characters differ:
    validSameCharacterExtension = 0
    validOneDifferenceExtension = childSameCharacterPath

4. UPDATE GLOBAL MAXIMUM
- Combine paths from different branches through the current node.
- Update longestPathLength using the maximum valid combination.

5. UPDATE DP STATES
- Add 1 for the current node.
- Keep the maximum valid downward path length.
- Return both DP states to the parent.

6. COMPLEXITY
- Time: O(N)
- Space: O(N)

7. MEMORY TRICK
DFS → Get child DP → Compare characters → 
Combine branches → Update DP → Return to parent.

NOTE:
These notes summarize the earlier code structure.
Verify the DP transitions against the original problem statement.

*/