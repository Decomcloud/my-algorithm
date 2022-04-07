package cloud.leetCode.linkedlist;
//反转一个单链表。
// 示例:
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

public class num206ReverseLinkedList {
	public static void main(String[] args) {
		Solution solution = new num206ReverseLinkedList().new Solution();
	}
	class Solution {
		public ListNode reverseList(ListNode head) {
			if (head == null) return head;
			// 排序到最后一个了
			if (head.next == null) return head;
			ListNode newHead = reverseList(head.next);
			head.next.next = head;
			head.next = null;
			return newHead;
		}

		public ListNode reverseList2(ListNode head) {
			if (head == null || head.next == null) return head;
			ListNode newHead = null;
			// head 保存原链表准备处理的节点的信息
			while (head != null) {
				// 保存下一个要处理的节点
				ListNode tmp = head.next;
				// 改变head节点的next指向, 原来指向为tmp,
				// 暂且任务head是新链表头节点
				head.next = newHead;
				// 更新newhead
				newHead = head;
				// 移动
				head = tmp;
			}

			return newHead;
		}
	}

}