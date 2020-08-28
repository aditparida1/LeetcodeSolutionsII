/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutionsii;

/**
 *
 * @author User
 */
public class FlattenTree
{
    public TreeNode flatten(TreeNode root)
    {
        if(root == null)
        {
            return null;
            
        }
        TreeNode lTail = flatten(root.left);
        TreeNode rTail = flatten(root.right);
        if(lTail != null)
        {
            lTail.right = root.right;
            root.right = lTail;
        }
        if(lTail == null && rTail == null)
        {
            return root;
        }
        if(rTail == null)
        {
            return lTail;
        }
        else
        {
            return rTail;
        }
        //return null;
    }
}
