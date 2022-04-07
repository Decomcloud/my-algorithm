package cloud.leetCode;

public class num21 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode cur = listNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                listNode.next = l1;
                l1 = l1.next;
            } else {
                listNode.next = l2;
                l2 = l2.next;
            }
            listNode = listNode.next;
        }
        listNode.next = l1 == null? l2 : l1;
        return cur.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode cur = listNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l2.next = l1;
                listNode.next = l1;
                l1 = l1.next;
            } else {
                listNode.next = l2;
                l2 = l2.next;
            }
            listNode = listNode.next;
        }
        listNode.next = l1 == null? l2 : l1;
        return cur.next;
    }

    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(1);
        listNode11.next = new ListNode(2);
        listNode11.next.next = new ListNode(4);
        ListNode listNode21 = new ListNode(1);
        listNode21.next = new ListNode(3);
        listNode21.next.next = new ListNode(4);
        ListNode listNode = mergeTwoLists(listNode11, listNode21);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
