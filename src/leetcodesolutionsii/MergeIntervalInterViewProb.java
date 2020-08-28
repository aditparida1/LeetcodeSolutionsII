
package leetcodesolutionsii;
import java.util.*;
/**
 *
 * @author User
 */

public class MergeIntervalInterViewProb {
    /*public int MaxDist(int[] start, int[] finish, int n)
    {
        int[][] intervals = new int[start.length][2];
        for (int i = 0; i < start.length; i++)
        {
            intervals[i][0] = start[i];
            intervals[i][1] = finish[i];
            
        }
        int[][] merged = merge(intervals);
        int large = merged[0][0] - 1;
        for (int i = 0; i < merged.length - 1; i++)
        {
            int diff = merged[i+1][0] - merged[i][1] - 1;
            if(diff > large)
            {
                large = diff;
            }
        }
        large = large < n - merged[merged.length - 1][1] - 1 ? n - merged[merged.length - 1][1] - 1 : large;
        return large;
    }
    public static void MergeSort(Node[] node, int l, int r)
    {
        if(l < r)
        {
            int mid = (l + r) / 2;
            MergeSort(node, l, mid);
            MergeSort(node, mid + 1, r);
            Merge(node, l, mid, r);
        }
    }
    public static void Merge(Node[] node, int l, int m, int r)
    {
        int low = l;
        int mid = m;
        int mid2 = m + 1;
        int high = r;
        int len = high - low + 1;
        Node[] temp = new Node[len];
        int curr = 0;
        while(low <= mid && mid2 <= high)
        {
            if(node[low].s < node[mid2].s)
            {
                temp[curr] = node[low];
                low++;
                curr++;
            }
            else
            {
                temp[curr] = node[mid2];
                mid2++;
                curr++;
            }
        }
        if(low <= mid)
        {
            for (int i = low; i <= mid; i++)
            {
                temp[curr] = node[i];
                curr++;
            }
        }
        else if(mid2 <= high)
        {
            for (int i = mid2; i <= high; i++)
            {
                temp[curr] = node[i];
                curr++;
            }
        }
        for (int i = 0; i < temp.length; i++)
        {
            node[l] = temp[i];
            l++;
        }
        
    }
    public int[][] merge(int[][] intervals) 
    {
        if(intervals == null ||intervals.length == 0)
        {
            return new int[][]{};
        }
        Node[] node = new Node[intervals.length];
        for (int i = 0; i < intervals.length; i++)
        {
            node[i] = new Node(intervals[i][0], intervals[i][1]);
        }
        MergeSort(node, 0, intervals.length - 1);
        
        for (int i = 0; i < intervals.length; i++)
        {
            System.out.println(node[i].s + " " + node[i].f);
        }
        int pivot = 0;
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 1; i < node.length; i++)
        {
            if(node[i].s >= node[pivot].s && node[i].s <= node[pivot].f)
            {
                if(node[i].f >= node[pivot].f)
                {
                    node[pivot].f = node[i].f;
                }  
            }
            else if(node[i].s > node[pivot].f)
            {
                list.add(node[pivot]);
                pivot = i;
            }
        }
        list.add(node[pivot]);
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++)
        {
            result[i][0] = list.get(i).s;
            result[i][1] = list.get(i).f;
        }
        return result;
    }*/
}
/*class Node
{
    public int s;
    public int f;
    //public Node next;
    public Node(int i, int j)
    {
        if(i<=j)
        {
            s = i;
            f = j;
        }
        else
        {
            s = j;
            f = i;
        }
        
        //this.next = null;
    }
}*/