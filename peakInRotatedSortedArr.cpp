// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    int findPeakElement(vector<int>& nums) 
    {
        int n = nums.size()-1;
        if(nums.size() ==1)
        {
            return 0;
        }
        else if (nums[0]>nums[1])
        {
            return 0;
        }
        else if(nums[n] > nums[n-1])
        {
            return n;
        }
        int left = 1;
        int right = nums.size()-2;
        int mid = 0;
        while(left<=right)
        {
            mid = (left+right)/2;

            if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1])
            {
                return mid;
            }
            if(nums[mid]<nums[mid-1])
            {
                right = mid -1;
            }
            else
            {
                left = mid + 1; 
            }
        }
        return -1;
    }
};