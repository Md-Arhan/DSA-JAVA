import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {
    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        if(map.containsKey(node)){
            return map.get(node);
        }

        Node clone = new Node(node.val, new ArrayList<>());
        map.put(node, clone);

        for(Node neigh : node.neighbors){
            clone.neighbors.add(cloneGraph(neigh));
        }

        return clone;
    }
}



/*
 * The map doesn't store the neighbor values or the val as a list.
It stores a mapping of original node reference → cloned node reference.
The actual neighbors list is empty at the time of cloning, but gets filled later during recursion or iteration.

 Yes, the neighbors list is updated after putting the clone in the HashMap, and it works because we're storing a reference to the clone.

 Yes, exactly.
It’s a data format, used for input/output, not a class or object.
It helps you visualize or pass the graph to a program or function.
Each element inside the outer bracket leads to constructing one Node object.
 */