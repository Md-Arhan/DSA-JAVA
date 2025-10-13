# Tries

What is a Trie?
A Trie is a tree-like data structure used for efficient retrieval of strings, especially useful for:

Auto-complete
Spell checking
Prefix search
Each node usually represents a single character of a word.

# What Makes Trie Efficient?
A Trie reduces time complexity for operations involving strings or prefixes by allowing you to share common prefixes across words and search character by character, rather than scanning full strings or using comparison-based methods.

Traditional String Storage Approaches
1. Array / List of Strings
To search for a word:

You might need to scan all elements, comparing full strings.

Worst-case: O(n × L) where:

n = number of words

L = average length per word

2. HashMap of Strings
Search: O(1) for exact match (hashing), but:

Prefix matching is inefficient → you’d have to scan all keys → O(n × L)

Memory use can grow with string length since the full key is stored.

3. Binary Search Tree (BST) of Strings
Search: O(log n) comparisons, but each comparison takes O(L) time (comparing full strings).

So total is O(L × log n)

| Operation                       | Time Complexity         | Explanation                                  |
| ------------------------------- | ----------------------- | -------------------------------------------- |
| **Insert**                      | O(L)                    | Traverse/create `L` nodes (1 per char)       |
| **Search**                      | O(L)                    | Traverse `L` nodes to find the word          |
| **Prefix Check** (`startsWith`) | O(L)                    | Same as search, but doesn't require word end |
| **Delete**                      | O(L)                    | Traverse `L` nodes, then cleanup (optional)  |
| **Space**                       | O(n × L × Σ) worst-case | Each node may branch into Σ children         |


# Trie Time Complexity
🧠 Trie stores characters one level at a time:
Each node represents one character.

You traverse only once per character → O(L) time.

No full string comparison required.

Shared prefixes reduce space & time on insert/search.

 Yes, exactly! In the best (and even average) case, a Trie saves a lot of time by avoiding the need to check every word individually.



# params passing 

When working with data structures like Tries, Binary Trees, or Graphs, you usually do not need to pass children, left, or right as constructor parameters — unless you have a special reason.

✅ Why You Don't Need to Pass left / right / children in Parameters:
Because you're typically going to link nodes after creating them, like this:

🔹 Binary Tree Example:

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;   // optional, Java does this by default
        this.right = null;
    }
}
Usage:


TreeNode root = new TreeNode(10);
root.left = new TreeNode(5);
root.right = new TreeNode(15);

You don’t need to pass left or right when creating root, because you’ll connect children later.