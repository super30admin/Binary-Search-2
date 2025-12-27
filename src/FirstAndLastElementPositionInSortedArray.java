/*
Approach:
Perform a binary search to locate the first index where the target appears.
If the target is not found, return [-1, -1] immediately.
Otherwise, find the last index using a second binary search and return both.
Time Complexity : O(log n)
// Did this code successfully run on Leet code : Yes
// Any problem you faced while coding this : NO
Space Complexity:
  O(1)
 */

public class FirstAndLastElementPositionInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int first  = binarySearchFirst(nums,target,0,nums.length-1);
        if(first == -1) return new int[]{-1, -1};
        int last  = binarySearchLast(nums,target,first,nums.length-1);
        return new int[]{first, last};
    }
    private int binarySearchFirst(int[] nums, int target, int low, int high) {
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid-1] != target)
                return mid;
                else
                    high = mid - 1;
            }
            else if(nums[mid] < target) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
    private int binarySearchLast(int[] nums, int target, int low, int high) {
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == nums.length - 1 || nums[mid+1] != target)
                    return mid;
                else low = mid+1;
            }
            else if(nums[mid] < target) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}
