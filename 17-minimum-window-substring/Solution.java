class Solution {

    // Sliding window: grow right until valid, shrink left while valid - O(m + n) time, O(1) space
    public String minWindow(String s, String t) {
        int[] need = new int[128];              // how many of each letter are still needed
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int missing = t.length();               // letters of t still missing from the window
        int left = 0;
        int bestStart = 0;
        int bestLen = s.length() + 1;           // bigger than any real window

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (need[c] > 0) {
                missing--;                      // this letter was really needed
            }
            need[c]--;                          // extra copies go negative

            while (missing == 0) {              // window is valid: try to shrink it
                if (right - left + 1 < bestLen) {
                    bestStart = left;
                    bestLen = right - left + 1;
                }
                char d = s.charAt(left);
                need[d]++;
                if (need[d] > 0) {
                    missing++;                  // d was really needed: window is invalid again
                }
                left++;
            }
        }
        if (bestLen > s.length()) {
            return "";                          // no valid window was ever found
        }
        return s.substring(bestStart, bestStart + bestLen);
    }
}
