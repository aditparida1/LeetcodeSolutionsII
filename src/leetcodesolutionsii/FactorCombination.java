/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutionsii;
import java.util.*;
/**
 *
 * @author aditp
 */
public class FactorCombination
{
    public List<List<Integer>> getFactors(int n) 
    {
        List<List<Integer>> fls = new ArrayList<>();
        
        int[] factors = allPrimeFactors(n);
        if(factors.length == 0)
        {
            return fls;
        }
        List<Integer> ls = new ArrayList<>();
        comboFactorsHelper(factors, 1, 0, 0, 1, ls, fls, n);
        
        return fls;
    }
    public void comboFactorsHelper(int[] arr, int size, int currIdx, int curSize, 
            int currTotal, List<Integer> ls, List<List<Integer>> fls, int num)
    {
        if(currTotal == num)
        {
            List<Integer> temp = new ArrayList<>();
            for(int i: ls)
            {
                temp.add(i);
            }
            fls.add(temp);
            
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = currIdx; i < arr.length; i++)
        {
            if(currTotal * arr[i] <= num)
            {
                set.add(arr[i]);
                ls.add(arr[i]);
                comboFactorsHelper(arr, size, i, curSize + 1, currTotal * arr[i], ls, fls, num);
                ls.remove(ls.size() - 1);
            }
        }
    }
    public int[] allPrimeFactors(int num)
    {
        List<Integer> ls = new ArrayList<>();
        int temp = num;
        for(int i = 2; i <= num / 2; ++i)
        {
            if(num % i == 0)
            {
                ls.add(i);
            }
        }
        int[] list = new int[ls.size()];
        for(int i = 0; i < ls.size(); ++i)
        {
            list[i] = ls.get(i);
        }
        return list;
    }
}
