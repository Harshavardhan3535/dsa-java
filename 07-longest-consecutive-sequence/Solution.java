import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    // HashSet: count runs only from their starting numbers - O(n) time
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {   // num is the start of a run
                int current = num;
                int streak = 1;
                while (set.contains(current + 1)) {
                    current++;
                    streak++;
                }
                longest = Math.max(longest, streak);
            }
        }
        return longest;
    }

    // Approach 2: Sorting - O(n log n) time (approach learned from a LeetCode solution)
    public int longestConsecutiveSorting(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int streak = 1;
        int longest = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i] + 1) {
                streak++;                       // run continues
                longest = Math.max(longest, streak);
            } else if (nums[i + 1] == nums[i]) {
                continue;                       // duplicate: run unchanged
            } else {
                streak = 1;                     // gap: run is broken
            }
        }
        return longest;
    }
}
