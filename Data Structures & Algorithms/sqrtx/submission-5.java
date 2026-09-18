class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int left = 1;
        int right = x / 2;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long temp = (long) mid * mid;

            if (temp < x) {
                result = mid;
                left = mid + 1;
            } else if (temp > x) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return result;
    }
}