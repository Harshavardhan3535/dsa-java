# 16 - Permutation in String (LeetCode 567)

**Idea:** A permutation of `s1` is any rearrangement of its letters, so a window of `s2` is a permutation of `s1` exactly when it has the same length and the same letter counts. Slide a fixed-size window (length = `s1.length()`) over `s2` and compare the counts at every step.

**Steps:**
1. If `s1` is longer than `s2`, return false.
2. Fill `need` (26 counters) from `s1`.
3. For each `right` in `s2`: add that letter to `have`. Once `right >= s1.length()`, the window is too long, so remove the letter at `right - s1.length()`.
4. If `Arrays.equals(need, have)`, return true. If the loop ends, return false.

**Complexity:** O(n) time (each step compares 26 counters, so about 26n), O(1) space.

**Mistakes:**
- I thought "`s2` contains the reverse of `s1`" was enough, but the reverse is only one of the permutations. `abc` and `bca` is a counter-example.
- I compared whole strings, like Valid Anagram, but `s2` is longer: only a window of the same length as `s1` must match.
- I put `return false` right after the `if`, so it ended after one check. `return false` goes after the loop, and only `return true` goes inside it.
- I wrote `Array.equal` instead of `Arrays.equals`.
