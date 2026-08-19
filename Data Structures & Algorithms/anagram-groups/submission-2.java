class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null) {
                continue;
            }
            String s = strs[i];
            List<String> anaStrs = new ArrayList<>();
            anaStrs.add(s);
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[j] == null) {
                    continue;
                }
                String t = strs[j];
                if (s.length() != t.length()) {
                    continue;
                }
                int[] charCount = new int[26];
                for (int k = 0; k < s.length(); k++) {
                    charCount[s.charAt(k) - 'a']++;
                    charCount[t.charAt(k) - 'a']--;
                }
                boolean isNotAna = false;
                for (int count : charCount) {
                    if (count != 0) {
                        isNotAna = true;
                        break;
                    }
                }
                if (!isNotAna) {
                    anaStrs.add(t);
                    strs[j] = null;
                }
            }
            result.add(anaStrs);
        }
        return result;
    }
}
