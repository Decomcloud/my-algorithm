package cloud.leetCode.stack;
//给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
//
//
// () 得 1 分。
// AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
// (A) 得 2 * A 分，其中 A 是平衡括号字符串。
//
//
//
//
// 示例 1：
//
// 输入： "()"
//输出： 1
//
//
// 示例 2：
//
// 输入： "(())"
//输出： 2
//
//
// 示例 3：
//
// 输入： "()()"
//输出： 2
//
//
// 示例 4：
//
// 输入： "(()(()))"
//输出： 6
//
//
//
//
// 提示：
//
//
// S 是平衡括号字符串，且只含有 ( 和 ) 。
// 2 <= S.length <= 50
//
// Related Topics 栈 字符串
// 👍 197 👎 0

import java.util.Stack;

public class num856ScoreOfParentheses {
	public static void main(String[] args) {
		Solution solution = new num856ScoreOfParentheses().new Solution();
		int score = solution.scoreOfParentheses3("(())()");
		System.out.println(score);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	public int scoreOfParentheses(String s) {
		Stack<String> stack = new Stack<>();
		int length = s.length();
		for (int i = 0 ; i < length ; i ++ ){
			char c = s.charAt(i);
			if ('(' == c) {
				stack.push(String.valueOf(c));
			} else if (')' == c) {
				String left = stack.pop();
				int value = 0;
				if (left.equals("(")) {
					stack.push(String.valueOf(1));
					continue;
				}
				while (!left.equals("(")) {
					value += Integer.parseInt(left);
					left = stack.pop();
				}
				stack.push(String.valueOf(value * 2));
			}
		}
		int val = 0;
		while (!stack.isEmpty()) {
			val += Integer.parseInt(stack.pop());
		}
		return val;
	}

    public int scoreOfParentheses2(String s) {
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (char c : s.toCharArray()){
			if ('(' == c) {
				stack.push(0);
			} else {
				int left = stack.pop();
				int leftleft = stack.pop();
				stack.push(leftleft + Math.max(2 * left, 1));
			}
		}
		return stack.pop();
    }

	public int scoreOfParentheses3(String s) {
		int ans = 0, bal = -1;
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '(') {
				bal++;
			} else {
				if (s.charAt(i-1) == '(') ans += 1 << bal;
				bal --;
			}
		}

		return ans;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}