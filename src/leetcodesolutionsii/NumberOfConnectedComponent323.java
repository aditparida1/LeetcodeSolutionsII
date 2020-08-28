/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutionsii;
import java.util.*;
/**
 *
 * @author aditp
 */
public class NumberOfConnectedComponent323
{
    public int countComponents(int n, int[][] edges) 
    {
        if(n == 0)
        {
            return 0;
        }
        int[] visited = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++)
        {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        int count = 0;
        for(int i = 0; i < visited.length; ++i)
        {
            if(visited[i] == 2)
            {
                continue;
            }
            count++;
            countWithDFS(map, i, visited);
        }
        return count;
    }
    public void countWithDFS(Map<Integer, List<Integer>> map, int node, int[] visited)
    {
        if(visited[node] == 2)
        {
            return;
        }
        visited[node] = 1;
        List<Integer> neigh = map.get(node);
        for(int neighNode: neigh)
        {
            if(visited[neighNode] == 1)
                continue;
            countWithDFS(map, neighNode, visited);
        }
        visited[node] = 2;
    }
}
