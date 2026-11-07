class Solution {

    // Sliding window: valid while (window length - highest count) <= k - O(n) time, O(1) space
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxCount = 0;       // highest count seen in any window so far
        int longest = 0;
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
            if ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;      // window needs too many changes: slide it
                left++;
            }
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}
