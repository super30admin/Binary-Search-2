// Time Complexity : O(log n)

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: As one part of the array is sorted,
// binary search based on those conditions

// Find min in rotated array

#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int findMin(vector<int> &nums)
    {
        int n = nums.size();
        int low = 0;
        int high = n - 1;
        if (n == 0)
            return -1;
        while (low <= high)
        {
            if (nums[low] < nums[high])
            {
                return nums[low];
            }

            int mid = low + (high - low) / 2;

            if ((mid == 0 || nums[mid] < nums[mid - 1]) &&
                (mid == n - 1 || nums[mid] < nums[mid + 1]))
            {
                return nums[mid];
            }
            else if (nums[low] <= nums[mid])
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