package cloud.lintcode.twoPointer;

/**
 * 有一些原木，现在想把这些木头切割成一些长度相同的小段木头，需要得到的小段的数目至少为 k。
 * 当然，我们希望得到的小段越长越好，你需要计算能够得到的小段木头的最大长度。
 * 木头长度的单位是厘米。原木的长度都是正整数，
 * 我们要求切割得到的小段木头的长度也要求是整数。
 * 无法切出要求至少 k 段的,则返回 0 即可
 * <p>
 * 解释一下就是：给定了一个切割目标长度Len后，
 * 每一根原木都可以切割出多条，加在一起的数目totalCount要求大于等于k。
 * 在满足总数目totalCount大于等于k的条件下，得到一个最长的目标长度len
 */
public class WoodCut {
    public static void main(String[] args) {

    }

    public int woodCut(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        int maxLen = 0;
        long sum = 0;
        for (int num : nums) {
            // 找出最大值
            end = Math.max(end, num);
            sum += num;
        }
        // 找到二分的终点
        end = (int) Math.min(end, sum / k);

        if (end < 1) {
            return 0;
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // 长度为mid的可以切
            if (getCount(nums, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        // 先看end
        return getCount(nums, end) >= k ? end : start;
    }

    // 根据长度获取可以切分的段数
    private int getCount(int[] nums, int len) {
        int cnt = 0;
        for (int num : nums) {
            cnt += num / len;
        }
        return cnt;
    }

}
