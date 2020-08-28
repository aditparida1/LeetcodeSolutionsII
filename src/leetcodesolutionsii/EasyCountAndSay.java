
package leetcodesolutionsii;
import java.util.*;

public class EasyCountAndSay
{
    public String countAndSay(int n) 
    {
        if(n>5)
        {
            String[] series = new String[n];
            series[0] = "1";
            series[1] = "11";
            series[2] = "21";
            series[3] = "1211";
            series[4] = "111221";
            
            for (int i = 5; i < n; i++)
            {
                String prev = series[i - 1];
                StringBuilder sb = new StringBuilder();
                char currChar = prev.charAt(0);
                int currCount = 1;
                for (int j = 1; j < prev.length(); j++)
                {
                    if(currChar == prev.charAt(j))
                    {
                        currCount++;
                    }
                    else
                    {
                        sb.append(Integer.toString(currCount));
                        sb.append(Character.toString(currChar));                        
                        currChar = prev.charAt(j);
                        currCount = 1;
                    }
                }
                sb.append(Integer.toString(currCount));
                sb.append(Character.toString(currChar)); 
                series[i] = sb.toString();
            }
            return series[n - 1];
        }
        else
        {
            String[] series = new String[5];
            series[0] = "1";
            series[1] = "11";
            series[2] = "21";
            series[3] = "1211";
            series[4] = "111221";
            return series[n - 1];
        }
        
        
        //return null;
    }    
    
}
