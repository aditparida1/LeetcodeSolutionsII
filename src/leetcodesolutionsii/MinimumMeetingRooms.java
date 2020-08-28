
package leetcodesolutionsii;
import java.util.*;

public class MinimumMeetingRooms
{
    public int minMeetingRooms(int[][] intervals) 
    {
        if(intervals.length == 0)
        {
            return 0;
        }
        if(intervals.length == 1)
        {
            return 1;
        }
        Arrays.sort(intervals, new Comparator<int[]>() { 
            
          @Override
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            
            if (entry1[0] > entry2[0]) 
                return 1; 
            else
                return -1; 
          } 
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++)
        {
            if(pq.size() == 0)
            {
                pq.add(intervals[i][1]);
            }
            else
            {
                if(pq.peek() <= intervals[i][0])
                {
                    pq.poll();
                    pq.add(intervals[i][1]);
                }
                else
                {
                    pq.add(intervals[i][1]);
                }
            }
        }
        return pq.size();
    }    
}
