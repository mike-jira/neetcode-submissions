class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        OptionalInt max = Arrays.stream(piles).max();
        int right = max.getAsInt();
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int times = 0;

            for (int i = 0; i < piles.length; i++) {
                int time = (piles[i] + mid - 1) / mid;
                times += time;
            }

            if (times <= h) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
