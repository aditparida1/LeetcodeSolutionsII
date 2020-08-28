
package leetcodesolutionsii;
import java.util.*;

public class NthUglyNumber
{
    public int nthUglyNumber(int n) 
    {
        if (n == 1)
        {
            return 1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(2);        
        pq.add(3); 
        pq.add(5);
        int i = 2;
        int temp = -1;
        Set<Integer> set = new HashSet<>();
        while(i <= n)
        {
            temp = pq.poll();
            if(!set.contains(temp * 2))
            {
                pq.add(temp * 2);
                set.add(temp * 2);
            }
            if(!set.contains(temp * 3))
            {
                pq.add(temp * 3);
                set.add(temp * 3);
            }
            if(!set.contains(temp * 5))
            {
                pq.add(temp * 5);
                set.add(temp * 5);
            }
            ++i;
        }
        return temp;
    }
}
