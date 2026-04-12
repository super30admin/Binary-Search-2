// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {
    public int findMin(int[] nums) {
        int high = nums.length - 1;
        int low = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[low]<nums[high]){
                return nums[low];
            }
            if((mid == 0 || nums[mid]<nums[mid -1]) && (mid == nums.length - 1 || nums[mid] < nums[mid+1])){
                return nums[mid];
            }
            if(nums[low]<=nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }
}