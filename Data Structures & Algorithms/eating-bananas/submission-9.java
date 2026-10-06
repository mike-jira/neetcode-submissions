class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int times = eat(mid, piles);

            if (times <= h) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
    private int eat(int speed, int[] piles) {
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            time += (piles[i] + speed - 1) / speed;
        }
        return time;
    }
}
