package cloud.lintcode.twoPointer.sameDirection;

import java.util.HashMap;
import java.util.Map;

/*
 *
 * 描述
 * 给定一个仅包含大写英文字母的字符串，您可以将字符串中的任何一个字母替换为的另一个字母，最多替换k次。 执行上述操作后，找到最长的，只含有同一字母的子字符串的长度。
 * <p>
 * 字符串长度和k的大小不会超过10^4。

 * 样例
 *
 * 样例1
 * 输入:
 * "ABAB" 2
 * 输出: 4
 * 解释: 将两个'A’替换成两个’B’，反之亦然。
 *
 * 样例2
 * 输入: "AABABBA" 1
 * 输出: 4
 * 解释:将中间的 'A’ 替换为 'B' 后得到 “AABBBBA"。子字符串"BBBB" 含有最长的重复字符, 长度为4。
 */
public class longestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        int j = 0;
        int ans = 0;
        int maxFreq = 0;
        int count;
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // 每次新增的字符为j, 所以每次只需要判断新加入的j, 是否超过就好
            while (j < s.length() && j - i - maxFreq <= k) {
                count = counter.getOrDefault(s.charAt(j), 0) + 1;
                counter.put(s.charAt(j), count);
                maxFreq = Math.max(maxFreq, count);
                j++;
            }
            // count里面存放的是j-1中字符的频率, 因为结尾有+1
            if (j - i - maxFreq > k) {
                ans = Math.max(ans, j - i - 1);
            } else {
                // 有可能<=k, 到尾部了
                ans = Math.max(ans, j - i);
            }
            //移除i位置的出现次数
            count = counter.get(s.charAt(i)) - 1;
            counter.put(s.charAt(i), count);
            maxFreq = getMaxFreq(counter);
        }
        return ans;
    }

    private int getMaxFreq(Map<Character, Integer> counter) {
        int res = 0;
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            res = Math.max(res, entry.getValue());
        }
        return res;
    }
}
