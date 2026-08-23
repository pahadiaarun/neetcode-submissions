class Solution {
    public int findMin(int[] nums) {
        int n = nums.length - 1;
        int l = 0;
        int r = nums.length - 1;

        int min = Math.min(nums[l], nums[r]);
        int p = 0;

        while (l < r) {
            int mid = (r + l) / 2;
            System.out.println(mid);
            if (nums[mid] > nums[r]) {
                l = mid;
            } else {
                r = mid;
            }
            if (r - l == 1) {
                if (nums[r] < nums[l]) {
                    l = r;
                }
                break;
            }
        }

        return nums[l];
    }
}
