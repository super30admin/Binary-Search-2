// Time Complexity :O(log n)
// Space Complexity :O(1) As array is not an Auxiliary  space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -
class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1)
            return nums[0];
		// as it is rotated there will be two sorted subarrays in the array
        int left=nums[0]; // getting min element of the first subarray
        int right=binarySearchRight(nums); // getting the min element of the second sub array for which we dont know the starting index
        return Math.min(left,right); // whichever is min in both will be returned
    }

    private int binarySearchRight(int nums[])
    {
        int start=0;
        int end=nums.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(mid-1>=0 && nums[mid-1]<nums[end]) // if the mid is not the starting index of the subarray
            {
                end=mid-1;
            }
            else if(nums[mid]<=nums[end]) // if mid is the starting index of the subarray
            {
               
                return nums[mid];
            }
 
            else{
                start=mid+1; // if mid>end
            }
        }
        
      return -1;
        
    }
}