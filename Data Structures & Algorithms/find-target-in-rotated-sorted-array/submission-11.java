class Solution {
    public int search(int[] nums, int target) {
        return bisectionSearch(0, nums.length - 1, nums, target);
    }

    public int bisectionSearch(int left, int right, int[] nums, int target) {
        int mid = left + (right - left) / 2;

        if (left > right) {
            return -1;
        }

        if (nums[mid] == target) {
            return mid;
        }

        if (nums[left] <= nums[mid]) {
            // it on the left
            if (nums[left] <= target && target <= nums[mid]) {
                return bisectionSearch(left, mid, nums, target);
            } else {
                return bisectionSearch(mid + 1, right, nums, target);
            }
        } else {
            if (nums[mid] <= target && target <= nums[right]) {
                return bisectionSearch(mid + 1, right, nums, target);
            } else {
                return bisectionSearch(left, mid, nums, target);
            }
        }
    }
}
