// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I found it difficult to solve this problem. I got a time exceeded error. 
// Finally understood by drawing the behavior of pointers on a graph and seeing how low and high merge together 
// and finally low ends up reaching the index of the peak element.

// Your code here along with comments explaining your approach

class Solution {
    public int findPeakElement(int[] nums) {
        
        int low = 0, high = nums.length - 1;
        
        while(low < high) {
            
            int mid = low + (high - low) / 2;
            
            // converge such that the range 
            // is lowered and store peak 
            // index
            if (nums[mid] > nums[mid + 1]) {
                // high = 5
                high = mid;
            } else {
                // low = 5
                low = mid + 1;
            }
        }
        return low;
    }
}