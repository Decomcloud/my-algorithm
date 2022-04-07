package cloud.leetCode;

public class num2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int count = 0;
        ListNode listNode = new ListNode(0);
        ListNode newlistNode = listNode;
        while (l1 != null && l2 != null){
            int val = l1.val + l2.val + count;
            count = val>=10 ? 1: 0;
            listNode.next = new ListNode(val % 10);
            listNode = listNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            int val = l1.val + count;
            count = val>=10 ? 1: 0;
            listNode.next = new ListNode(val % 10);
            listNode = listNode.next;
            l1 = l1.next;
        }

        while (l2 != null){
            int val = l2.val + count;
            count = val>=10 ? 1: 0;
            listNode.next = new ListNode(val % 10);
            listNode = listNode.next;
            l2 = l2.next;
        }
        if(count!=0){
            listNode.next = new ListNode(1);
        }
        return newlistNode.next;

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
