/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutionsii;
import java.util.*;
/**
 *
 * @author User
 */
public class DiffWaysToComp
{
    public List<Integer> Compute(String exp)
    {
        if(exp.trim().isEmpty())
        {
            return new ArrayList<Integer>();
        }
        List<Integer> ls = new ArrayList<Integer>();
        boolean isOP = false;
        for(int i = 0; i < exp.length(); ++i)
        {
            if(exp.charAt(i) == '*' || exp.charAt(i) == '-' || exp.charAt(i) == '+')
            {
                String left = exp.substring(0, i);
                String right = exp.substring(i + 1, exp.length());
                List<Integer> l = Compute(left);
                List<Integer> r = Compute(right);
                for(int a : l)
                {
                    for(int b : r)
                    {
                        ls.add(applyOp(Character.toString(exp.charAt(i)), a, b));
                    }
                }
                isOP = true;
            }
        }
        if(!isOP)
        {
            ls.add(Integer.parseInt(exp)); 
        }
        return ls;
    }
    public int applyOp(String op, int a, int b)
    {
        if("+".equals(op))
        {
            return a + b;            
        }
        if("*".equals(op))
        {
            return a * b;            
        }
        if("-".equals(op))
        {
            return a - b;            
        }
        return 0;
    }
}
