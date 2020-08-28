
package leetcodesolutionsii;
import java.util.*;

public class VerifyPreOrder
{
    public boolean verifyPreorder(int[] preorder) 
    {
        if(preorder.length <= 2)
            return true;
        return verifyPreorderHelper(preorder, 0, preorder.length - 1);
        //return false;        
    }
    private boolean verifyPreorderHelper(int[] preorder, int start, int end)
    {
        if(start >= end)
        {
            return true;
        }
        else
        {
            int subTree = start + 1;
            boolean isGreterencountered = false;
            int mid = -1;
            for(int i = subTree; i <= end; ++i)
            {
                if(preorder[i] > preorder[start])
                {
                    if(!isGreterencountered)
                    {
                        mid = i;
                    }
                    isGreterencountered = true;
                }
                else
                {
                    if(isGreterencountered)
                    {
                        return false;
                    }
                }
            }
            if(mid == -1)
            {
                //there is no right tree
                mid = end + 1;
            }
            boolean left = verifyPreorderHelper(preorder, subTree, mid - 1);
            if(!left)
                return left;
            boolean right = verifyPreorderHelper(preorder, mid, end);
            if(!right)
                return right;
            return true;
        }
    }
}
