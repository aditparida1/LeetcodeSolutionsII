
package leetcodesolutionsii;
import java.util.*;

public class LeetcodeSolutionsII
{
    public static void main(String[] args)
    {
        
        int[][] num = {
            {3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}
        };
        RangeSumQuery2D304 obj = new RangeSumQuery2D304(num);
        
    }
    public boolean wordPattern(String pattern, String str) 
    {
        str = str.trim();
        Map<Character, String> map = new HashMap<>();
        String[] split = str.split(" ");
        if(pattern.length() != str.length())
        {
            return false;
        }
        
        for(int i = 0; i < str.length(); ++i)
        {
            char currChar = pattern.charAt(i);
            String currStr = split[i];
            if(map.containsKey(currChar))
            {
                if(!currStr.equals(map.get(currChar)))
                {
                    return false;
                }
            }
            else if(map.containsValue(currStr))
            {
                return false;
            }
            else
            {
                map.put(currChar, currStr);
            }
        }
        return true;
        
    }
}


class A
{
    public int[] art;
    public A()
    {
        art = new int[]{1,2};
    }
    public void doit()
    {
        System.out.println("A");
    }
    public void dothis()
    {
        
    }
    
}

class B extends A
{
    @Override
    public void doit()
    {
        System.out.println("B");
    }
    public void dothat()
    {
        
    }
}
