# Binary-Search-2

## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

//Time complexity : O(logm+logn)
//Space complexity : O(1)
//Did it run on leet code : Yes
class Solution {
    public int[] searchRange(int[] nums, int target) {
        //set result as -1,-1
        int[] result = {-1, -1};
        
        int low = 0;
        int high = nums.length - 1;
        //find target's first occurance
        //update result
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(nums[mid] >= target){
                if(nums[mid] == target) result[0] = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        //first element is changed in result means target exists
        //find second occurance or if its single element
        //update result
        if(result[0] > -1){
            low = 0;
            high = nums.length - 1;
            while(low <= high){
                int mid = low + (high - low)/2;

                if(nums[mid] <= target){
                    if(nums[mid] == target) result[1] = mid;
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        //return result
        return result;
    }
}


    





## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:
Input: [3,4,5,1,2]
Output: 1

Example 2:
Input: [4,5,6,7,0,1,2]
Output: 0
//Find Minimum in Rotated Sorted Array
//Time Complexity:O(logn)
//Space Complexity:O(1)
//Did it run on leet code : Yes
class Solution2 {
    public int findMin(int[] nums) {
        //if there array is not rotated or array has only one element
    if(nums[0]<nums[nums.length-1]||nums.length==1){
            return nums[0];
    }
        //comparing mid with first element change decrease high or increase low
        int low =0;
        int high =nums.length-1;
        while(low <= high){
            int mid = (low + high) /2;
            if(nums[mid]>=nums[0]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
      //return low
        return nums[low];
    }
}

## Problem 3: (https://leetcode.com/problems/find-peak-element/)
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 

             or index number 5 where the peak element is 6.

// Find Peak Element
//Time complexity : O(logn)
//Space complexity : O(1)
//Did it run on leet code : Yes
//Time Complexity : O(logn)
//Space Complexity : O(1)
class Solution3 {
    public int findPeakElement(int[] nums) {

        int low=0;
        int high = nums.length-1;
        while(low < high){
            int mid = (low+high) /2;
            //if the mid is greater than mid+1 
            //Assign high as mid
            //else increase low 
            if(nums[mid]>nums[mid+1]){
               high = mid;
            }
            else {
                low = mid +1;
            }
        }
        return low;
    }
}
Note:

Your solution should be in logarithmic complexity.


