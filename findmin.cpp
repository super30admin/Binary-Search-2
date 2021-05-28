// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

// Find the minimum element.

// You may assume no duplicate exists in the array.

// Example 1: Input: [3,4,5,1,2] Output: 1

// Example 2: Input: [4,5,6,7,0,1,2] Output: 0

include <bits/stdc++.h>
using namespace std;

class Solution {
public:
	int findMin(vector<int>& nums) {
		int mid, low = 0, high = nums.size() - 1;

		while (low < high) {

			mid = low + (high - low) / 2;
            
           	if (nums[low] < nums[high])
				return nums[low];
            
			if (nums[mid] > nums[mid + 1])
				return nums[mid + 1];

			if (nums[mid - 1] > nums[mid])
				return nums[mid];

            
			if (nums[mid] < nums[high]) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
        
		return nums[low];
	}
};