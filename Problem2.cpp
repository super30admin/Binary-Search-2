// Problem - Find minimum in rotated sorted array
//  Time Complexity : O(logn)
//  Space Complexity : O(1)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Explaination
// 1. We always move to unsorted side, because we know the min or pivot will lie
// there
// 2. Here we do high = mid, so that we don't discard mid itself
// 3. In the end we return nums[low], since it will be holding the min element

#include "bits/stdc++.h"
using namespace std;

class Solution {
public:
  int findMin(vector<int> &nums) {
    int n = (int)nums.size();
    int low = 0;
    int high = n - 1;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] > nums[high]) { // min element/ pivot will be on the right
        low = mid + 1;
      } else {
        high = mid;
      }
    }

    return nums[low];
  }
};
