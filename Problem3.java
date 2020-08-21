// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : Time limit exceeded. Took a while to analyze all the possibilities.

// Your code here along with comments explaining your approach
// Checking all possibilites and using binary search to find the minimum element.

class Solution {
    //[4,5,6,7,0,1,2]
    public int findMin(int[] nums) {

        int low = 0, high = nums.length - 1;
        
        if (nums.length == 1) return nums[0];
        if(nums[high] > nums[low]) return nums[low];

        while(low <= high) {

            // That means nums[mid + 1] is 
            // the lowest element as the 
            // rotation has occured from 
            // here.
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } 

            // Here nums[mid] is the lowest 
            // element and nums[mid + 1] 
            // is the position where 
            // rotation has occured.
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            // If the mid element is 
            // larger that the 0th 
            // element that means 
            // the minimum element
            // should be on the right
            if (nums[mid] > nums[0]) {
                low = mid + 1;
            }
            // else it will be on the
            // left. 
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}