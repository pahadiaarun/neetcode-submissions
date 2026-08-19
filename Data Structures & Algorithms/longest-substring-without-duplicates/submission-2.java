class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            while (l < i && set.contains(s.charAt(i))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(i));
            maxLen = Math.max(maxLen, i - l + 1);
        }
        return maxLen;
    }
}
