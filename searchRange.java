// 34. Find First and Last Position of Element in Sorted Array

// Time Complexity : 
// first BS - log n 
// second BS - log n 
// 2logn = log n 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// [0,1,2,3,4,5,6,7,8,9,10,11,12]
// [1,2,4,6,6,7,7,7,8,8, 8, 9,10]
// first find mid
// if mid is target
// then find leftmost occurrance of target, by checking if left of target is non-target value 
// keep rejecting the right occurance of array and do BS on the left side only
// once you find the first occurrance, do a separate BS from the first occurrance index and find the last occurrance, this time rejecting the left side each time 
// if you dont find the target the first time then return -1 directly 

class Solution {
    public int[] searchRange(int[] nums, int target) {        
        int start = findFirstOccurrance(nums, target);
        if (start<0)
            return new int[]{-1,-1};
        int end = findLastOccurrance(nums, target, start);
        return new int[]{start,end};
    }
    private int findFirstOccurrance(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+ (high-low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] !=target){
                    return mid;
                }
                else
                    high = mid-1;
            }
            else if(nums[mid] < target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
    private int findLastOccurrance(int[] nums, int target, int start) {
        int low = start;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+ (high-low)/2;
            if(nums[mid] == target){
                if (mid == nums.length-1 || nums[mid+1] !=target){
                    return mid;
                }
                else
                    low=mid+1;
            }
            else if(nums[mid] < target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return nums.length-1;
    }
}