package cloud.lintcode.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串
//"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相
//同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。 
//
// 示例 1： 
//
// 输入： pattern = "abba", value = "dogcatcatdog"
//输出： true
// 
//
// 示例 2： 
//
// 输入： pattern = "abba", value = "dogcatcatfish"
//输出： false
// 
//
// 示例 3： 
//
// 输入： pattern = "aaaa", value = "dogcatcatdog"
//输出： false
// 
//
// 示例 4： 
//
// 输入： pattern = "abba", value = "dogdogdogdog"
//输出： true
//解释： "a"="dogdog",b=""，反之也符合规则
// 
//
// 提示： 
//
// 
// 1 <= len(pattern) <= 1000 
// 0 <= len(value) <= 1000 
// 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。 
// 
// Related Topics 数学 字符串 回溯 枚举 👍 128 👎 0

class numQues1618PatternMatchingLcci {
	// 理解思路, 边界过多, 匹配可以为空
	public static void main(String[] args) {
		numQues1618PatternMatchingLcci solution = new numQues1618PatternMatchingLcci();
	}

	public boolean patternMatching(String pattern, String value) {
		if ("".equals(pattern)) {
			return false;
		}
		return isMatch(pattern, value, new HashMap<>(), new HashSet<>());
	}

	private boolean isMatch(String pattern, String str, Map<Character, String> mapping, Set<String> used) {
		if (pattern.length() == 0) {
			return str.length() == 0;
		}
		char ch = pattern.charAt(0);
		System.out.println("ch: " + ch + " str:" + str);
		if (mapping.containsKey(ch)) {
			String word = mapping.get(ch);
			if (!str.startsWith(word)) {
				System.out.println("line 63" + word);
				return false;
			}
			return isMatch(pattern.substring(1), str.substring(word.length()), mapping, used);
		}
		if (str.length() == 0) {
			if (!isValid(mapping, "")) {
				return false;
			}
			mapping.put(ch, "");
			used.add("");
			return isMatch(pattern.substring(1), str, mapping, used);
		}
		// 考虑空值
		for (int i = -1; i < str.length(); i++) {
			String word = str.substring(0, i + 1);
			if (used.contains(word)) {
				continue;
			}
			if (!isValid(mapping, word)) {
				continue;
			}
			used.add(word);
			mapping.put(ch, word);
			if (isMatch(pattern.substring(1), word.equals("") ? str : str.substring(i + 1), mapping, used)) {
				return true;
			}
			mapping.remove(ch);
			used.remove(word);
		}
		return false;
	}

	private boolean isValid(Map<Character, String> mapping, String word) {
		for (Map.Entry<Character, String> entry : mapping.entrySet()) {
			if (entry.getValue().equals(word)) {
				return false;
			}
		}
		return true;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
