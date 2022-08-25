// Time complexity O(logn)
// Space complexity O(1)

// Approach - We run binary search two times. One to get the starting index and the other to get the ending index.
// For the starting index search, we check if the mid point == target, then we check if the left element to the mid is less than the mid or if it is the first element in the list (to avoid array out of bound exception for mid -1). If it is less than mid, we know that this is the starting index for the target. Else, we basically make high as mid -1. Now if the mid point was not equal to the target, we perform regular binary search where we reduce the search space into half by check if target is greater than low and less than mid, we move high to mid - 1 else we move low to mid + 1.
// For the ending index search, we follow the same approach but start the binary search from the starting index (we make starting index as low). This is an optimization as we know that the area left of the starting index is useless to us.

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1,-1};
        
        int startingIdx = binarySearchStarting(nums, target);
        if (startingIdx == -1) return new int[]{-1,-1};
        
        int endingIdx = binarySearchEnding(startingIdx, nums.length-1, nums, target);
        
        return new int[] {startingIdx, endingIdx};
    }
    
    private int binarySearchStarting(int[] nums, int target) {
        int low = 0; int high = nums.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] > nums[mid-1]) {
                    return mid;
                }
                else {
                    high = mid - 1;
                }
            }
            else {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
    
    private int binarySearchEnding(int low, int high, int[] nums, int target) {
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target) {
                if (mid == nums.length-1 || nums[mid] < nums[mid+1]) {
                    return mid;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}