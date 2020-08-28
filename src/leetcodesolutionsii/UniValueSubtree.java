package leetcodesolutionsii;

public class UniValueSubtree
{
    int count;
    public int countUnivalSubtrees(TreeNode root) 
    {
        count = 0;
        if(root == null)
        {
            return 0;
        }
        else
        {
            countUnivalSubTreeHelper(root);
        }
        return count;
    }
    public boolean countUnivalSubTreeHelper(TreeNode root)
    {
        if(root == null)
        {
            return true;
        }
        boolean leftTree = countUnivalSubTreeHelper(root.left);
        boolean rightTree = countUnivalSubTreeHelper(root.right);
        
        if(leftTree && rightTree)
        {
            if(root.left == null && root.right == null)
            {
                count++;
                return true;
            }
            if(root.left != null && root.right != null && root.left.val == root.right.val && root.left.val == root.val)
            {
                count++;
                return true;
            }
            if(root.left == null && root.right.val == root.val)
            {
                count++;
                return true;
            }
            if(root.right == null && root.left.val == root.val)
            {
                count++;
                return true;
            }
        }
        return false;
    }
}
