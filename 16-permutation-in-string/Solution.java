import java.util.Arrays;

class Solution {

    // Fixed-size sliding window: compare letter counts of s1 and the current window of s2
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;                       // a window can never be longer than s2
        }
        int[] need = new int[26];               // letter counts of s1
        int[] have = new int[26];               // letter counts of the current window
        for (int i = 0; i < s1.length(); i++) {
            need[s1.charAt(i) - 'a']++;
        }
        for (int right = 0; right < s2.length(); right++) {
            have[s2.charAt(right) - 'a']++;                         // letter enters
            if (right >= s1.length()) {
                have[s2.charAt(right - s1.length()) - 'a']--;       // letter leaves
            }
            if (Arrays.equals(need, have)) {
                return true;
            }
        }
        return false;
    }
}
