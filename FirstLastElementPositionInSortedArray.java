// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 need 2 indices and divide the array by doing binary search for finding each indices
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null) return null;
        int start=0, end = nums.length-1;
        if(nums.length==1 ){
            if(nums[0]==target){
                return new int[]{0,0};
            } else {
                return new int[]{-1,-1};
            }
        }
        return new int[]{findFirst(nums, target),findLast(nums, target)};
    }

    private int findFirst(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

    private int findLast(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start +(end -start) / 2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }
}