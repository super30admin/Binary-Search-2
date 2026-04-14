
// Time Complexity :O(LogN)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three sentences only
// I made use of the solution discussed in class.
// We make use of 2 seperate binary search
//peak element is the element which is greater than its previous and next element
// We find the mid element check edge cases and also check if its greater than previous and next element
// If mid is the peak element we return mid
// else we check which side we can move it can be either left or right
// We keep moving towards the peak (keep mountain in mind) , somewhere we will find the peak element and return it. We can move towards the side which is greater than mid because we know that there is a peak element on that side. We keep moving towards the peak element and return it when we find it.

class Solution {
    public int findPeakElement(int[] nums) {

        int low=0, high=nums.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;

            if((mid==0|| nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1]))
            {
                return mid;
            }

            else if(nums[mid+1]>nums[mid])
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