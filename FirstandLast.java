class Solution {
    public int firstIndexBS(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != nums[mid]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;
    }
    
    public int lastIndexBS(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] != nums[mid]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1}; // Corrected syntax for creating an array
        }
        int first = firstIndexBS(nums, low, high, target); // Added missing variable declaration
        if (first == -1) {
            return new int[] {-1, -1}; // Corrected syntax for creating an array
        }
        int last = lastIndexBS(nums, first, high, target); // Added missing variable declaration
        return new int[] {first, last}; // Corrected syntax for creating an array
    }
}
