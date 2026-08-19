class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anaMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String keyStr = new String(charArr);
            anaMap.computeIfAbsent(keyStr, k -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(anaMap.values());
    }
}
