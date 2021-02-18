 // Time Complexity : O(logn) where n is  number of rows, m is no of columns
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't understand what to return, had to see the solution

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;
        
        while(left < right){
            int mid = left+(right-left)/2;
            if(nums[mid] < nums[mid+1]){
                left = mid+1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}
