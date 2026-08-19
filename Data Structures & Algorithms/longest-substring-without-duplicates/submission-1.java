class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            while (l < i && map.get(s.charAt(i)) != null && map.get(s.charAt(i)) == 1) {
                map.put(s.charAt(l), 0);
                l++;
            }
            map.put(s.charAt(i), 1);
            maxLen = Math.max(maxLen, i - l + 1);
        }
        return maxLen;
    }
}
