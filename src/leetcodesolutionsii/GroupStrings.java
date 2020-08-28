
package leetcodesolutionsii;
import java.util.*;

public class GroupStrings
{
    public List<List<String>> groupStrings(String[] strings) 
    {
        List<List<String>> fls = new ArrayList<>();
        Hashtable<String, Integer> ht = new Hashtable<>();
        Arrays.sort(strings);
        for (int i = 0; i < strings.length; i++)
        {
            if(!ht.containsKey(strings[i]))
            {
                ht.put(strings[i], 1);
            }
            else
            {
                ht.put(strings[i], ht.get(strings[i]) + 1);
            }
        }
        for (int i = 0; i < strings.length; i++)
        {
            if(ht.get(strings[i]) == 0)
            {
                continue;
            }
            String ipa = strings[i];
            List<String> ls = new ArrayList<>();
            
            for (int j = i + 1; j < strings.length; j++)
            {
                
                String ipb = strings[j];
                if(ht.get(ipb) == 0)
                {
                    continue;
                }
                if(isSameSeq(ipa, ipb))
                {
                    ls.add(ipb);
                    ht.put(ipb, ht.get(ipb) - 1);
                }
            }
            ls.add(ipa);
            ht.put(ipa, ht.get(ipa) - 1);
            fls.add(ls);
        }
        return fls;
    }
    public boolean isSameSeq(String ipa, String ipb)
    {
        if(ipa.length() != ipb.length())
        {
            return false;
        }
        if(ipa.length() == 0 || ipa.length() == 1)
        {
            return true;
        }
        int dis = ipb.charAt(0) - ipa.charAt(0);
        for (int i = 1; i < ipa.length(); i++)
        {
            int newCharAscii = ipa.charAt(i) + dis;
            if(newCharAscii > 122)
            {
                int temp = newCharAscii - 122;
                newCharAscii = 96 + temp;
            }
            char newChar = (char)newCharAscii;
            if(newChar != ipb.charAt(i))
            {
                return false;
            }
        }
        return true;
    }
}
