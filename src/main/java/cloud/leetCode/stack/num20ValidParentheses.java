package cloud.leetCode.stack;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
// 有效字符串需满足：
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。
// 示例 1：
//输入：s = "()"
//输出：true
// 示例 2：
//输入：s = "()[]{}"
//输出：true
// 示例 3：
//输入：s = "(]"
//输出：false
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class num20ValidParentheses {
	public static void main(String[] args) {
		Solution solution = new num20ValidParentheses().new Solution();
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
		while (s.contains("{}") || s.contains("[]") || s.contains("()")) {
    		s = s.replace("{}", "");
			s = s.replace("[]", "");
			s = s.replace("()", "");
		}
    	return s.isEmpty();
    }

	public boolean isValid2(String s) {
		Stack<Character> stack = new Stack<>();
		int len = s.length();
		for (int i = 0; i < len; i ++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) return false;
				Character left = stack.pop();
				if (left == '(') {
					if (c != ')') return false;
				} else if (left == '[') {
					if (c != ']') return false;
				} else if (left == '{') {
					if (c != '}') return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public boolean isValid3(String s) {
		Stack<Character> stack = new Stack<>();
		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		int len = s.length();
		for (int i = 0; i < len; i ++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				stack.push(c);
			} else {
				if (stack.isEmpty()) return false;
				Character left = stack.pop();
				if (!map.get(left).equals(c)) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}