fun firstMissingPositive(nums: IntArray): Int {
    val n = nums.size

    // cyclic sort: put every value v in 1..n at index v - 1
    for (i in 0 until n) {
        while (nums[i] in 1..n && nums[nums[i] - 1] != nums[i]) {
            val j = nums[i] - 1
            val tmp = nums[i]
            nums[i] = nums[j]
            nums[j] = tmp
        }
    }

    for (i in 0 until n) {
        if (nums[i] != i + 1) return i + 1
    }
    return n + 1
}

fun main() {
    println(firstMissingPositive(intArrayOf(1, 2, 0)))           // 3
    println(firstMissingPositive(intArrayOf(3, 4, -1, 1)))       // 2
    println(firstMissingPositive(intArrayOf(7, 8, 9, 11, 12)))   // 1
}
