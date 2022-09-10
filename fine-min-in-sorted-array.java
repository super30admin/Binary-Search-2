// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int min = Integer.MAX_VALUE;
        if(nums[low] < nums[high] || nums[low] == nums[high]){
            return nums[low];
        }
        if(nums.length == 2){
            if(nums[low] < nums[high]){
                return nums[low];
            }else{
                return nums[high];
            }
        }
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid] < nums[mid-1]){
                return nums[mid];
            }
            if(nums[low] < nums[mid]){
                low = mid+1;
            }else{
                high = mid-1;        
            }
        }
        return -1;
    }
}