class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> track = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (track.size() > 0 && track.get(target - nums[i]) != null) {
                return new int[] {track.get(target - nums[i]), i};
            }
            track.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
