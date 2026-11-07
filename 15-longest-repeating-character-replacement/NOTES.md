# 15 - Longest Repeating Character Replacement (LeetCode 424)

**Idea:** In a window, keep the most frequent letter and change all the others. The number of letters to change is `window length - highest count`. The window is valid while that is at most `k`.

**Direction does not matter:** each replacement can turn a letter into any other letter, so I change the minority letters in the window to the majority letter.

**Algorithm:**
1. Keep a `count` array of 26 counters (the input is capital letters; `ch - 'A'` gives the position).
2. For each `right`: add the new letter, then update `maxCount` with `Math.max`.
3. If `(right - left + 1) - maxCount > k`, the window needs too many changes, so remove the letter at `left` and move `left` up. The window slides at the same size.
4. Update `longest` with the window length `right - left + 1`.

**Why `maxCount` is never lowered:** it is the highest count seen in any window so far. When it is stale, the window only slides at the same size as an earlier real answer. The window can grow only when a letter makes a count higher than any before, and then `maxCount` really increases. So `longest` is never too big. This is why one `if` is enough instead of a `while`.

**Complexity:** O(n) time, O(1) extra space (26 counters).

**Mistakes:**
- I used a `HashSet` of letters, but this problem needs how many times each letter appears, so I need counters.
- I wrote `Math.max(maxCount, count)`, comparing a number with the whole array. It must be the counter of one letter, `count[s.charAt(right) - 'A']`.
- I first thought I could only change one direction (A to B). Both directions are allowed, and I pick whichever needs fewer changes.
