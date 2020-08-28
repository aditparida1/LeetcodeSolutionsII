
package leetcodesolutionsii;
import java.util.*;

public class Subsets
{
    public List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>> fls = new ArrayList<>();
        if(nums == null || nums.length == 0)
        {
            fls.add(new ArrayList<>());
            return fls;
        }
        for (int i = 0; i <= nums.length; i++)
        {
            List<Integer> ls = new ArrayList<>();
            helper(nums, i, 0, 0, ls, fls);
        }
        return fls;
    }
    public void helper(int[] nums, int setSize, int currSize, int index, List<Integer> ls, List<List<Integer>> fls)
    {
        if(currSize >= setSize)
        {
            List<Integer> temp = new ArrayList<Integer>();
            for(int i : ls)
            {
                temp.add(i);
            }
            fls.add(temp);
            return;
        }
        if(index >= nums.length)
        {
            return;
        }
        
        for (int i = index; i < nums.length; i++)
        {
            ls.add(nums[i]);
            helper(nums, setSize, currSize + 1, i + 1, ls, fls);
            ls.remove(ls.size() - 1);
        }
        
    }
}
