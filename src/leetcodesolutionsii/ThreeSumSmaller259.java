
package leetcodesolutionsii;
import java.util.*;

public class ThreeSumSmaller259
{
    public int threeSumSmaller(int[] nums, int target) 
    {
        if(nums.length < 3)
        {
            return 0;
        }
        int count = 0;
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
        {
            int l = i + 1;
            int r = nums.length;
            while(l < r)
            {
                if(nums[l] + nums[r] + nums[i] < target)
                {
                    count += (r - l);
                    l++;
                }
                else
                {
                    r--;
                }
            }
        }
        return count;
    }
}
