
package leetcodesolutionsii;
import java.util.*;


public class VersionCompare165
{
    public int compareVersion(String version1, String version2) 
    {
        String[] version1Arr = version1.split("\\.");
        String[] version2Arr = version2.split("\\.");
        int[] ip1 = new int[version1Arr.length];
        int[] ip2 = new int[version2Arr.length];
        for (int i = 0; i < ip1.length; i++)
        {
            ip1[i] = Integer.parseInt(version1Arr[i]);
        }
        for (int i = 0; i < ip2.length; i++)
        {
            ip2[i] = Integer.parseInt(version2Arr[i]);
        }
        return compareVersions(ip1, ip2);
    }
    public int compareVersions(int[] a, int[] b)
    {
        
        int len = a.length < b.length ? a.length : b.length;
        for (int i = 0; i < len; i++)
        {
            if(a[i] == b[i])
            {
                continue;
            }
            else if(a[i] < b[i])
            {
                return -1;
            }
            else
            {
                return 1;
            }
        }
        if(a.length < b.length)
        {
            for (int i = a.length; i < b.length; i++)
            {
                if(b[i] == 0)
                {
                    continue;
                }
                else
                {
                    return -1;
                }
            }
        }
        else if(a.length > b.length)
        {
            for (int i = b.length; i < a.length; i++)
            {
                if(a[i] == 0)
                {
                    continue;
                }
                else
                {
                    return 1;
                }
            }
        }
        return 0;
    }
    
}
