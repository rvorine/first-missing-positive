public class FirstMissingPositive {

    static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // cyclic sort: put every value v in 1..n at index v - 1
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int j = nums[i] - 1;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));           // 3
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));       // 2
        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));   // 1
    }
}
