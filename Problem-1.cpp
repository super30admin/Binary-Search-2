// Time Complexity : O(log n)

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: One binary search for one first occurance and
// one binary search for last occurance

// Find first and last occurance

#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<int> searchRange(vector<int> &nums, int target)
    {
        vector<int> res;
        int pos1 = first_occurance(nums, target);
        res.push_back(pos1);
        int pos2 = last_occurance(nums, target);
        res.push_back(pos2);
        return res;
    }
    int first_occurance(vector<int> &nums, int target)
    {
        int low = 0, high = nums.size() - 1;
        int mid;
        while (low <= high)
        {
            mid = low + (high - low) / 2;
            if (nums[mid] == target)
            {
                if (mid == 0 || nums[mid - 1] != target)
                {
                    return mid;
                }
                else
                {
                    high = mid - 1;
                }
            }
            else if (nums[mid] < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return -1;
    }

    int last_occurance(vector<int> &nums, int target)
    {
        int n = nums.size();
        int low = 0, high = nums.size() - 1;
        int mid;
        while (low <= high)
        {
            mid = low + (high - low) / 2;
            if (nums[mid] == target)
            {
                if (mid == n - 1 || nums[mid + 1] != target)
                {
                    return mid;
                }
                else
                {
                    low = mid + 1;
                }
            }
            else if (nums[mid] < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return -1;
    }
};