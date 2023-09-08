// Time Complexity : O(Log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * we can use binary search to always go towards the side where there is an increasing trend as the trend will definitely find a downard movement at the start of end of an array as out of bound elements are always less
 */

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if( (mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length -1 || nums[mid] > nums[mid + 1])){
                return mid;
            }
            else if(mid < nums.length -1 && nums[mid] < nums[mid + 1]){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}