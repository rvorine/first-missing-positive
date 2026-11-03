function firstMissingPositive(nums) {
  const n = nums.length;

  // cyclic sort: put every value v in 1..n at index v - 1
  for (let i = 0; i < n; i++) {
    while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] !== nums[i]) {
      const j = nums[i] - 1;
      [nums[i], nums[j]] = [nums[j], nums[i]];
    }
  }

  for (let i = 0; i < n; i++) {
    if (nums[i] !== i + 1) return i + 1;
  }
  return n + 1;
}

console.log(firstMissingPositive([1, 2, 0]));          // 3
console.log(firstMissingPositive([3, 4, -1, 1]));      // 2
console.log(firstMissingPositive([7, 8, 9, 11, 12]));  // 1

module.exports = { firstMissingPositive };
