class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target > nums[mid]) {
                // end of array
                if (mid == nums.length - 1) {
                    return mid + 1;
                }
                if (target < nums[mid + 1]) {
                    return mid + 1;
                }
                left = mid + 1;

            } else if (target < nums[mid]) {
                // start of array
                if (mid == 0)  {
                    return mid;
                }
                if (target > nums[mid - 1]) {
                    return mid;
                }
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return nums.length + 1;
    }
}