// Time Complexity :O(log n)
// Space Complexity :O(1) As array is not an Auxiliary  space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -
class Solution {
    public int findPeakElement(int[] nums) {
        int start=0;
        int end=nums.length-1;
        while(start<end)
        {
            int mid=start+(end-start)/2;
            if(nums[mid]>nums[mid+1])// if greater then we should look towards its left
                end=mid;
            else
                start=mid+1;//else move towards right
                
        }
        return start;
    }
}