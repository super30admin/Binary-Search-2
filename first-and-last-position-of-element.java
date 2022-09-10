// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1, -1};
        int[] index = new int[]{-1, -1};
        int left = 0, right = nums.length-1, mid = 0;
        while(left <= right){
            mid = (left + right)/2;
            if(target <= nums[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
            if(target == nums[mid]){
                index[0] = mid;
            }
        }
        left = 0; right = nums.length-1; mid = 0;
         while(left <= right){
            mid = (left + right)/2;
            if(target < nums[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
            if(target == nums[mid]){
                index[1] = mid;
            }
        }
        return index;
    }   
}