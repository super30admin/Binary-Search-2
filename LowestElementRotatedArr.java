
// Time Complexity :O(LogN)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Confused about checking the opposite of sorted side
// Your code here along with comments explaining your approach in three sentences only
// Always note that rotated array is made up of 2 sorted arrays.
//  We can make use of this property to find the minimum element in the array.
// First we check if the element at low is less than or equal to element at high because then low is the minimum element in the array and we can return it.
// If the above condition is not satisfied then we find the mid element and check if it is the minimum element by comparing it with its previous and next element.
// If mid is the minimum element then we return 
// else we check if the left / right part of the array is sorted , if its sorted then we always check opposite side for answer because the minimum element will always lie in the unsorted part of the array.



class Solution {
    public int findMin(int[] nums) {

        int low=0,high=nums.length-1;

        while(low<=high)
        {
            if(nums[low]<=nums[high])
            {
                return nums[low];
            }
            int mid=low+(high-low)/2;

            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length-1 || nums[mid] < nums[mid + 1]))
            {
            return nums[mid];
            }
            else if(nums[low]<=nums[mid])
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