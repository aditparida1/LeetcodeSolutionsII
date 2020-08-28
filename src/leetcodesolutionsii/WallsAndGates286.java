
package leetcodesolutionsii;
import java.util.*;

public class WallsAndGates286
{
    public void wallsAndGates(int[][] rooms) 
    {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0)
        {
            return;
        }
        for(int i = 0; i < rooms.length; ++i)
        {
            for (int j = 0; j < rooms[0].length; j++)
            {
                if(rooms[i][j] == 0)
                {
                    BFS(rooms, i, j);
                }
            }
        }
    }
    public void BFS(int[][] matrix, int i, int j)
    {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        while(!q.isEmpty())
        {
            int[] currBox = q.poll();
            int row = currBox[0];
            int col = currBox[1];
            if(isValid(matrix, row - 1, col))
            {
                if(matrix[row - 1][col] != -1 && matrix[row - 1][col] != 0 && matrix[row][col] + 1 < matrix[row - 1][col])
                {
                    matrix[row - 1][col] = matrix[row][col] + 1;
                    q.add(new int[]{row - 1,col});
                }
            }
            if(isValid(matrix, row, col + 1))
            {
                if(matrix[row][col + 1] != -1 && matrix[row][col + 1] != 0 && matrix[row][col] + 1 < matrix[row][col + 1])
                {
                    matrix[row][col + 1] = matrix[row][col] + 1;
                    q.add(new int[]{row, col + 1});
                }
            }
            if(isValid(matrix, row + 1, col))
            {
                if(matrix[row + 1][col] != -1 && matrix[row + 1][col] != 0 && matrix[row][col] + 1 < matrix[row + 1][col])
                {
                    matrix[row + 1][col] = matrix[row][col] + 1;
                    q.add(new int[]{row + 1, col});
                }
                
            }
            if(isValid(matrix, row, col - 1))
            {
                if(matrix[row][col - 1] != -1 && matrix[row][col - 1] != 0 && matrix[row][col] + 1 < matrix[row][col - 1])
                {
                    matrix[row][col - 1] = matrix[row][col] + 1;
                    q.add(new int[]{row, col - 1});
                }
            }
        }
    }
    public boolean isValid(int[][] matrix, int row, int col)
    {
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length)
        {
            return false;
        }
        return true;
    }
}
