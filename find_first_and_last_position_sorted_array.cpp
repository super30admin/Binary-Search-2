// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

/*
Leetcode : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
*/

/*
Code Explaination : 
We can divide search in two half.
At first, we will find the first occurance of the element then search last 
occurance in between first_occured_index and high index.
*/


class Solution {
public:

    int findFirst(vector<int>& nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[low] == target) return low;
            if(nums[mid] == target){
                if(mid >0 && nums[mid-1] < nums[mid]){
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if(nums[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }    
        }
        return -1;
    }


    int findLast(vector<int>& nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[high] == target) return high;

            if(nums[mid] == target){
                if(mid<high && nums[mid] < nums[mid+1]){
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    vector<int> searchRange(vector<int>& nums, int target) {
        if (nums.size() == 0) return {-1,-1};

        int first, last;
        int low = 0;
        int high = nums.size()-1;

        first = findFirst(nums, low, high, target);
        if(first == -1) return {-1,-1};

        last = findLast(nums, first, high, target);
        return {first, last};

    }
};