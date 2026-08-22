class Solution {
    public int characterReplacement(String s, int k) {
        int[] charCount = new int[26];
        int l = 0;
        int maxFrequency = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'A']++;
            maxFrequency = Math.max(maxFrequency, charCount[s.charAt(i) - 'A']);
            int currentWindowSize = i - l + 1;
            int replacementsNeeded = currentWindowSize - maxFrequency;
            if (replacementsNeeded > k) {
                charCount[s.charAt(l) - 'A']--;
                l++;
            }
            maxLen = Math.max(maxLen, i - l + 1);
        }
        return maxLen;
    }
}
