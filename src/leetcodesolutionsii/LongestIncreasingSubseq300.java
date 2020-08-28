
package leetcodesolutionsii;


public class LongestIncreasingSubseq300
{
    public int lengthOfLIS(int[] nums) 
    {
        if(nums.length == 0)
        {
            return 0;
        }
        int max = 1;
        int[] dp = new int[nums.length];
        int globalMax = -1;
        for (int i = 0; i < nums.length; i++)
        {
            max = 1;
            for (int j = 0; j < i; j++)
            {
                if(nums[j] < nums[i])
                {
                    if(dp[j] + 1 > max)
                    {
                        max = dp[j] + 1;
                    }
                }
            }
            dp[i] = max;
            if(dp[i] > globalMax)
            {
                globalMax = dp[i];
            }
            
        }
        return globalMax;
    }
}
