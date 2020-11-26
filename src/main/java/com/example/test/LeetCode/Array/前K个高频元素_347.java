package com.example.test.LeetCode.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ShineQi
 * @Date 2020/11/25 16:02
 */
public class 前K个高频元素_347 {
//    输入: nums = [1,1,1,2,2,3], k = 2
//    输出: [1,2]

    public int[] topKFrequent(int[] nums, int k) {

        int frequency = 1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
//                frequency = i -
            }
            map.put(nums[i],frequency);
        }
        //双指针  和无重复最长
        return null;
    }
//    输入: ["flower","flow","flight"]
//    输出: "fl"
    public String longestCommonPrefix(String[] strs) {
        List<char[]> list = new ArrayList<>();
       for(int i = 0;i<strs.length;i++){
           list.add(strs[i].toCharArray());
       }
       return null;
    }
}
