//TC: O(logn)
//SC: O(1)
//Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: In a rotated sorted array, one side of the array is always sorted, 
class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            // if the subarray is sorted, return element at start
             if(nums[start] <= nums[end]){
                return nums[start];
            }
            int mid = start + (end - start) / 2;
            if((mid == 0 || nums[mid] < nums[mid - 1]) && 
            (mid == nums.length - 1 || nums[mid] < nums[mid + 1]))
                return nums[mid];
            else if(nums[start] <= nums[mid]) // left sorted
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}