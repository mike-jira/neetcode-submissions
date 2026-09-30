class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int i = 0;
        int[] result = new int[temperatures.length];

        while (i < temperatures.length) {
            int j = i + 1;
            int streak = 0;
            
            while (j < temperatures.length) {
                if (temperatures[j] > temperatures[i]) {
                    streak++;
                    result[i] = streak;
                    break;
                } else {
                    streak++;
                    j++;
                }
            }
            i++;
        }

        return result;
    }
}