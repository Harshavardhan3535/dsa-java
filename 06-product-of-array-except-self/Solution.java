class Solution {

    // Prefix/suffix products in two passes - O(n) time, O(1) extra space
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        // Pass 1: result[i] = product of everything to the LEFT of i
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = left;
            left = left * nums[i];
        }

        // Pass 2: multiply by the product of everything to the RIGHT of i
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right = right * nums[i];
        }
        return result;
    }
}
