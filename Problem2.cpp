//## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
//One half is sorted, check if middle element is greater than ending element, if so, minimum will be in right, search right or else search in left side.

#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int findMin(vector<int>& nums) {
        int start = 0;
        int end = nums.size() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end]) {
                
                start = mid + 1;
            } else {
                
                end = mid;
            }
        }

        return nums[start];
    }
};