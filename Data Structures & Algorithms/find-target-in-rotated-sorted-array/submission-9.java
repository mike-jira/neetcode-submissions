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
            // left half is sorted
            if (nums[left] <= target && target < nums[mid]) {
                // target is in left half
                return bisectionSearch(left, mid - 1, nums, target);
            } else {
                // target is in right half
                return bisectionSearch(mid + 1, right, nums, target);
            }

        } else {
            // right half is sorted
            if (nums[mid] < target && target <= nums[right]) {
                // target is in right half
                return bisectionSearch(mid + 1, right, nums, target);
            } else {
                // target is in left half
                return bisectionSearch(left, mid - 1, nums, target);
            }
        }
    }
}
