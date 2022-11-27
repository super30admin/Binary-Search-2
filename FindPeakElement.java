class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high){
            int mid = low + (high - low )/2;
            
            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length-1 || nums[mid] > nums[mid + 1] )){
                return mid;
            }
            else if(mid>0 && nums[mid -1] > nums[mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}



// Time Complexity : O(logn)
// Space Complexity : O(1), No extra Space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Edge case (mid>0), if we find left higher first we need to use this.
// Your code here along with comments explaining your approach

// The peak element is grater than its neighbours. So after finding mid if we keep on moving higher side we can land into peak number. If we go on smaller side there is a chance that we can find only small numbers than mid.
