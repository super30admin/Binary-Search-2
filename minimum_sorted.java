// Time Complexity : O(log)n
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO

class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            if(nums[low] <= nums[high]){ // the array is sorted
                return nums[low];
            }
            int mid = low + (high - low)/2;
            
            if((mid == 0 || nums[mid] < nums[mid -1]) || (mid == nums.length -1 || nums[mid] < nums[mid +1])) return nums[mid];
            
            if(nums[low] <= nums[mid]){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }
}