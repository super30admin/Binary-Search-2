// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * https://leetcode.com/problems/find-peak-element/submissions/
 * 
 *
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        
        if(nums.length==1) return 0;
        
        while(low < high) {
            int mid = low + (high -low)/2;
            
            if(nums[mid] < nums[mid+1]) {
                low = mid + 1;
            } else
                high = mid;
        }
        return low;
    }
   
}