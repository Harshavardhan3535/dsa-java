# 10 - 3Sum (LeetCode 15)

**Idea:** Sort the array. Fix the first number at position `i`. The rest is Two Sum II on the numbers after `i`: `left` starts at `i + 1`, `right` starts at the end, and the three numbers must add up to 0.
- sum is 0: add the triplet, then move both pointers
- sum too small: `left++`
- sum too big: `right--`

**Duplicates are judged by values, not positions.** `[-1,0,1]` and `[0,1,-1]` are the same triplet. Sorting puts equal numbers next to each other, so repeats are easy to skip:
- skip `i` when `nums[i]` equals `nums[i - 1]` (with `i > 0`, so I never read `nums[-1]`)
- after a hit, move `left` forward while it points at the same number as the one before it

**Complexity:** O(n^2) time. Sorting is O(n log n), and for each `i` the two pointers walk the rest once. O(1) extra space apart from the sort and the output. Brute force with three loops is O(n^3).

**Mistakes:**
- I started with three nested loops, which is O(n^3) and returns the same triplet in different orders.
- I started `left` at 0 instead of `i + 1`, so the pointers could reuse earlier numbers.
- I computed the sum once before the `while` and used `continue` when it was negative, which skipped valid answers. A negative sum means `left` is too small, so it must move inside the loop.
- I forgot the duplicate skips, so `[0,0,0,0]` returned two triplets instead of one.
- Run only tests the 3 sample cases, while Submit tests all hidden cases. The real result is the one from Submit.
