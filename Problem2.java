// Problem  : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
//solved in leetcode and faced no issues
//TC : O(logn) SC : O(1)
//Approach is below in comments

class Solution {
   public int findMin(int[] nums) {
    int start = 0;
    int end = nums.length-1;
    
    // If the array is not rotated 
    if(nums[start] <= nums[end]){
        return nums[0];
    }
    
    while(start <= end){
        int mid = start + (end-start)/2;
        
        // If mid is greater than the next element, next element is the minimum
        if(nums[mid] > nums[mid+1]){
            return nums[mid+1];
        }
        
        // If mid is less than the previous element, mid is the minimum
        if(nums[mid] < nums[mid-1]){
            return nums[mid];
        }
        
        // If mid is greater than or equal to start, minimum is in right half
        if(nums[mid] >= nums[start]){
            start = mid+1;
        } 
        // Otherwise, minimum is in left half
        else{
            end = mid-1;
        }
    }
    
    return -1;
}
}
