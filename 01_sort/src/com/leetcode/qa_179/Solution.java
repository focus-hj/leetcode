package com.leetcode.qa_179;

import java.util.*;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 * <p>
 * 示例 2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * <p>
 * 示例 3：
 * 输入：nums = [1]
 * 输出："1"
 * <p>
 * 示例 4：
 * 输入：nums = [10]
 * 输出："10"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public String largestNumber(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int maxLen = String.valueOf(max).toCharArray().length;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            int key = num;
            while (String.valueOf(key).toCharArray().length < maxLen) {
                key = (key * 10) + (key % 10);
            }
            map.put(key, num);
        }
        StringBuilder res = new StringBuilder();
        for (Integer k : map.keySet()) {
            res.insert(0, map.get(k));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {34323, 3432};
        String res = solution.largestNumber(nums);
        System.out.println(res);
    }
}
