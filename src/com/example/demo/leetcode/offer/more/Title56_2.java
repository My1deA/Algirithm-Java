package com.example.demo.leetcode.offer.more;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 剑指 Offer 56 - II. 数组中数字出现的次数 IIv
在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

输入：nums = [3,4,3,3]
输出：4
 */
class Solution56_2 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> tMap = iterator.next();
            if (tMap.getValue() == 1) {
                return tMap.getKey();
            }
        }
        return 0;
    }

    public int singleNumber2(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }


}

public class Title56_2 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 3, 3};
        Solution56_2 solution56_2 = new Solution56_2();
        System.out.println(solution56_2.singleNumber(nums));
    }
}
