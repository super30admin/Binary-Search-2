// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Missed edge cases
public class Solution {
    public int FindMin(int[] nums) {
        int low = 0;
        int high = nums.Length - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(nums[low] <= nums[high]) {
            return nums[low];
            }
            
            if((mid == 0 || nums[mid] < nums[mid - 1]) && 
            (mid == nums.Length - 1 || nums[mid] < nums[mid + 1]))
            {
                return nums[mid];
            }
            else if (nums[low] <= nums[mid]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return -1;
    }
}