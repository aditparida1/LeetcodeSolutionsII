

/*
cant modify the array
order of 1 in space complexity]
less than order of n^2
*/

package leetcodesolutionsii;
import java.util.*;

public class DuplicateNumber287
{
    public int findDuplicate(int[] nums) 
    {
        int x = binSearchDuplicates(new int[] {3,1,3,4,2});
        
        return 0;           
    }
    public int binSearchDuplicates(int[] nums)
    {
        int left = 1;
        int right = nums.length - 1;
        
        int mid = -1;
        while(left < right)
        {
            int less = 0;
            int greater = 0;
            mid = left + right;
            mid /= 2;
            for(int i  = 0; i < nums.length; ++i)
            {
                if(nums[i] < left || nums[i] > right)
                {
                    continue;
                }
                if(nums[i] <= mid)
                {
                    less ++;
                }
                else
                {
                    greater++;
                }
            }
            if(((right - left) + 1 )% 2 ==0)
            {
                if(less > greater)
                {
                    right = mid;
                }
                else
                {
                    left = mid + 1;
                }
            }
            else
            {
                if(less > greater + 1)
                {
                    right = mid;
                }
                else
                {
                    left = mid;
                }
            }
        }
        return left;
        
    }
}
