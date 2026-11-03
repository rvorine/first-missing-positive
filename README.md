[![Instagram](https://img.shields.io/badge/Instagram-lacopydepastel-E4405F?style=for-the-badge&logo=instagram&logoColor=white)](https://instagram.com/lacopydepastel)
[![YouTube](https://img.shields.io/badge/YouTube-%40rvorine-FF0000?style=for-the-badge&logo=youtube&logoColor=white)](https://youtube.com/@rvorine)

# First Missing Positive (LeetCode 41)

## Problem

Given an unsorted integer array `nums`, return the **smallest missing positive integer**. Your solution must run in **O(n) time** and use **O(1) extra space**.

Example:

```
Input:  [1, 2, 0]             Output: 3
Input:  [3, 4, -1, 1]         Output: 2
Input:  [7, 8, 9, 11, 12]     Output: 1
```

## Solution

**Cyclic sort** — use the array itself as a hash table.

With `n` elements, the answer is always in `1..n+1`. So only values in `1..n` matter, and value `v` belongs at index `v - 1`.

1. For each index `i`, while `nums[i]` is in `1..n` and is not already at its home (`nums[nums[i] - 1] != nums[i]`), swap it into place.
2. Scan again: the first index where `nums[i] != i + 1` gives the answer `i + 1`.
3. If every slot is correct, the answer is `n + 1`.

The `!=` check also stops infinite swapping on duplicates. Negatives, zeros and values larger than `n` are ignored.

Sorting is O(n log n) and a hash set is O(n) space; cyclic sort meets both limits.

**Time:** O(n) — each swap places one value permanently.
**Space:** O(1) — the input is modified in place.

## Implementations

| Language | File |
|---|---|
| Python | [`python/first_missing_positive.py`](python/first_missing_positive.py) |
| Java | [`java/FirstMissingPositive.java`](java/FirstMissingPositive.java) |
| Kotlin | [`kotlin/FirstMissingPositive.kt`](kotlin/FirstMissingPositive.kt) |
| JavaScript | [`javascript/firstMissingPositive.js`](javascript/firstMissingPositive.js) |
| C# | [`csharp/FirstMissingPositive.cs`](csharp/FirstMissingPositive.cs) |
