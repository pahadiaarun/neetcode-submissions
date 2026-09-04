class Solution {
    private int solve(int[] nums, int dp[][], int i, int n, int prev) {
        if (i >= n) {
            return 0;
        }
        if (dp[i + 1][prev + 1] != 0) {
            return dp[i + 1][prev + 1];
        }
        if (prev == -1 || nums[i] > nums[prev]) {
            return dp[i + 1][prev + 1] =
                       Math.max(1 + solve(nums, dp, i + 1, n, i), solve(nums, dp, i + 1, n, prev));
        }
        return dp[i + 1][prev + 1] = solve(nums, dp, i + 1, n, prev);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n + 1][n + 1];

        return solve(nums, dp, 0, n, -1);
    }
}
