package cloud.ry.day26num171;
//给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
//
// 例如： 
//
// 
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 
//... 
//
// 
//
// 示例 1: 
//
// 
//输入: columnTitle = "A"
//输出: 1
// 
//
// 示例 2: 
//
// 
//输入: columnTitle = "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 
//输入: columnTitle = "ZY"
//输出: 701 
//
// 
//
// 提示： 
//
// 
// 1 <= columnTitle.length <= 7 
// columnTitle 仅由大写英文组成 
// columnTitle 在范围 ["A", "FXSHRXW"] 内 
// 
// Related Topics 数学 字符串 👍 330 👎 0

public class num171ExcelSheetColumnNumber_recursion {
    public static void main(String[] args) {
        Solution solution = new num171ExcelSheetColumnNumber_recursion().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int titleToNumber(String columnTitle) {
            return subTitleToNumber(columnTitle, 0, columnTitle.length() - 1);
        }

        public int subTitleToNumber(String columnTitle, int s, int e) {
            if (e == s) {
                return (columnTitle.charAt(s) - 'A' + 1) * ((int) Math.pow(26, columnTitle.length() - 1 - s));
            }
            int mid = (e - s) / 2 + s;
            return subTitleToNumber(columnTitle, s, mid) + subTitleToNumber(columnTitle, mid + 1, e);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}