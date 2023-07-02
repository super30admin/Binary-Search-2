//Find peak element
// Find Minimum in rotated sorted array
// Time Complexity : O(log n) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this: Missed the edge cases
// Your code here along with comments explaining your approach: We need to find mid and check if its neighboring elements are smaller. 
//If they are then we have found the peak,otherwise we have to move to the neighboring element which is greater than mid. 

class Solution {
    public int findPeakElement(int[] nums) {

        int low=0, high=nums.length-1;

        if(nums.length==1) return 0;

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            

            if((mid==0 || nums[mid-1]< nums[mid]) && 
            (mid==nums.length-1 || nums[mid]>nums[mid+1]))
            {
                return mid;
            }

            else if(nums[mid]<nums[mid+1])
            {
                low=mid+1;
            }

            else
            {
                high=mid-1;
            }


        }
        return -1;
        
    }
}