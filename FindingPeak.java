/**

A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. 
If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.


Time Complexity : O(logN)
Space Complexity : O(1)
Did this code successfully run on Leetcode : YES
Any problem you faced while coding this : checking some boundary conditions

Collabedit: http://collabedit.com/q6xmg

Input: nums = [1,2,1,3,5,6,4]
Output: 5

peek element conditions size > 1

    if mid == start
        check nums[mid] > nums[mid+1]
    else mid == end 
        check nums[mid] > nums[mid -1]
    else {
        
        if( nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1] )
            return mid;
        else if(nums[mid] < nums[mid-1]) 
            high = mid -1;
        else
            low = mid +1;
    }

algorithm:
    perform the binary search
    compute the middle and which ever side we have the greater element, consider that side of the array
    if both the elements are greater than the middle that we can go on any side
    
    the binary search can be applied to unsorted array as well, the only requirement is that 
    at each iteration the search space is reduced to half the size
    
    


**/

class Solution {

    public int findPeakElement(int[] nums) {
    
        if(nums == null) return -1;
        
        if(nums.length == 1) return 0;
        
        if(nums.length == 2) return nums[0]> nums[1] ? 0 : 1;
        
        int start =0;
        int end = nums.length -1;
        
        int low = start;
        int high = end;
        
        while (low <= high) {
        
            int mid = low + (high -low)/2;
            
            if ((mid == end || nums[mid] > nums[mid+1]) && ( mid == start || nums[mid] > nums[mid-1])) return mid;
            else if(mid > 0 && nums[mid] < nums[mid-1]) 
                    high = mid - 1;
                else
                    low = mid + 1;
            
        }
        
        return -1;
        
    }
}