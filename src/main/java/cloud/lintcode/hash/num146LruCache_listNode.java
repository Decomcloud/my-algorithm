package cloud.lintcode.hash;

import java.util.HashMap;
import java.util.Map;
//请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
//
// 实现 LRUCache 类： 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
// 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 👍 2225 👎 0

public class num146LruCache_listNode {
    public static void main(String[] args) {
        //Solution solution = new num146LruCache().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        private int capacity;
        // 存放最新数据的链表, 尾节点为最新的数据
        private ListNode dummy = new ListNode(0, 0);
        private ListNode tail = dummy;
        private Map<Integer, ListNode> keyToPrev = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!keyToPrev.containsKey(key)) {
                return -1;
            }
            // 把这个点放到尾部去
            kick(key);
            return tail.val;
        }

        public void put(int key, int value) {
            if (get(key) != -1) {
                tail.val = value;
                return;
            }
            // 之前没有这个节点
            pushBack(new ListNode(key, value));
            // 多于容量, 移除最前面的
            if (keyToPrev.size() > capacity) {
                popFront();
            }
        }

        // 删除头部的最少使用节点
        private void popFront() {
            ListNode head = dummy.next;
            keyToPrev.remove(head.key);
            dummy.next = head.next;
            // 更新新头部节点的前驱节点
            keyToPrev.put(dummy.next.key, dummy);
        }

        // 把节点放入链表的尾部
        private void pushBack(ListNode listNode) {
            keyToPrev.put(listNode.key, tail);
            tail.next = listNode;
            tail = listNode;
        }

        // 移动到尾部
        private void kick(int key) {
            ListNode prev = keyToPrev.get(key);
            ListNode keyNode = prev.next;
            // 当前节点已经在尾部, 不需要移动
            if (keyNode == tail) {
                return;
            }
            // 更新前后节点的指针
            prev.next = keyNode.next;
            keyToPrev.put(prev.next.key, prev);
            // 移动到尾部, 先要设置当前节点的next为null
            keyNode.next = null;
            pushBack(keyNode);
        }

    }

    class ListNode {
        public int key;
        public int val;
        public ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}