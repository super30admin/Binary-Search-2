// Time Complexity : O(logn)
// Space Complexity : O(1)

class Solution {
    // Perform binary search to find the first position of the target
    // Perform a second binary search from the range of first occurance to the last index of the array to find the last position of the target
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n == 0)
            return new int[] {-1,-1};
        if(target < nums[0] || target > nums[n-1]) //target does not exist
            return new int[]{-1,-1}; 
        int first = binarySearchFirst(nums, 0, n-1, target);
        if(first == -1) //target does not exist
            return new int[]{-1,-1};
        int second = binarySearchLast(nums, first, n-1, target);
        return new int[]{first, second};
    }

    // Function to find the first position of target element
    private int binarySearchFirst(int[] nums, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid] > nums[mid-1])
                    return mid;
                high = mid - 1;
            }
            else if(nums[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // Function to find the last position of target element
    private int binarySearchLast(int[] nums, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == nums.length - 1 || nums[mid] < nums[mid+1])
                    return mid;
                low = mid + 1;
            }
            else if(nums[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}