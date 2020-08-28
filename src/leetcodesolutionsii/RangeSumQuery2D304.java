
package leetcodesolutionsii;

public class RangeSumQuery2D304
{
    int[][] sumInter;
    int[][] nums;
    public RangeSumQuery2D304(int[][] num)
    {
        nums = new int[num.length][num[0].length];
        sumInter = new int[num.length][num[0].length];
        for(int i = 0; i < num.length; ++i)
        {
            for (int j = 0; j < num[0].length; j++)
            {
                nums[i][j] = num[i][j];
                sumInter[i][j] = num[i][j];
                if(j > 0)
                {
                    sumInter[i][j] = sumInter[i][j] + sumInter[i][j - 1];
                }
                if(i > 0)
                {
                    sumInter[i][j] = sumInter[i][j] + sumInter[i - 1][j];
                    if(isValid(i - 1, j - 1))
                    {
                        sumInter[i][j] -= sumInter[i - 1][j - 1];
                    }
                }
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) 
    {
        int sum = sumInter[row2][col2];
        int left = 0;
        int up = 0;
        if(isValid(row2, col1 - 1))
        {
            left = sumInter[row2][col1 - 1];
        }
        if(isValid(row1 -1, col2))
        {
            up = sumInter[row1 - 1][col2];
            if(isValid(row1 -1, col1 - 1))
            {
                up -= sumInter[row1 - 1][col1 - 1];
            }
        }
        return sum - up - left;        
    }
    public boolean isValid(int i, int j)
    {
        if(i < 0 || j < 0 || i >= sumInter.length || j >= sumInter[0].length)
        {
            return false;
        }
        return true;
    }
}
