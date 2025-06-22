# Binary-Search-2
Explain your approach in **three sentences only** at top of your code

TC = O(log N)
SC = O(1)

//Approach:-
We will apply 2 Binary Searches: 1st to get the first position, and 2nd to get the last position of the element.
If the element is not found, we return [-1, -1].
Each binary search is adjusted to shrink toward the correct boundary (start or end).

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

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int first = firstBinary(nums, target, left, right);
        if(first == -1){
            return new int[] {-1,-1};
        }

        int second = secondBinary(nums, target, left, right);

        return new int[]{first, second};
    }
    public int firstBinary(int[] nums, int target, int left, int right){
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                if(mid > left && nums[mid-1] == target){
                    right = mid-1;
                }
                else{
                    return mid;
                }
            }

            else if(nums[mid] > target){
                right = mid-1;
            }

            else{
                left = mid+1;
            }
        }

        return -1;
    }
    public int secondBinary(int[] nums, int target, int left, int right){
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                if(mid < right && nums[mid+1] == target){
                    left = mid+1;
                }
                else{
                    return mid;
                }
            }

            else if(nums[mid] > target){
                right = mid-1;
            }

            else{
                left = mid+1;
            }
        }

        return -1;
    }
}

## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
TC = O(log N)
SC = O(1)
//Approach:-
The minimum lies in the unsorted portion, and if the array is already sorted we return nums[left].
We calculate mid and check if it’s the minimum by comparing it to its neighbors.
If not, we move to the unsorted half by adjusting left and right pointers accordingly.

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
Note:

Your solution should be in logarithmic complexity.


