package edu.northeastern.leetcode;

import java.util.HashMap;
import java.util.Map;

public class leetcode234 {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        System.out.println(isPalindrome(head));
    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int len = 0;
        map.put(i++, slow.val);

        while((fast!=null) && (fast.next!=null)){
            slow= slow.next;
            map.put(i++, slow.val);
            fast= fast.next.next;
        }
        if(fast==null){
            len = i * 2;
            if(slow.val!=map.get(--i)){
                return false;
            }
            while(slow.next !=null){
                slow= slow.next;
                if(slow.val!=map.get(--i)){
                    return false;
                }
            }
        }else if(fast.next == null){
            len = i * 2 + 1;
            while(slow.next!=null){
                slow = slow.next;
                if(slow.val!=map.get(i--)){
                    return false;
                }
            }
        }else if(fast.next.next == null){
            len = i * 2 + 2;
            while(slow.next!=null){
                slow = slow.next;
                if(slow.val!=map.get(--i)){
                    return false;
                }
            }
        }
        return true;
    }
}
