
package leetcodesolutionsii;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;



public class SurroundedRegions
{
    public void solve(char[][] board) 
    {
        if(board == null || board.length < 3 || board[0].length < 3)
        {
            return;
        }
        for (int i = 0; i < board[0].length; i++)
        {
            if(board[0][i] == 'O')
            {
                board[0][i] = '1';
                change(board, 0, i);
            }
            if(board[board.length - 1][i] == 'O')
            {
                board[board.length - 1][i] = '1';
                change(board, board.length - 1, i);
            }
        }
        for (int i = 0; i < board.length; i++)
        {
            if(board[i][0] == 'O')
            {
                board[i][0] = '1';
                change(board, i, 0);
            }
            if(board[i][board[0].length - 1] == 'O')
            {
                board[i][board[0].length - 1] = '1';
                change(board, i, board[0].length - 1);
            }
        }
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == 'O')
                {
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '1')
                {
                    board[i][j] = 'O';
                }
            }
            
        }
    }
    public void change(char[][] matrix, int row, int col)
    {
        Queue<int[]> queue = new LinkedList<>();
        int[] tup = {row,col};
        queue.add(tup);
        while(!queue.isEmpty())
        {
            int[] temp = queue.poll();
            matrix[temp[0]][temp[1]] = '1';
            row = temp[0];
            col = temp[1];
            if(isValid(matrix, row - 1, col))
            {
                if(matrix[row-1][col] == 'O')
                {
                    tup = new int[]{row - 1, col};
                    matrix[row - 1][col] = '1';
                    queue.add(tup);
                }
            }
            if(isValid(matrix, row + 1, col))
            {
                if(matrix[row+1][col] == 'O')
                {
                    tup = new int[]{row + 1, col};
                    matrix[row + 1][col] = '1';
                    queue.add(tup);
                }
            }
            if(isValid(matrix, row, col - 1))
            {
                if(matrix[row][col - 1] == 'O')
                {
                    tup = new int[]{row, col - 1};
                    matrix[row][col - 1] = '1';
                    queue.add(tup);
                }
            }
            if(isValid(matrix, row, col + 1))
            {
                if(matrix[row][col + 1] == 'O')
                {
                    tup = new int[]{row, col + 1};
                    matrix[row][col + 1] = '1';
                    queue.add(tup);
                }
            }
        }
    }
    public boolean isValid(char[][] matrix, int row, int col)
    {
        if(row >= 0  && col >= 0 && row < matrix.length && col < matrix[0].length)
        {
            return true;
        }
        return false;
    }
    
}
