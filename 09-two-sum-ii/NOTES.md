# 09 - Two Sum II, Input Array Is Sorted (LeetCode 167)

**Idea:** The array is sorted, so put `left` at the first number and `right` at the last. Look at `numbers[left] + numbers[right]`:
- equal to the target: return the two positions
- too big: move `right` down, because it is paired with the smallest remaining number and the sum is still too large
- too small: move `left` up, because it is paired with the largest remaining number and the sum is still too small

**Why throwing a number away is safe:** if `left` + `right` is already too big, then `right` plus any other number at or after `left` is also too big, because the array is sorted. So `right` can never be part of the answer and can be dropped for good. The same logic works for `left` when the sum is too small.

**1-based answer:** the problem wants positions starting from 1, but Java arrays start at 0, so I return `left + 1` and `right + 1`.

**Complexity:** O(n) time, because each pointer only moves in one direction. O(1) extra space.

**Why not the HashMap from Two Sum:** it works, but uses O(n) extra memory and ignores that the array is sorted. This problem requires constant extra space.

**Mistakes:**
- I first reused the Two Sum HashMap approach, which breaks the constant-space rule.
- I returned the values (2, 7) instead of positions.
- I looped over 1-based indexes in a 0-based Java array.
- I wrote the pointer moves in my notes but forgot them in the code, so the loop would never end.
