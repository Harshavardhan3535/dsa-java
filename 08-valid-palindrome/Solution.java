class Solution {

    // Approach 1: build the reversed string and compare - my own approach
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");
        String reverse = "";
        for (int j = s.length() - 1; j >= 0; j--) {
            reverse += s.charAt(j);
        }
        return s.equals(reverse);
    }

    // Approach 2: two pointers (approach learned from a LeetCode solution)
    public boolean isPalindromeTwoPointers(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;       // mismatch: not a palindrome
            }
            left++;
            right--;
        }
        return true;
    }
}
