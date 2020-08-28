
package leetcodesolutionsii;
import java.util.*;


public class PermutationII
{
    //here we will get a nums array with duplicate numbers/integers. Permute such that no duplicate permutation exists
    
    public List<List<Integer>> permuteUnique(int[] nums) 
    {
        if(nums.length == 0)
        {
            return new ArrayList<>();
        }
        List<List<Integer>> fls = new ArrayList<>();
        permute(nums, fls, 0);
        return fls;        
    }
    public void permute(int[] ip, List<List<Integer>> fls, int pos)
    {
        if(pos >= ip.length)
        {
            ArrayList<Integer> ls = new ArrayList<>();
            for (int i = 0; i < ip.length; i++)
            {                
                ls.add(ip[i]);
            }
            fls.add(ls);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = pos; i < ip.length; i++)
        {
            if(i != pos && set.contains(ip[i]))
            {
                continue;
            }
            set.add(ip[i]);
            Swap(ip, i, pos);
            permute(ip, fls, pos + 1);
            Swap(ip, i, pos);
        }
    }
    public static void Swap(int ip[], int i, int pos)
    {
        int temp = ip[i];
        ip[i] = ip[pos];
        ip[pos] = temp;
    }
}
