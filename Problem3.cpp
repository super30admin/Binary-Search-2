// Problem - Find peak element
//  Time Complexity : O(logn)
//  Space Complexity : O(1)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

#include <bits/stdc++.h>
using namespace std;

// Explaination
// 1. We reduce our search space by always moving towards the higher side/slope
// 2. Using binary search, we first check mid if it's greater than it's
// neighbors then return it
// 3. Otherwise move to the higher slope side by comparing the one of the
// neighbors, here we move to right if nums[mid+1] > nums[mid]

class Solution {
public:
  int findPeakElement(vector<int> &nums) {
    int n = (int)nums.size();
    int l = 0;
    int r = n - 1;
    while (l < r) {
      int mid = l + (r - l) / 2;
      if ((mid == 0 || nums[mid] > nums[mid - 1]) &&
          (mid == n - 1 || nums[mid] > nums[mid + 1])) {
        return mid;
      } else if (nums[mid + 1] > nums[mid]) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }

    return l;
  }
};
