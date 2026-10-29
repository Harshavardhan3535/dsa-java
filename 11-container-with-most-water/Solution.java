class Solution {

    // Two pointers: always move the pointer on the shorter line - O(n) time, O(1) space
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int area = width * h;
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;         // left line is the bottleneck: drop it
            } else {
                right--;        // right line is the bottleneck (or equal): drop it
            }
        }
        return maxArea;
    }
}
