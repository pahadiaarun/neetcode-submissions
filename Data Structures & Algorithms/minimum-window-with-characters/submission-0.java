class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        int[] targetCounts = new int[128];
        int[] windowCounts = new int[128];

        int need = 0;

        for (int i = 0; i < t.length(); i++) {
            if (targetCounts[t.charAt(i)] == 0) {
                need++;
            }
            targetCounts[t.charAt(i)]++;
        }

        int l = 0;
        int have = 0;

        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;

        for (int i = 0; i < s.length(); i++) {
            windowCounts[s.charAt(i)]++;
            if (targetCounts[s.charAt(i)] > 0
                && windowCounts[s.charAt(i)] == targetCounts[s.charAt(i)]) {
                have++;
            }
            while (have == need) {
                if (i - l + 1 < minLen) {
                    minLen = i - l + 1;
                    startIdx = l;
                }
                windowCounts[s.charAt(l)]--;
                if (targetCounts[s.charAt(l)] > 0
                    && windowCounts[s.charAt(l)] < targetCounts[s.charAt(l)]) {
                    have--;
                }
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
