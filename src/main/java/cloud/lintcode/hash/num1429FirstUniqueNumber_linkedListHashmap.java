package cloud.lintcode.hash;

import cloud.lintcode.common.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//给定一系列整数，插入一个队列中，找出队列中第一个唯一整数。
//
// 实现 FirstUnique 类： 
//
// 
// FirstUnique(int[] nums) 用数组里的数字初始化队列。 
// int showFirstUnique() 返回队列中的 第一个唯一 整数的值。如果没有唯一整数，返回 -1。（译者注：此方法不移除队列中的任何元素） 
// void add(int value) 将 value 插入队列中。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["FirstUnique","showFirstUnique","add","showFirstUnique","add",
//"showFirstUnique","add","showFirstUnique"]
//[[[2,3,5]],[],[5],[],[2],[],[3],[]]
//输出：
//[null,2,null,2,null,3,null,-1]
//解释：
//FirstUnique firstUnique = new FirstUnique([2,3,5]);
//firstUnique.showFirstUnique(); // 返回 2
//firstUnique.add(5);            // 此时队列为 [2,3,5,5]
//firstUnique.showFirstUnique(); // 返回 2
//firstUnique.add(2);            // 此时队列为 [2,3,5,5,2]
//firstUnique.showFirstUnique(); // 返回 3
//firstUnique.add(3);            // 此时队列为 [2,3,5,5,2,3]
//firstUnique.showFirstUnique(); // 返回 -1
// 
//
// 示例 2： 
//
// 
//输入：
//["FirstUnique","showFirstUnique","add","add","add","add","add",
//"showFirstUnique"]
//[[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
//输出：
//[null,-1,null,null,null,null,null,17]
//解释：
//FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
//firstUnique.showFirstUnique(); // 返回 -1
//firstUnique.add(7);            // 此时队列为 [7,7,7,7,7,7,7]
//firstUnique.add(3);            // 此时队列为 [7,7,7,7,7,7,7,3]
//firstUnique.add(3);            // 此时队列为 [7,7,7,7,7,7,7,3,3]
//firstUnique.add(7);            // 此时队列为 [7,7,7,7,7,7,7,3,3,7]
//firstUnique.add(17);           // 此时队列为 [7,7,7,7,7,7,7,3,3,7,17]
//firstUnique.showFirstUnique(); // 返回 17
// 
//
// 示例 3： 
//
// 
//输入：
//["FirstUnique","showFirstUnique","add","showFirstUnique"]
//[[[809]],[],[809],[]]
//输出：
//[null,809,null,-1]
//解释：
//FirstUnique firstUnique = new FirstUnique([809]);
//firstUnique.showFirstUnique(); // 返回 809
//firstUnique.add(809);          // 此时队列为 [809,809]
//firstUnique.showFirstUnique(); // 返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^8 
// 1 <= value <= 10^8 
// 最多调用 5000 次 showFirstUnique 和 add 。 
// 
// Related Topics 设计 队列 数组 哈希表 数据流 👍 16 👎 0

public class num1429FirstUniqueNumber_linkedListHashmap {
    public static void main(String[] args) {
        //Solution solution = new num1429FirstUniqueNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FirstUnique {
        private ListNode dummy = new ListNode(0);
        private ListNode tail = dummy;
        // 数据值:数据节点之前的节点
        // 这样可以保证链表的删除为O1
        private Map<Integer, ListNode> numToPrev = new HashMap<>();
        // 重复出现的数字
        private Set<Integer> duplicates = new HashSet<>();

        public FirstUnique(int[] nums) {
            for (int num : nums) {
                add(num);
            }
        }

        public int showFirstUnique() {
            if (dummy.next == null) {
                return -1;
            }
            return dummy.next.val;
        }

        public void add(int value) {
            if (duplicates.contains(value)) {
                return;
            }
            if (!numToPrev.containsKey(value)) {
                // 将不重复的节点加入尾部
                addToListTail(value);
                return;
            }
            // 重复节点
            remove(value);
            duplicates.add(value);
        }

        private void remove(int value) {
            // 获取前节点
            ListNode prev = numToPrev.get(value);
            // 在链表中移除这个节点
            prev.next = prev.next.next;
            numToPrev.remove(value);
            // 不是最后一个节点
            if (prev.next != null) {
                // 更新后节点的值的前节点为被删除节点的前节点
                numToPrev.put(prev.next.val, prev);
            } else {
                // 删除的时尾节点
                tail = prev;
            }
        }

        private void addToListTail(int value) {
            // 前一个节点的next指向当前的新节点
            tail.next = new ListNode(value);
            // 放入value和前节点的对应关系
            numToPrev.put(value, tail);
            // tail指向新节点
            tail = tail.next;
        }
    }

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}