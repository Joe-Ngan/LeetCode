package edu.northeastern.leetcode;

public class leetcode445 {
    public static void main(String[] args) {
        ListNode l14 = new ListNode(3, null);
        ListNode l13 = new ListNode(4, l14);
        ListNode l12 = new ListNode(2, l13);
        ListNode l1 = new ListNode(7, l12);

        ListNode l23 = new ListNode(4, null);
        ListNode l22 = new ListNode(6, l23);
        ListNode l2 = new ListNode(5, l22);
        System.out.println(addTwoNumbers(l1, l2));
    }
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode ans = new ListNode();
        ListNode dummy = ans;

        int carry = 0;
        while(l1!=null || l2!=null || carry!=0){
            int l1v = (l1==null)? 0 : l1.val;
            int l2v = (l2==null)? 0 : l2.val;
            int sum = l1v + l2v + carry;
            ans.val = sum % 10;
            carry = sum / 10;
            ListNode nex = new ListNode();
            ans.next = nex;
            ans = ans.next;

            l1 = (l1==null)? null : l1.next;
            l2 = (l2==null)? null : l2.next;
        }

        ans = reverse(dummy);
        return ans.next;
    }

    public static ListNode reverse(ListNode node){
        ListNode dummy = new ListNode();

        ListNode pre = dummy;
        pre.next = node;
        while(node.next!=null){
            ListNode nex = node.next;
            node.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
    }
}
