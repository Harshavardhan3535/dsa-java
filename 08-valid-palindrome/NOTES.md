# 08 - Valid Palindrome (LeetCode 125)

**Cleanup (both approaches):** make the string lowercase, then remove everything that is not a letter or digit with `replaceAll("[^a-z0-9]", "")`. The problem says to ignore case, spaces and punctuation.

## Approach 1: reverse and compare
Loop backwards from `s.length() - 1` down to 0, add each character to `reverse`, then return `s.equals(reverse)`.

## Approach 2: two pointers
Put `left` at the start and `right` at the end. While `left < right`, compare the two characters. If they differ, return false. If they match, move both inward. If the loop finishes, return true. It can stop early at the first mismatch, and it needs no second string.

| Approach | Time | Extra space |
|----------|------|-------------|
| Reverse and compare | O(n^2) as written, because `reverse +=` copies the string each time (O(n) with a StringBuilder) | O(n) |
| Two pointers | O(n) | O(n) for the cleaned string (O(1) if I skip non-alphanumerics in place with `Character.isLetterOrDigit`) |

## Mistakes
- I first handled only lowercase and forgot the rule about ignoring non-alphanumeric characters.
- I used two nested loops to build the reversed string, but one backwards loop is enough.
- I started the loop at `s.length()` and used `j < s.length() - 1`, so it never ran. The last position is `s.length() - 1`, and a downward loop runs while `j >= 0`.
