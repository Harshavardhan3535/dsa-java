# 11 - Container With Most Water (LeetCode 11)

**Idea:** The water between two lines is a rectangle: area = width x the shorter height (water spills over the lower line). Start with `left` and `right` at the two ends, which is the widest container, then move one pointer inward each round and keep the biggest area seen.

**Which pointer moves:** the one on the shorter line.
- The shorter line limits the height, and the width can only get smaller from here, so no other container using that line can beat the current area.
- So that line can be dropped for good.
- Moving the taller pointer would keep the same limiting line with a smaller width, so the area could never improve.

**Complexity:** O(n) time, since the pointers only move inward. O(1) extra space. Checking every pair is O(n^2).

**Mistakes:**
- I tried to add up all the heights and a box surface-area formula. The water is just width x shorter height.
- I set `right = height.length`, but the last position is `length - 1`, so it crashed with an out-of-bounds error.
- I calculated width, height and area once before the `while`, so the area never changed. They must be recalculated every round.
- In my hand trace I moved both pointers. Only the pointer on the shorter line moves, and the other one stays.
