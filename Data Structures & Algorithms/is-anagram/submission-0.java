class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] charCountOfs = new int[26];
        int[] charCountOft = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCountOfs[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            charCountOft[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (charCountOfs[i] != charCountOft[i]) {
                return false;
            }
        }
        return true;
    }
}
