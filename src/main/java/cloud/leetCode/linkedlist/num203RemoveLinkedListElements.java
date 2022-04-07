package cloud.leetCode.linkedlist;
//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
// 示例 1：
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 示例 2：
//输入：head = [], val = 1
//输出：[]
// 示例 3：
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 提示：
// 列表中的节点在范围 [0, 104] 内 
// 1 <= Node.val <= 50 
// 0 <= k <= 50 

public class num203RemoveLinkedListElements {
	public static void main(String[] args) {
		Solution solution = new num203RemoveLinkedListElements().new Solution();
	}
class Solution {
    public ListNode removeElements1(ListNode head, int val) {
    	// 找到头节点
    	while (head!= null && head.val == val) {
    		head = head.next;
		}
    	if (head == null) return head;
		ListNode newHead = head;
    	while (head.next != null) {
    		if (head.next.val == val) {
    			head.next = head.next.next;
			} else {
    			head = head.next;
			}
		}
    	return newHead;
    }

    // 虚拟头节点
	public ListNode removeElements2(ListNode head, int val) {
		ListNode newHead = null;
		newHead.next = head;
		ListNode pre = newHead;

		while (pre.next!= null) {
			if (pre.val == val) {
				pre.next = pre.next.next;
			} else {
				pre = pre.next;
			}
		}

		return newHead.next;
	}

	public ListNode removeElements3(ListNode head, int val) {
		if(head==null) return null;
		head.next = removeElements3(head.next,val);
		if(head.val == val){
			head = head.next;
		}
		return head;

	}
}

}