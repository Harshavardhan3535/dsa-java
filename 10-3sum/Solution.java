import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    // Sort, fix i, then two pointers for the rest - O(n^2) time
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;                               // skip repeated i
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;                         // skip repeated left
                    }
                } else if (sum < 0) {
                    left++;                             // sum too small: need a bigger number
                } else {
                    right--;                            // sum too big: need a smaller number
                }
            }
        }
        return result;
    }
}
