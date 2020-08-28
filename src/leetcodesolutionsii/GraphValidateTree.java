
package leetcodesolutionsii;
import java.util.*;

public class GraphValidateTree
{
        public boolean validTree(int n, int[][] edges) 
        {
            if(n < 2 || edges.length == 0)
            {
                return true;
            }
            Map<Integer, List<Integer>> map = new HashMap<>();
            for(int i = 0; i < edges.length; ++i)
            {
                if(map.containsKey(edges[i][0]))
                {
                    map.get(edges[i][0]).add(edges[i][1]);
                }
                else
                {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(edges[i][1]);
                    map.put(edges[i][0], ls);
                }
                if(map.containsKey(edges[i][1]))
                {
                    map.get(edges[i][1]).add(edges[i][0]);
                }
                else
                {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(edges[i][0]);
                    map.put(edges[i][1], ls);
                }
            }
            int[] visited = new int[n];


            int startNode = 0;
            for (int i = 0; i < visited.length; i++)
            {
                if(map.containsKey(i))
                {
                    startNode = i;
                    break;
                }
            }
            if(!validateWithDFS(map, startNode, visited))
            {
                return false;
            }
            for (int i = 0; i < visited.length; i++)
            {
                if(visited[i] == 0)
                return false;
            }

            return true;
        }

        private boolean validateWithDFS(Map<Integer, List<Integer>> map, int i, int[] visited)
        {
            if(visited[i] == 2)
            {
                return false;
            }
            visited[i] = 1;
            List<Integer> neigh = map.get(i);
            for(int node: neigh)
            {
                if(visited[node] == 1)
                {
                    continue;
                }
                if (!validateWithDFS(map, node, visited))
                {
                    return false;
                }
            }
            visited[i] = 2;
            return true;
        }
}
