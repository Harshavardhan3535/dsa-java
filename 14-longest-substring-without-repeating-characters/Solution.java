import java.util.HashSet;
import java.util.Set;

class Solution {

    // Approach 1: sliding window with a HashSet - my own approach, O(n) time
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0;
        int longest = 0;
        for (int right = 0; right < s.length(); right++) {
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                left++;
            }
            window.add(s.charAt(right));
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }

    // Approach 2: last seen index per character (from my full stack training) - O(n) time
    public int lengthOfLongestSubstringLastSeen(String s) {
        int[] lastSeen = new int[256];
        for (int i = 0; i < lastSeen.length; i++) {
            lastSeen[i] = -1;                       // -1 = not seen yet
        }
        int start = 0;
        int max = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (lastSeen[ch] >= start) {            // last seen inside the current window
                start = lastSeen[ch] + 1;           // jump past it
            }
            lastSeen[ch] = end;
            if (end - start + 1 > max) {
                max = end - start + 1;
            }
        }
        return max;
    }
}
