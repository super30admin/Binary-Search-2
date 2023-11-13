//## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
//
//        Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
//
//        Your algorithm's runtime complexity must be in the order of O(log n).
//
//        If the target is not found in the array, return [-1, -1].
//
//        Example 1:
//
//        Input: nums = [5,7,7,8,8,10], target = 8
//        Output: [3,4]
//        Example 2:
//
//        Input: nums = [5,7,7,8,8,10], target = 6
//        Output: [-1,-1]
public class Q1BS2 {
    public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) return new int[]{-1,-1};
        if(target < nums[0]) return new int[]{-1,-1};
        if(target > nums[nums.length-1]) return new int[]{-1,-1};

    int first = findFirst(nums,target);
        if(first==-1) return new int[]{-1,-1};
    int second = findLast(nums,target,first);
        return new int[]{first,second};
}
    private int findFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length -1;
        while(low <= high){
            int mid = low +(high-low)/2;
            if(nums[mid] == target){
                if(mid == low || nums[mid] != nums[mid-1]){
                    return mid;
                }else{
                    high = mid - 1;
                }
            }else if(nums[mid] > target){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
    private int findLast(int[] nums, int target, int low){
        // int low = 0;
        int high = nums.length -1;
        while(low <= high){
            int mid = low +(high-low)/2;
            if(nums[mid] == target){
                if(mid == high || nums[mid] != nums[mid+1]){
                    return mid;
                }else{
                    low = mid + 1;
                }
            }else if(nums[mid] > target){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }

//    Second Approach
//    public int[] searchRange(int[] nums, int target) {
//        int[] result = new int[2];
//        result[0] = findFirst(nums, target);
//        result[1] = findLast(nums, target);
//        return result;
//    }
//
//    private int findFirst(int[] nums, int target){
//        int idx = -1;
//        int start = 0;
//        int end = nums.length - 1;
//        while(start <= end){
//            int mid = (start + end) / 2;
//            if(nums[mid] >= target){
//                end = mid - 1;
//            }else{
//                start = mid + 1;
//            }
//            if(nums[mid] == target) idx = mid;
//        }
//        return idx;
//    }
//
//    private int findLast(int[] nums, int target) {
//        int idx = -1;
//        int start = 0;
//        int end = nums.length - 1;
//        while (start <= end) {
//            int mid = (start + end) / 2;
//            if (nums[mid] <= target) {
//                start = mid + 1;
//            } else {
//                end = mid - 1;
//            }
//            if (nums[mid] == target) idx = mid;
//        }
//        return idx;
//    }




        // My attempt
        // int low = 0;
        // int count=0;
        // int high = nums.length;
        // int[] ans = new int[2];
        // ans[0]=-1;
        // ans[1]=-1;
        // if(nums.length == 0)
        //      return ans;
        // while(low <= high){
        //      int mid = low + (high - low)/2;
        //      if(target == nums[mid]){
        //          ans[0] = mid;
        //          count = mid;
        //          break;
        //      }
        // else if ( target > nums[mid])
        //          low = mid + 1;
        //     else
        //          high = mid - 1;
        // }
        // if(nums.length > 1)
        //      for(;nums[count]==target;)
        //          count++;
        // ans[1] = count-1;
        // return ans;



}
