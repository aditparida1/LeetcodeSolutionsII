
package leetcodesolutionsii;
import java.util.*;

public class GasStation 
{
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
        int gasSum = 0;
        int costSum = 0;
        int[] residue = new int[gas.length];
        
        for(int i =0; i <  gas.length;++i)
        {
            gasSum += gas[i];
            costSum += cost[i];
            residue[i] = gas[i] - cost[i];
        }
        if(gasSum < costSum)
        {
            return -1;
        }
        for (int i = 0; i < residue.length; i++) 
        {
            if(residue[i] >= 0)
            {
                boolean isPoss = check(residue, i);
                if(isPoss)
                {
                    return i;
                }
            }
        }
        return -1;
    }
    public boolean check(int[] residue, int index)
    {
        int sum = residue[index];
        int i = increament(residue, index);
        while(i != index)
        {
            sum += residue[i];
            if(sum < 0)
            {
                return false;
            }
            i = increament(residue, i);
        }
        return true;
    }
    public int increament(int[] arr, int index)
    {
        if(index + 1 >= arr.length)
        {
            return 0;
        }
        else
        {
            return index + 1;
        }
    }
}
