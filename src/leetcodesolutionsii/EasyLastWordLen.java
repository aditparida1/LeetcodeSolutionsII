/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutionsii;

/**
 *
 * @author User
 */
public class EasyLastWordLen
{
    public int lengthOfLastWord(String s) 
    {
        String ip = s.trim();
        int len = ip.length();
        if(len == 0 )
        {
            return 0;
        }
        for (int i = len - 1; i >= 0; i--)
        {
            if(ip.charAt(i) == ' ')
            {
                return len - 1 - i;
            }
        }
        return len;        
    }
}
