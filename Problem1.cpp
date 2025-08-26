// Problem - Find first and last position of element in sorted array
//  Time Complexity : O(logn)
//  Space Complexity : O(1)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Explaination
// 1. We first find the leftMost range of the target element using binary search
// and moving left
// 2. If we find the first index of the target element, we continue the same on
// the rightmost element
// 3. This gives us our approach time complexity of O(2logn) ~ O(log n)

#include "bits/stdc++.h"
using namespace std;

class Solution {
public:
  int binarySearchFirst(int low, int high, int target, vector<int> &nums) {
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        if ((mid == 0 || nums[mid] != nums[mid - 1])) {
          return mid;
        } else {
          high = mid - 1;
        }
      } else if (nums[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  int binarySearchSecond(int low, int high, int target, vector<int> &nums) {
    int n = (int)nums.size();
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        if ((mid == n - 1 || nums[mid] != nums[mid + 1])) {
          return mid;
        } else {
          low = mid + 1;
        }
      } else if (nums[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  vector<int> searchRange(vector<int> &nums, int target) {
    int n = (int)nums.size();
    if (!n)
      return {-1, -1};
    if (nums[0] > target)
      return {-1, -1};
    if (target > nums[n - 1])
      return {-1, -1};
    int first = binarySearchFirst(0, n - 1, target, nums);
    if (first == -1)
      return {-1, -1};
    int second = binarySearchSecond(first, n - 1, target, nums);
    return {first, second};
  }
};
