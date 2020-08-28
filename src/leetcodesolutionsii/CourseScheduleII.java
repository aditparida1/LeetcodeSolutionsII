
package leetcodesolutionsii;

import java.util.*;

public class CourseScheduleII 
{
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        
        if(prerequisites.length == 0)
        {
            int[] num = new int[numCourses];
            for (int i = 0; i < num.length; i++) {
                num[i] = i;
            }
            return num;
        }
        List<List<Integer>> gList = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++)
        {
            gList.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++)
        {
            gList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] visited = new int[numCourses];
        int[] num = new int[]{0};
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < visited.length; ++i)
        {
            if(visited[i] == 0)
            {
                boolean b = isPossible(map, visited, gList, i, num);
                if(!b)
                {
                    return new int[]{};
                }
                visited[i] = 2;
                map.put(num[0], i);
                num[0]++;
            }
        }
        
        for (int i = 0; i < map.size(); i++) 
        {
            int currNode = map.get(i);
            visited[i] = currNode;
        }
        return visited;
    }
    public boolean isPossible(Map<Integer, Integer> map, int[] visited, List<List<Integer>> ls, int node, int[] num)
    {
        List<Integer> list = ls.get(node);
        for(int i : list)
        {
            if(visited[i] == 1)
            {
                return false;
            }
            if(visited[i] == 2)
            {
                continue;
            }
            visited[i] = 1;
            boolean b = isPossible(map, visited, ls, i, num);
            if(!b)
            {
                return false;
            }
            map.put(num[0], i);
            num[0]++;
            visited[i] = 2;
        }
        
        return true;
    }
    
}

