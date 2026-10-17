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
}
