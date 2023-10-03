//Time: O(logn) and Space: O(n)

class Solution {
    private static int binarySearchFirst(int nums[], int target) {
        int left = 0;
        int high = nums.length - 1;
        
        while (left <= high) {
            int mid = left + (high - left) / 2;
            
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return -1;
    }

    private static int binarySearchLast(int nums[], int target) {
        int left = 0;
        int high = nums.length - 1;
        
        while (left <= high) {
            int mid = left + (high - left) / 2;
            
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        
        int n = nums.length;
        if (nums[0] > target || nums[n - 1] < target) {
            return new int[]{-1, -1};
        }
        
        int first = binarySearchFirst(nums, target);
        int last = binarySearchLast(nums, target);
        
        return new int[]{first, last};
    }
}
