/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutionsii;
import java.util.*;
/**
 *
 * @author aditp
 */
public class BoundaryNodes 
{
    public List<Integer> boundaryOfBinaryTree(TreeNode root) 
    {
        List<Integer> ls = new ArrayList<>();
        if(root == null)
        {
            return ls;
        }
        if(root.left == null && root.right == null)
        {
            ls.add(root.val);
            return ls;
        }
        ls.add(root.val);
        if(root.left != null)
        {
            boundaryleft(root.left, ls);
        }
        leaves(root, ls);
        if(root.right != null)
        {
            boundaryRight(root.right, ls);
        }
        return ls;
    }
    
    public void boundaryleft(TreeNode root, List<Integer> ls)
    {
        if(root.left != null || root.right != null)
        {
            ls.add(root.val);
        }
        if(root.left != null)
        {
            boundaryleft(root.left, ls);
        }
        else if(root.right != null)
        {
            boundaryleft(root.right, ls);
        }
    }
    public void leaves(TreeNode root, List<Integer> ls)
    {
        if(root.left == null && root.right == null)
        {
            ls.add(root.val);
            return;
        }
        if(root.left != null)
        {
            leaves(root.left, ls);
        }
        else if(root.right != null)
        {
            leaves(root.right, ls);
        }
    }
    public void boundaryRight(TreeNode root, List<Integer> ls)
    {
        if(root.right != null)
        {
            boundaryRight(root.right, ls);
        }
        else if(root.left != null)
        {
            boundaryRight(root.left, ls);
        }
        if(root.left != null || root.right != null)
        {
            ls.add(root.val);
        }
    }
    
}
