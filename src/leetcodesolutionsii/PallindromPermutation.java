
package leetcodesolutionsii;
import java.util.*;

public class PallindromPermutation
{
    public List<String> generatePalindromes(String s) 
    {
        List<String> fls = new ArrayList<>();
        int size = s.length();
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++)
        {
            if(set.contains(s.charAt(i)))
            {
                set.remove(s.charAt(i));
                sb.append(s.charAt(i));
            }
            else
            {
                set.add(s.charAt(i));
            }
        }
        boolean isOdd = false;
        char odd = 'i';
        if(set.size() > 1)
        {
            return fls;
        }
        else if(set.size() == 1)
        {
            odd = set.iterator().next();
            isOdd = true;
        }
        
        char[] arr = sb.toString().toCharArray();
        Permute(arr, fls, 0, isOdd, odd);
        return fls;
    }
    public void Permute(char[] arr, List<String> fls, int currIdx, boolean isOdd, char oddChar)
    {
        if(currIdx >= arr.length)
        {
            StringBuilder sb = new StringBuilder(new String(arr));
            if(isOdd)
            {
                sb.append(oddChar);
            }
            StringBuilder sb2 = new StringBuilder(new String(arr));
            sb2.reverse();
            sb.append(sb2);
            fls.add(sb.toString());
        }
        Set<Character> set = new HashSet<>();
        for (int i = currIdx; i < arr.length; i++)
        {
            if(i != currIdx && set.contains(arr[i]))
            {
                continue;
            }
            set.add(arr[i]);
            Swap(arr, i, currIdx);
            Permute(arr, fls, currIdx + 1, isOdd, oddChar);
            Swap(arr, i, currIdx);
        }
    }
    public void Swap(char[] arr, int i, int currIdx)
    {
        char temp = arr[i];
        arr[i] = arr[currIdx];
        arr[currIdx] = temp;
    }
}
