
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int findMin(int[] nums) {
       int n = nums.length;
       int left = 0, right = n - 1;
       while(left <= right){
           if(nums[left] < nums[right])
                return nums[left];
           int mid = left + (right - left)/2;
           if((mid==0 || nums[mid] < nums[mid-1]) && (mid == n - 1 || nums[mid]<nums[mid+1]))
            return nums[mid];
           else if(nums[mid] > nums[right])
               left = mid + 1;
            else
                right = mid - 1;
           }
           return nums[left];
        
       } 
    }