
package leetcodesolutionsii;
import java.util.*;
public class SumRootToLeafNumbers
{
    public int sumNumbers(TreeNode root) 
    {
        if(root == null)
        {
            return 0;
        }
        List<Integer> ls = new ArrayList<>();
        List<Integer> fls = new ArrayList<>();
        ReturnAllTheNumbers(root, ls, fls);
        int sum = 0;
        for(int i :  fls)
        {
            sum += i;
        }
        
        return sum;
    }
    public void ReturnAllTheNumbers(TreeNode root, List<Integer> ls, List<Integer> fls)
    {
        if(root.left == null && root.right == null)
        {
            ls.add(root.val);
            int size = ls.size() - 1;
            int number = 0;
            for(int i : ls)
            {
                number += i * Math.pow(10, size);
                size--;
            }
            ls.remove(ls.size() - 1);
        }
        ls.add(root.val);
        if(root.left != null)
        {
            ReturnAllTheNumbers(root.left, ls, fls);
        }
        if(root.right != null)
        {
            ReturnAllTheNumbers(root.right, ls, fls);
        }
        ls.remove(ls.size() - 1);
    }
}
