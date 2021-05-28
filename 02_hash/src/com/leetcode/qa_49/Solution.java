package com.leetcode.qa_49;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 *  示例:
 *  输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 *  输出:
 *  [
 *  ["ate","eat","tea"],
 *  ["nat","tan"],
 *  ["bat"]
 *  ]
 *
 *  说明：
 *  所有输入均为小写字母。
 *  不考虑答案输出的顺序。
 *
 * @author huangjian
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String key = String.valueOf(strChars);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> stringList = new ArrayList<>();
                stringList.add(str);
                map.put(key, stringList);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = solution.groupAnagrams(strs);
        System.out.println(res);
    }
}
