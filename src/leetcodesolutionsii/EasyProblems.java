
package leetcodesolutionsii;
import java.util.*;

public class EasyProblems
{
    public int[] plusOne(int[] digits) 
    {
        List<Integer> ls = new ArrayList<>();
        int carry = 1;
        for (int i = digits.length - 1; i >= 0 ; i--)
        {
            int currDigit = digits[i];
            currDigit += carry;
            if(currDigit >= 10)
            {
                currDigit = currDigit % 10;
                carry = 1;
            }
            else
            {
                carry = 0;
            }
            ls.add(currDigit);
        }
        if(carry != 0)
        {
            ls.add(carry);
            
        }
        int[] newNum = new int[ls.size()];
        for (int i = ls.size() - 1; i >= 0; i--)
        {
            newNum[ls.size() - i - 1] = ls.get(i);
        }
        return newNum;
    }
    public String addBinary(String a, String b) 
    {
        StringBuilder sb = new StringBuilder();
        int lena;
        int lenb;
        lena = a.length();
        lenb = b.length();
        int diff = Math.abs(lena - lenb);
        if(lena > lenb)
        {
            StringBuilder stb = new StringBuilder();
            for (int i = 0; i < diff; i++)
            {
                stb.append("0");
            }
            stb.append(b);
            b = stb.toString();
        }
        else if(lenb > lena)
        {
            StringBuilder sta = new StringBuilder();
            for (int i = 0; i < diff; i++)
            {
                sta.append("0");
            }
            sta.append(a);
            a = sta.toString();
        }
        List<Character> ls = new ArrayList<>();
        char carryChar = '0';
        for (int i = a.length() - 1; i >= 0; i--)
        {
            int count = 0;
            char achar = a.charAt(i);
            char bchar = b.charAt(i);
            char resChar = '0';
            if(achar == '1')
            {
                count++;
            }
            if(bchar == '1')
            {
                count++;
            }
            if(carryChar == '1')
            {
                count++;
            }
            if(count == 0)
            {
                carryChar = '0';
                resChar = '0';
            }
            else if(count == 1)
            {
                carryChar = '0';
                resChar = '1';
            }
            else if(count == 2)
            {
                carryChar = '1';
                resChar = '0';
            }
            else
            {
                carryChar = '1';
                resChar = '1';
            }
            ls.add(resChar);
        }
        if(carryChar == '1')
        {
            ls.add(carryChar);
        }
        for (int i = ls.size() - 1; i >= 0; i--)
        {
            sb.append(ls.get(i));
        }
        return sb.toString();
    }
    
    public int shortestDistance(String[] words, String word1, String word2) 
    {
        String currWord = "";
        int currIdx = -1;
        int minLen = -1;
        for (int i = 0; i < words.length; i++)
        {
            if(words[i].equals(word1) || words[i].equals(word2))
            {
                if(currWord.isEmpty())
                {
                    currWord = words[i];
                    currIdx = i;
                }
                else
                {
                    if(currWord.equals(words[i]))
                    {
                        currIdx = i;
                    }
                    else
                    {
                        int dis = Math.abs(currIdx - i);
                        if(minLen == -1)
                        {
                            minLen = dis;
                        }
                        else if(dis < minLen)
                        {
                            minLen = dis;
                        }
                        currWord = words[i];
                        currIdx = i;
                    }
                }
            }
        }
        return minLen;
    }
    
    public int majorityElement(int[] nums) 
    {
        if(nums.length == 1)
        {
            return nums[0];
        }
        int currMaj = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++)
        {
            if(nums[i] == currMaj)
            {
                count++;
            }
            else
            {
                count--;
                if(count < 0)
                {
                    currMaj = nums[i];
                    count = 1;
                }
            }
        }
        return currMaj;
    }
    public int titleToNumber(String s) 
    {
        s = s.toUpperCase();
        int total = 0;
        int len = s.length();
        for (int i = 1; i < len; i++)
        {
            total += Math.pow(26, i);
        }
        for (int i = 0; i < len - 1; i++)
        {
            char currChar = s.charAt(i);
            int pow = len - i - 1;
            int dis = currChar - 'A';
            total += dis * Math.pow(26, pow);
        }
        char currChar = s.charAt(len - 1);
        int dis = currChar - 'A' + 1;
        total += dis;
        return total;
    }
    public int trailingZeroes(int n) 
    {
        int numOfTwo = 0;
        int numOfFive = 0;
        for (int i = 1; i <= n; i++)
        {
            numOfTwo += howMany(i, 2);
            numOfFive += howMany(i, 5);
        }
        return numOfFive < numOfTwo ? numOfFive : numOfTwo;
    }
    public int howMany(int n, int num)
    {
        int count = 0;
        while(n > 0)
        {
            if(n % num == 0)
            {
                count++;
                n /= num;
            }
            else
            {
                return count;
            }
        }
        return count;
    }
    public void rotate(int[] nums, int k) 
    {
        k = k % nums.length;
        rev(nums);
        int l = 0;
        int r = k - 1;
        while(l < r)
        {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        l = k;
        r = nums.length - 1;
        while(l < r)
        {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
    public void rev(int[] nums)
    {
        int l = 0;
        int r = nums.length - 1;
        while(l < r)
        {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        
    }
    public boolean isIsomorphic(String s, String t) 
    {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(map.containsKey(sChar))
            {
                if(map.get(sChar) != tChar)
                {
                    return false;
                }
            }
            else
            {
                if(map.containsValue(tChar))
                {
                    return false;
                }
                else
                {
                    map.put(sChar, tChar);
                }
            }
        }
        return true;
    }
    public boolean isPalindrome(ListNode head) 
    {
        if(head == null)
        {
            return true;
        }
        int size = size(head);
        ListNode half = head;
        if(size % 2 == 0)
        {
            int steps = size / 2;
            while(steps > 0)
            {
                half = half.next;
                steps--;
            }
        }
        else
        {
            int steps = size / 2 + 1;
            while(steps  > 0)
            {
                half = half.next;
                steps--;
            }
        }
        while(half != null)
        {
            if(half.val != head.val)
            {
                return false;
            }
        }
        return true;
    }
    public int size(ListNode head)
    {
        int count = 0;
        while(head!=null)
        {
            count += 1;
        }
        return count;  
    }
    public boolean canConstruct(String ransomNote, String magazine) 
    {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < magazine.length(); ++i)
        {
            if(map.containsKey(magazine.charAt(i)))
            {
                map.put(magazine.charAt(i), map.get(magazine.charAt(i)) + 1);
            }
            else
            {
                map.put(magazine.charAt(i), 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++)
        {
            if(!map.containsKey(ransomNote.charAt(i)))
            {
                return false;
            }
            else
            {
                map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
                if(map.get(ransomNote.charAt(i)) < 0)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
}
