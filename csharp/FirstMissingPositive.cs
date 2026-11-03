using System;

class FirstMissingPositive
{
    static int Solve(int[] nums)
    {
        int n = nums.Length;

        // cyclic sort: put every value v in 1..n at index v - 1
        for (int i = 0; i < n; i++)
        {
            while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i])
            {
                int j = nums[i] - 1;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        for (int i = 0; i < n; i++)
        {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    static void Main()
    {
        Console.WriteLine(Solve(new int[] { 1, 2, 0 }));           // 3
        Console.WriteLine(Solve(new int[] { 3, 4, -1, 1 }));       // 2
        Console.WriteLine(Solve(new int[] { 7, 8, 9, 11, 12 }));   // 1
    }
}
