// Time Complexity : O(log n)
// Space Complexity : O(1), no extra space needed

// Did this code successfully run on Leetcode : Q: 34
// Any problem you faced while coding this :
public class FindFirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if(nums == null || nums.length == 0)
            return result;

        int n = nums.length;
        // nums array is sorted
        // For TC to be O(log n) we will have to do binary search

        //  0, 1, 2, 3, 4, 5, 6, 7, 8,  9,  10, 11, 12, 13  <- Index
        // [1, 8, 8, 8, 8, 9, 9, 9, 10, 11, 12, 13, 14, 14]
        //  L                 M                          H
        // nums[mid] < target, so move to the left

        //  0, 1, 2, 3, 4, 5, 6, 7, 8,  9,  10, 11, 12, 13  <- Index
        // [1, 8, 8, 8, 8, 9, 9, 9, 10, 11, 12, 13, 14, 14]
        //  L     M        H
        // check if nums[mid] == target,
        //      if yes, then compare it with left to see if its the 1st occurrence
        //          if left is same as target the do a binary search on left side to find 1st occurrence
        //          if not, then mid is the first occurrence
        // repeat same to find last occurrence as well but in a separate BS function

        // we have to perform to separate BS to find first and last occurrence

        int low = 0;
        int high = n-1;

        int firstOccurrence = searchF(nums, low, high, target);
        int lastOccurrence = searchL(nums, low, high, target);

        return new int[]{firstOccurrence, lastOccurrence};
    }

    public int searchF(int[] nums, int low, int high, int target){
        while(high >= low){
            // calculate mid
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                // check if mid is the first occurrence
                if(mid == 0 || nums[mid] > nums[mid-1]) {
                    // mid is first
                    return mid;
                } else {
                    // keep moving left until we find 1st
                    high = mid - 1;
                }
            } else if (nums[mid] > target){
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int searchL(int[] nums, int low, int high, int target){
        while(high >= low) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                // check if its the last
                if(mid == nums.length - 1 || nums[mid] < nums[mid+1]){
                    return mid;
                } else{
                    // if right is equal to target then move to right side
                    low = mid + 1;
                }
            } else if(nums[mid] > target) {
                // move to the left side
                high = mid - 1;
            } else {
                // move to the right side
                low = mid + 1;
            }

        }
        return -1;
    }
}
