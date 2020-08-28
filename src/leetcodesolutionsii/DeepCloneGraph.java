
package leetcodesolutionsii;
import java.util.*;

public class DeepCloneGraph 
{
    
    public Node cloneGraph(Node node) 
    {
        Map<Integer, Node> map = new HashMap<>();
        Set<Integer> st = new HashSet<>();
        Node temp = new Node(node.val);
        map.put(temp.val, temp);
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty())
        {
            Node curr = q.poll();
            List<Node> adj = curr.neighbors;
            Node copyCurr = map.get(curr.val);
            for(Node neigh : adj)
            {
                if(map.containsKey(neigh.val))
                {
                    Node temp2 = map.get(neigh.val);
                    copyCurr.neighbors.add(temp2);                    
                }
                else
                {
                    Node temp2 = new Node(neigh.val);
                    map.put(neigh.val, temp2);
                    copyCurr.neighbors.add(temp2);
                    q.add(neigh);
                }
            }
        }
        return temp;
    }
    
}
