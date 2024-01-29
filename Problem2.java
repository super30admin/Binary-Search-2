// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while(lo <= hi){
            if(nums[lo] <= nums[hi]){
                return nums[lo];
            }

            int mid = lo + (hi-lo)/2;

            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == hi || nums[mid] < nums[mid+1])){
                return nums[mid];
            }
            else if(nums[hi] > nums[mid]){ // right range is sorted
                hi = mid-1; //min would be in unsorted side
            }
            else{
                lo = mid+1;
            }
        }

        return 1;
    }
}