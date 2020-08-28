/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutionsii;

/**
 *
 * @author aditp
 */
public class CalorieToday {
    public boolean isPossibel(int[] days, int target)
    {
        if(days == null || days.length ==0)
        {
            if(target != 0)
                return false;
            else
                return true;
        }
        return isPoss(days, target, 0, 0);
    }
    public boolean isPoss(int[] days, int target, int currSum, int index)
    {
        if(currSum == target)
        {
            return true;
        }
        if(index >= days.length)
        {
            return false;
        }
        if(currSum > target)
        {
            return false;
        }
        boolean today = isPoss(days, target, currSum + days[index], index + 1);
        if(today == true)
            return true;
        boolean noToday = isPoss(days, target, currSum, index + 1);
        if(noToday == true)
        {
            return true;
        }
        return false;
    }
}
