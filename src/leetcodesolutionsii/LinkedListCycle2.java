package leetcodesolutionsii;






public class LinkedListCycle2 
{
    public ListNode DetectCycle(ListNode head) 
    {
        ListNode tor = head;
        ListNode hare = head;
        
        if(head == null || head.next == null)
        {
            return null;
        }
        while(true)
        {
            if(tor == null || tor.next == null)
            {
                return null;
            }
            if(hare == null || hare.next == null)
            {
                return null;
            }
            tor = tor.next;
            hare = hare.next.next;
            if(tor == hare)
            {
                break;
            }
        }
        hare = head;
        while(hare != tor)
        {
            hare = hare.next;
            tor = tor.next;
        }
        return hare;
    }
    
}
