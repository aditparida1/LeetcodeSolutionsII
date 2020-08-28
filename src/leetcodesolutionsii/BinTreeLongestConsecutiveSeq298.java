
package leetcodesolutionsii;
import java.util.*;

public class BinTreeLongestConsecutiveSeq298
{
    int longest = 0;
    public int longestConsecutive(TreeNode root) 
    {
        longest = 0;
        traverseTree(root, null);
        return longest;
    }
    public void traverseTree(TreeNode root, Stack<Integer> st)
    {
        if(root == null)
        {
            return;
        }
        if(st == null || isSeq(st, root.val))
        {
            //longest = 0;
            if(st == null)
            st = new Stack<Integer>();
            st.add(root.val);
            if(longest < st.size())
            {
                longest = st.size();
            }
            traverseTree(root.left, st);
            traverseTree(root.right, st);
            st.pop();
        }
        else
        {
            Stack<Integer> st2 = new Stack<>();
            st2.add(root.val);
            if(st2.size() > longest)
            {
                longest = st2.size();
            }
            traverseTree(root.left, st2);
            traverseTree(root.right, st2);
            st2.pop();
        }
        
        
    }
    public boolean isSeq(Stack<Integer> st, int key)
    {
        if(st.size() == 0 || key - 1 == st.peek())
        {
            return true;
        }
        return false;
    }
}
