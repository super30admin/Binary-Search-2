//Time Complexity : O(logn) + O(logn)



class Solution {
    int binarySearchOne(int []nums, int low,int high, int target) {
       while(low <= high) {
           int mid = low + (high-low)/2;
           if(nums[mid] == target) {
               if(mid == 0 || nums[mid] > nums[mid-1]) {
                   return mid;
               } else {
                   high = mid-1;
               }
           } else if( nums[mid] > target) {
               high = mid-1;
           } else {
               low = mid+1;
           }
    }
    return -1;
    }
    int binarySearchTwo(int []nums, int low,int high, int target) {
         while(low <= high) {
           int mid = low + (high-low)/2;
           if(nums[mid] == target) {
               if(mid == nums.length-1 || nums[mid] < nums[mid+1]) {
                   return mid;
               } else {
                   low = mid+1;
               }
           } else if( nums[mid] > target) {
               high = mid-1;
           } else {
               low = mid+1;
           }
    }
    return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        if(nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        if((nums[0] > target) || (nums[nums.length-1] < target)) {
            return new int[]{-1,-1};
        }
        int firstIndex = binarySearchOne(nums, 0, high, target);
        int secondIndex = binarySearchTwo(nums, firstIndex,high, target);
        return new int[]{firstIndex,secondIndex};
    }
}