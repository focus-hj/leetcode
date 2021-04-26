package com.leetcode.qa_164;

import java.util.Arrays;

/**
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * 如果数组元素个数小于 2，则返回 0。
 * <p>
 * 示例 1:
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * <p>
 * 示例 2:
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-gap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author huangjian
 */
public class Solution {

    public static void sort(int[] nums) {
        int n = 1;
        int[][] tmp = new int[10][nums.length];
        int[] order = new int[10];
        int k;
        int maxVal = Arrays.stream(nums).max().getAsInt();
        while (n <= maxVal) {
            for (int num : nums) {
                int lsd = (num / n) % 10;
                tmp[lsd][order[lsd]] = num;
                order[lsd]++;
            }
            k = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < order[i]; j++) {
                    nums[k] = tmp[i][j];
                    k++;
                }
                order[i] = 0;
            }
            n *= 10;
        }
    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        sort(nums);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i] - nums[i - 1], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740};
        sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(new Solution().maximumGap(nums));
    }
}
