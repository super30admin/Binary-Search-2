// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

// Your algorithm's runtime complexity must be in the order of O(log n).

// If the target is not found in the array, return [-1, -1].

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:

// Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]


include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    
    int findFirst(vector<int>& nums, int target)
    {
        int low = 0;
        int high = nums.size() - 1;
        int res = -1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
            {
                res = mid;
                high = mid - 1;
            }
            else if(nums[mid] > target){
                high = mid -1;
            }
            else
            {
                low = mid +1;
            }
        }
        return res;
    }
    
      int findLast(vector<int>& nums, int target){
        int low = 0;
        int high = nums.size() - 1;
        int res = -1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
            {
                res = mid;
                low = mid + 1;
                
            }
            else if(nums[mid] > target){
                high = mid -1;
            }
            else
            {
                low = mid +1;
            }
            
        }
        return res;
    }
    
    vector<int> searchRange(vector<int>& nums, int target)
    {
        vector<int> answer;
        answer.push_back(findFirst(nums,target));
        answer.push_back(findLast(nums, target));
        return answer;
    }
};