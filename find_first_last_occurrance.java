// In this solution, we use binary search to find first and last occurrence of a target in a sorted array.
// Time complexity: O(log n) + O(log n) : O(log n) overall
// Space Complexity: O(1) <-- No extra space is utilized. only variables - so constant

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            int[] result = {-1, -1};
            return result;
        }
        // Call the corresponding binary searchfunctions to find first and last occurrence
        int[] result = {binarySearchFirst(nums, target),binarySearchLast(nums, target)};
        return result;
    }

    // Binary Search Function to find first occurrence
    public int binarySearchFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(nums[mid]== target){
               // If target is already found, we check if num on the left side is also target. 
               // If it is, we start search in left side
                if(mid != 0 && nums[mid - 1] == target){
                    high = mid - 1;
                }
                // Otherwise we can conclude there are no occurrences of the target on the left
                // so the current num is the first occurrence
                else {
                    return mid;
                }
            }
            // Target is not on mid so we try to find target using normal approach 
            else {
                if(nums[mid] < target){
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    // Binary Search Function to find last occurrence
    public int binarySearchLast(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while(low <= high){
            mid = low + (high - low) / 2;
            // If target is already found, we check if num on the right side is also target. 
            // If it is, we start search in right side
            if(nums[mid]== target){
                if(mid != nums.length - 1 && nums[mid + 1] == target){
                    low = mid + 1;
                }
                else {
                    return mid;
                }
            }
            // Otherwise we can conclude there are no occurrences of the target on the right
            // so the current num is the last occurrence
            else {
                if(nums[mid] < target){
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
