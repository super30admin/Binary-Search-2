// Time Complexity : O(log n), since we are discarding half range by moving in direction where value is greater
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 


// Your code here along with comments explaining your approach

class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length -1;

        while(lo <= hi){
            int mid = lo + ( hi-lo)/2;

            // when mid is peak
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == hi || nums[mid] > nums[mid+1])){
                return mid;
            }
            else if( mid !=0 && nums[mid] < nums[mid-1]){ // move to the direction where value is greater
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }

        return 1;
    }
}
