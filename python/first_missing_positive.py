def first_missing_positive(nums):
    n = len(nums)

    # cyclic sort: put every value v in 1..n at index v - 1
    for i in range(n):
        while 1 <= nums[i] <= n and nums[nums[i] - 1] != nums[i]:
            j = nums[i] - 1
            nums[i], nums[j] = nums[j], nums[i]

    for i in range(n):
        if nums[i] != i + 1:
            return i + 1
    return n + 1


if __name__ == "__main__":
    print(first_missing_positive([1, 2, 0]))            # 3
    print(first_missing_positive([3, 4, -1, 1]))        # 2
    print(first_missing_positive([7, 8, 9, 11, 12]))    # 1
