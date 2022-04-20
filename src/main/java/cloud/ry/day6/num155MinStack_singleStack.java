package cloud.ry.day6;

import java.util.LinkedList;
import java.util.List;
//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 实现 MinStack 类: 
//
// 
// MinStack() 初始化堆栈对象。 
// void push(int val) 将元素val推入堆栈。 
// void pop() 删除堆栈顶部的元素。 
// int top() 获取堆栈顶部的元素。 
// int getMin() 获取堆栈中的最小元素。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// pop、top 和 getMin 操作总是在 非空栈 上调用 
// push, pop, top, and getMin最多被调用 3 * 10⁴ 次 
// 
// Related Topics 栈 设计 👍 1278 👎 0

public class num155MinStack_singleStack {
    public static void main(String[] args) {
        //Solution solution = new num155MinStack().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        // 破题点：min值的变化都是从小到大。min的差值都是负数，min变化前，push的数和min的差值
        //均不为负。
        //算法思想：维护一个差值栈deltaStack，和一个min变量
        //1）push(x)：如果$x \ge min$, $deltaStack.push(x-min)$;
        //否则 $deltaStack.push(x-min)$，$min = x$;
        //2）pop() ：如果$detlaValue \ge 0$, 返回$deltaValue+ min$，删除deltaValue;
        //否则 返回min，$min = min-deltaVlaue$，删除deltaVlaue;
        //3）top：返回$deltaValue+ min$；
        //4）getMin：返回min；
        private List<Long> deltaStack;

        private long min;

        public MinStack() {
            deltaStack = new LinkedList<>();
            min = Long.MAX_VALUE;
        }

        public void push(int val) {
            if (deltaStack.size() == 0) {
                min = val;
                deltaStack.add(0L);
            } else {
                long deltaValue = val - min;
                deltaStack.add(deltaValue);
                if(deltaValue < 0) {
                    //此时的minValue就是x
                    min = val;
                }
            }
        }

        public void pop() {
            Long deltaValue = deltaStack.remove(deltaStack.size() - 1);
            if (deltaValue < 0) {
                min = min - deltaValue;
            }
        }

        public int top() {
            Long deltaValue = deltaStack.get(deltaStack.size() - 1);
            if (deltaValue < 0) {
                return Integer.parseInt(String.valueOf(min));
            }
            return Integer.parseInt(String.valueOf(deltaValue + min));

        }

        public int getMin() {
            return Integer.parseInt(String.valueOf(min));
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