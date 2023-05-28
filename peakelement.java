// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understanding Edge cases


// Your code here along with comments explaining your approach
// even tough this is a unsorted array we can perform binary search as the base condition for binary search is to decrease or increase 
// the search space by 2 times.
// we can find the peak if we move towards the higher side from the mid.
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        if(nums== null || nums.length ==0) return -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if((mid==0 || nums[mid]> nums[mid-1]) && (mid== nums.length-1 ||nums[mid]> nums[mid+1])) return mid;
            if( mid >0 && nums[mid]< nums[mid-1]) 
                high=mid-1;
            else    
                low = mid+1;
        }
        return Integer.MAX_VALUE;   
    }
}