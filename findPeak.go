// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * Approach:
 * Peak element check is being done by checking the neighbors while doing
 * binary search, and if any element is greater than mid, we move right
 * (because that might be the peak) or else we move left
 */

package main

func findPeakElement(nums []int) int {
	if len(nums) == 0 {
		return -1
	}

	l, h := 0, len(nums)-1

	for l <= h {
		m := l + (h-l)/2

		if (m == l || nums[m] > nums[m-1]) &&
			(m == h || nums[m] > nums[m+1]) {
			return m
		}

		if nums[m] < nums[m+1] {
			l = m + 1
		} else {
			h = m - 1
		}
	}

	return -1
}
