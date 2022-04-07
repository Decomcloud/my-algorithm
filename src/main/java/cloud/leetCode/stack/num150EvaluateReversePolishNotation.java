package cloud.leetCode.stack;
//根据 逆波兰表示法，求表达式的值。
//
// 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。 
//
// 
//
// 说明： 
//
// 
// 整数除法只保留整数部分。 
// 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：tokens = ["2","1","+","3","*"]
//输出：9
//解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
// 
//
// 示例 2： 
//
// 
//输入：tokens = ["4","13","5","/","+"]
//输出：6
//解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
// 
//
// 示例 3： 
//
// 
//输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
//输出：22
//解释：
//该算式转化为常见的中缀算术表达式为：
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22 
//
// 
//
// 提示： 
//
// 
// 1 <= tokens.length <= 104 
// tokens[i] 要么是一个算符（"+"、"-"、"*" 或 "/"），要么是一个在范围 [-200, 200] 内的整数 
// 
//
// 
//
// 逆波兰表达式： 
//
// 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。 
//
// 
// 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。 
// 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。 
// 
//
// 逆波兰表达式主要有以下两个优点： 
//
// 
// 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。 
// 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。 
// 
// Related Topics 栈 
// 👍 327 👎 0

import java.util.Stack;

public class num150EvaluateReversePolishNotation{
	public static void main(String[] args) {
		Solution solution = new num150EvaluateReversePolishNotation().new Solution();
		int result = solution.evalRPN2(new String[]{"4", "13", "5", "/", "+"});
		System.out.println(result);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int evalRPN(String[] tokens) {
		Stack<Integer> stack= new Stack<>();
		for (String s : tokens) {
			if (!s.equals("+") && !s.equals("*") && !s.equals("/") && !s.equals("-")) {
				stack.push(Integer.parseInt(s));
			} else {
				Integer val1 = stack.pop();
				Integer val2 = stack.pop();
				switch (s) {
					case "+":
						stack.push(val1 + val2);
						break;
					case "*":
						stack.push(val1 * val2);
						break;
					case "/":
						stack.push(val2 / val1);
						break;
					default:
						stack.push(val2 - val1);
						break;
				}
			}
		}
		return stack.pop();
    }

	public int evalRPN2(String[] tokens) {
		int[] value = new int[tokens.length];
		int size = -1;
		for (String s : tokens) {
			// !s.equals("+") && !s.equals("*") && !s.equals("/") && !s.equals("-")
			if (!"+*-/".contains(s)) {
				value[++size] = Integer.parseInt(s);
			} else {
				int val1 = value[size--];
				int val2 = value[size];
				switch (s) {
					case "+":
						value[size] = val1 + val2;
						break;
					case "*":
						value[size] = val1 * val2;
						break;
					case "/":
						value[size] = val2 / val1;
						break;
					default:
						value[size] = val2 - val1;
						break;
				}
			}
		}
		return value[0];
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}