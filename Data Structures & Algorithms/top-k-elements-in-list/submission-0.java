class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> uniqueElements = new ArrayList<>(countMap.keySet());
        Collections.sort(uniqueElements, (a, b) -> countMap.get(b) - countMap.get(a));
        int res[] = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = uniqueElements.get(i);
        }
        return res;
    }
}
