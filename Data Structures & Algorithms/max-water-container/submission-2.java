class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;

        int result = 0;

        while (l != r) {
            int lBar = heights[l];
            int rBar = heights[r];

            int contains = (lBar > rBar ? rBar : lBar) * (r - l);

            if (contains > result) {
                result = contains;
            }
            
            if (lBar > rBar) {
                r--;
            } else {
                l++;
            }
        }

        return result;
    }
}
