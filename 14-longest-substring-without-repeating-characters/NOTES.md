# 14 - Longest Substring Without Repeating Characters (LeetCode 3)

**Window idea:** keep a window between `left` and `right` that never contains a repeated letter. Move `right` forward one letter at a time. A substring must be unbroken, so letters can only be removed from the **left end**.

## Approach 1: HashSet sliding window
- While the set already contains the new letter, remove the letter at `left` and move `left` up. This must be a `while`, not an `if`, because several letters may have to go (for example at the second `w` in `pwwkew`).
- Then add the new letter and update `longest` with the length `right - left + 1`.

## Approach 2: last seen index (array of 256, filled with -1)
- `lastSeen[ch]` is the position where `ch` was last seen.
- If that position is inside the window (`>= start`), jump `start` to one past it.
- Always store the new position, then update the best length.
- The `>= start` check matters: in `abba`, the last `a` was seen at position 0, outside the window, so `start` must not move backward.

| Approach | Time | Extra space |
|----------|------|-------------|
| HashSet window | O(n) | O(k), k = distinct letters |
| Last seen array | O(n) | O(256), constant |

## Mistakes
- I first split the string into separate sequences whenever a letter repeated. That throws away letters that are still fine: in `aabcdabcefgh` the substring `dabcefgh` has 8 unique letters.
- I wrote `window.contains(s.charAt(1))` with a fixed position, so it crashed on a one-letter string. The check must use the same expression as the `add`, `s.charAt(right)`.
- I confused "drop a letter" with "the letter is repeated". Letters before the repeated one must also be dropped, because the window has to stay unbroken.
