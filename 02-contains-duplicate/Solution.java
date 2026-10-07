import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    // Approach 1: HashSet - O(n) time, O(n) space
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int x : nums) {
            if (seen.contains(x)) {
                return true;
            }
            seen.add(x);
        }
        return false;
    }

    // Approach 2: Sorting - O(n log n) time, O(1) extra space
    public boolean containsDuplicateSorting(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
