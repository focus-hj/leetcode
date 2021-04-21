package com.leetcode.qa_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi]。
请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

示例 1：
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

示例 2：
输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> merged = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            if (i < intervals.length - 1 && intervals[i][1] >= intervals[i + 1][0]) {
                int right = Math.max(intervals[i][1], intervals[i + 1][1]);
                merged.add(new int[]{intervals[i][0], right});
                i += 2;
            } else {
                merged.add(intervals[i]);
                i++;
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] merged = s.merge(intervals);
        for (int[] ints : merged) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
