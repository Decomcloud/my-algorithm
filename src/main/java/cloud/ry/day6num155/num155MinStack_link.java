package cloud.ry.day6num155;
////设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
////
//// 实现 MinStack 类: 
////
//// 
//// MinStack() 初始化堆栈对象。 
//// void push(int val) 将元素val推入堆栈。 
//// void pop() 删除堆栈顶部的元素。 
//// int top() 获取堆栈顶部的元素。 
//// int getMin() 获取堆栈中的最小元素。 
//// 
////
//// 
////
//// 示例 1: 
////
//// 
////输入：
////["MinStack","push","push","push","getMin","pop","top","getMin"]
////[[],[-2],[0],[-3],[],[],[],[]]
////
////输出：
////[null,null,null,null,-3,null,0,-2]
////
////解释：
////MinStack minStack = new MinStack();
////minStack.push(-2);
////minStack.push(0);
////minStack.push(-3);
////minStack.getMin(); --> 返回 -3.
////minStack.pop();
////minStack.top(); --> 返回 0.
////minStack.getMin(); --> 返回 -2.
//// 
////
//// 
////
//// 提示： 
////
//// 
//// -2³¹ <= val <= 2³¹ - 1 
//// pop、top 和 getMin 操作总是在 非空栈 上调用 
//// push, pop, top, and getMin最多被调用 3 * 10⁴ 次 
//// 
//// Related Topics 栈 设计 👍 1278 👎 0
//

public class num155MinStack_link {
    public static void main(String[] args) {
        //Solution solution = new num155MinStack().new Solution();
    }

    // 1. 栈只能看到顶部，链表只能看到tail【只能快速查询到边界】
    // 2. push操作对应链表的tail指向新节点；
    // 3. pop操作对应链表的tail指向前一个节点；
    // 4. top操作对应返回tail的value；
    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        class LinkNode {
            int value;
            LinkNode nextNode;
            LinkNode minNode;
            LinkNode(int value, LinkNode topNode) {
                this.value = value;
                this.nextNode = topNode;
                if (topNode == null || value < topNode.minNode.value) {
                    minNode = this;
                } else {
                    minNode =topNode.minNode;
                }
            }
        }

        LinkNode topNode;

        public MinStack() {
            topNode = null;
        }

        public void push(int val) {
            topNode = new LinkNode(val, this.topNode);
        }

        public void pop() {
            topNode = topNode.nextNode;
        }

        public int top() {
            return topNode.value;
        }

        public int getMin() {
            return topNode.minNode.value;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}