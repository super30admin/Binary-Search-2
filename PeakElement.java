// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
//Approach: The peak element will be greater than its neighbours and going in the direction of the greater element as compared to the mid element
//will ensure that we have one of the peaks. so we search in that range or else in the other direction. 
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length ==0)return -1;
        if(nums.length ==1) return 0;
        int low =0; 
        int high = nums.length -1;
        while (low <= high) {
           int mid = low + (high-low)/2; 
           
           if ((mid == 0 && nums[mid] > nums[mid+1]) || (mid == high && nums[mid] > nums[mid-1]) || (nums[mid] > nums[mid+1]&& nums[mid] > nums[mid-1] ) ) {
                return mid;
           }
           else if (nums[mid+1] > nums[mid]) {
                low = mid+1;
           }
           else{
                high = mid -1;
           }
        }
        return 57834;
    }
}