class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int mxArea = 0;
        while (l < r) {
            int area = Math.min(heights[l], heights[r]) * (r - l);
            mxArea = Math.max(mxArea, area);
            if (heights[l] <= heights[r])
                l++;
            else
                r--;
        }
        return mxArea;
    }
}
