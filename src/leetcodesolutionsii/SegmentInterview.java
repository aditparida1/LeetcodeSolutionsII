
package leetcodesolutionsii;
import java.util.*;


public class SegmentInterview
{
    public int segmentMax(int[] arr, int x)
    {
        
        int minMax = arr[0];
        
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < x; i++)
        {
            if(tm.containsKey(arr[i]))
            {
                tm.put(arr[i] , tm.get(arr[i]) + 1);
            }
            else
            {
                tm.put(arr[i], 1);
            }
        }
        minMax = tm.firstKey();
        for (int i = x; i < arr.length; i++)
        {
            if(tm.containsKey(arr[i - x]))
            {
                tm.put(arr[i - x], tm.get(arr[i - x]) - 1);
                if(tm.get(arr[i - x]) <= 0)
                {
                    tm.remove(arr[i - x]);
                }
            }
            if(tm.containsKey(arr[i]))
            {
                tm.put(arr[i - x], tm.get(arr[i - x]) + 1);
                
            }
            else
            {
                tm.put(arr[i - x], 1);
            }
            if(tm.firstKey() > minMax)
            {
                minMax = tm.firstKey();
            }
        }
        return minMax;
    }
}
