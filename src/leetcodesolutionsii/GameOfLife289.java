
package leetcodesolutionsii;
import java.util.*;

public class GameOfLife289
{
    public void gameOfLife(int[][] board) 
    {
        if(board == null || board.length == 0 || board[0].length == 0)
        {
            return;
        }
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                int aliveCount = countAliveNeighbors(board, i, j);
                if(isAlive(board, i, j))
                {
                    if(aliveCount < 2 || aliveCount > 3)
                    {
                        board[i][j] = -2;
                    }
                }
                else
                {
                    if(aliveCount == 3)
                    {
                        board[i][j] = -1;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == -1)
                {
                    board[i][j] = 1;
                }
                if(board[i][j] == -2)
                {
                    board[i][j] = 0;
                }
            }
            
        }
        
    }
    public boolean isAlive(int[][] board, int row, int col)
    {
        if(board[row][col] == 1 || board[row][col] == -2)
        {
            return true;
        }
        return false;
    }
    public  int countAliveNeighbors(int[][] board, int row, int col)
    {
        // row - 1, col 
        // row, col + 1
        // row + 1, col
        // row, col - 1
        // row - 1, col - 1
        // row - 1, col + 1
        // row + 1, col + 1
        // row + 1, col - 1
        
        int count = 0;
        if(isValid(board, row - 1, col))
        {
            if(isAlive(board, row - 1, col))
            {
                count++;
            }
        }
        if(isValid(board, row, col + 1))
        {
            if(isAlive(board, row, col + 1))
            {
                count++;
            }
        }
        if(isValid(board, row + 1, col))
        {
            if(isAlive(board, row + 1, col))
            {
                count++;
            }
        }
        if(isValid(board, row, col - 1))
        {
            if(isAlive(board, row, col - 1))
            {
                count++;
            }
        }
        if(isValid(board, row - 1, col - 1))
        {
            if(isAlive(board, row - 1, col - 1))
            {
                count++;
            }
        }
        if(isValid(board, row - 1, col + 1))
        {
            if(isAlive(board, row - 1, col + 1))
            {
                count++;
            }
        }
        if(isValid(board, row + 1, col + 1))
        {
            if(isAlive(board, row + 1, col + 1))
            {
                count++;
            }
        }
        if(isValid(board, row + 1, col - 1))
        {
            if(isAlive(board, row + 1, col - 1))
            {
                count++;
            }
        }
        return count;
    }
    public boolean isValid(int[][] board, int row, int col)
    {
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length)
        {
            return false;
        }
        return true;
    }
}
