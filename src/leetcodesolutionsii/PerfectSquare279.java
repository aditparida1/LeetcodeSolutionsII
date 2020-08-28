
package leetcodesolutionsii;
import java.util.*;



public class PerfectSquare279
{
    public int numSquares(int n) 
    {
        if(n <= 0)
        {
            return 0;
        }
        if(n == 1)
        {
            return 1;
        }
        int[] dp = new int[n + 1];
        
        for (int i = 0; i < n + 1; i++)
        {
            if(i == 0)
            {
                dp[i] = 0;
            }
            else
            dp[i] = i;
        }
        
        int sqrt = (int)Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++)
        {
            int sq = i * i;
            for (int j = 1; j < n + 1; j++)
            {
                int req = j / sq;
                int rem = j % sq;
                dp[j] = min(dp[j], req + dp[rem]);
            }
        }
        return dp[dp.length - 1];
    }
    private int min(int a, int b)
    {
        return a < b ? a : b;
    }
}
