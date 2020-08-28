/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutionsii;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author aditp
 */
public class MergeKsorted23
{
    public ListNode mergeKLists(ListNode[] lists) 
    {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>()
        {
            public int compare(ListNode a, ListNode b)
            {
                if(a.val > b.val)
                {
                    return 1;
                }
                else
                {
                    return -1;
                }
            }
        });
        for(int i = 0; i < lists.length; ++i)
        {
            if(lists[i] != null)
                pq.add(lists[i]);
        }
        ListNode ls = null;
        ListNode curr = null;
        
        while(!pq.isEmpty())
        {
            ListNode temp = pq.poll();
            if(temp.next != null)
            {
                pq.add(temp.next);
            }
            temp.next = null;
            if(ls == null)
            {
                ls = temp;
                curr = temp;
            }
            else
            {
                curr.next = temp;
                curr = curr.next;
            }
        }
        
        return ls;
    }
}
