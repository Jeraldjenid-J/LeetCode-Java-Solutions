// Longest Balanced Subarray 1

import java.util.*;
class Solution {
    public int longestBalanced(int[] nums) {
        int maxLen = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> evenSet = new HashSet<>();
            Set<Integer> oddSet = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0) {
                    evenSet.add(nums[j]);
                } else {
                    oddSet.add(nums[j]);
                }
                if (evenSet.size() == oddSet.size()) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
}
