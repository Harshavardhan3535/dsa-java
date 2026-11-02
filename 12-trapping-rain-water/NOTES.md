# 12 - Trapping Rain Water (LeetCode 42)

**Rule for one bar:** the water above a bar is `min(tallest bar on its left, tallest bar on its right) - its own height`. The shorter wall sets the water level. The bar itself counts in both "tallest" values, so the water is never negative.

## Approach 1: leftMax and rightMax arrays
- `leftMax[i]` = tallest bar from position 0 to i. `leftMax[0] = height[0]`, then `Math.max(leftMax[i-1], height[i])`.
- `rightMax[i]` = tallest bar from i to the end, filled from the right. `rightMax[n-1] = height[n-1]`, then `Math.max(rightMax[j+1], height[j])`.
- Third loop: add `Math.min(leftMax[i], rightMax[i]) - height[i]` for every bar.
- This is the same prefix/suffix idea as Product of Array Except Self, with max instead of product.

## Approach 2: two pointers (O(1) space)
Keep `leftMax` and `rightMax` as single numbers with `left` and `right` at the ends. Process the side with the smaller max, because that side is the bottleneck and a wall at least as tall already exists on the other side. Move that pointer, update its max, and add `max - height[pointer]`.

| Approach | Time | Extra space |
|----------|------|-------------|
| Arrays | O(n) | O(n) |
| Two pointers | O(n) | O(1) |

## Mistakes
- I put `n` (the length) into `leftMax[0]` instead of the first bar, `height[0]`.
- I crossed the two start values: the last bar goes into `rightMax[n-1]` and the first bar into `leftMax[0]`.
- I started the right loop at `n - 1`, which read `rightMax[n]` and went out of bounds. It starts at `n - 2`.
- I used `Math.max` for the water level, but the level is the smaller wall, so it's `Math.min`.
- Sanity check: water can never be negative, so a negative total means a bug.
