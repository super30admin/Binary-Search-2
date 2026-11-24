/* 
Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

Time Complexity: 
Finding the first matching index: O(log n)
Finding the last matching index: O(log n)
Therefore, the total is O(log n) + O(log n) = O(log n).

Space Complexity:O(1)

Ran successfully on leetcode

Approach of solving this problem is applying binary search on the array
suppose we have array of nums = [5,7,7,8,8,10], target = 8 then we should return [3, 4]
we are using two binary search functions to find the first and last index of the target value in the array.



*/ 
class Solution {
    public int[] searchRange(int[] nums, int target) {
        

        int first = binarySearchFirst(nums, target, 0, nums.length-1);

        if(first == -1) return new int[]{-1,-1};

        int last = binarySearchLast(nums, target, first, nums.length-1);

        return new int[]{first, last};
    }

    private int binarySearchFirst(int[] nums, int target, int low, int high){

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] != target){
                    return mid;
                }else{
                    high = mid - 1;
                }
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }

    private int binarySearchLast(int[] nums, int target, int low, int high){

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid+1] != target){
                    return mid;
                }else{
                    low = mid + 1;
                }
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }
}