class Solution {

    // Two pointers on a sorted array - O(n) time, O(1) extra space
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};   // answer is 1-based
            } else if (sum > target) {
                right--;                                  // sum too big: need a smaller number
            } else {
                left++;                                   // sum too small: need a bigger number
            }
        }
        return new int[]{};
    }
}
