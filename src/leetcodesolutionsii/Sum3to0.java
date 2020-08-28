
package leetcodesolutionsii;
import java.util.*;

public class Sum3to0
{
    public List<List<Integer>> threeSum(int[] nums) 
    {
        if(nums == null || nums.length < 3)
        {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> fls = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
        {
            if(i > 0)
            {
                while(nums[i] == nums[i - 1])
                {
                    i++;
                }
            }
            if(i >= nums.length)
            {
                break;
            }
            int l = i + 1;
            int r = nums.length - 1;
            int currSum = nums[i];
            while(l < r)
            {
                currSum = currSum + nums[l] + nums[r];
                if(currSum < 0)
                {
                    l++;
                }
                else if(currSum > 0)
                {
                    r--;
                }
                else
                {
                    List<Integer> ls = new ArrayList<Integer>();
                    ls.add(nums[i]);
                    ls.add(nums[l]);
                    ls.add(nums[r]);
                    fls.add(ls);
                    l++;
                    r--;
                    for (; l < nums.length; l++)
                    {
                        if(nums[l] != nums[l - 1])
                        {
                            break;
                        }
                    }
                    for (; r > i; r--)
                    {
                        if(nums[r] != nums[r + 1])
                        {
                            break;
                        }
                    }
                }
                currSum = nums[i];
            }
        }
        
        return fls;
    }
}
