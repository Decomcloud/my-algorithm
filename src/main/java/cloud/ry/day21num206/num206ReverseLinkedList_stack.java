package cloud.ry.day21num206;

import cloud.ry.common.ListNode;

import java.util.Stack;
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 👍 2508 👎 0

public class num206ReverseLinkedList_stack {
    public static void main(String[] args) {
        Solution solution = new num206ReverseLinkedList_stack().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {

            Stack<Integer> stack = new Stack<>();
            ListNode visit = head;
            while (visit != null) {
                stack.add(visit.val);
                visit = visit.next;
            }

            visit = head;

            while (visit != null) {
                visit.val = stack.pop();
                visit = visit.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}