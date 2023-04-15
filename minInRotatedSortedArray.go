// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * Approach:
 * Since it is a rotated sorted array, at least one half will be sorted.
 * Another observation is that the minimum element is either at the unsorted
 * side while searching, or else at the start of any subarray.
 */

package main

func findMin(nums []int) int {
	if len(nums) == 0 {
		return -1
	}

	l, h := 0, len(nums)-1

	for l <= h {
		if nums[l] <= nums[h] { // if sorted, directly return first elem
			return nums[l]
		}

		m := l + (h-l)/2 // prevent integer overflow

		if (m == l || nums[m] < nums[m-1]) &&
			(m == h || nums[m] < nums[m+1]) {
			return nums[m] // you're at min since neighbors are bigger
		}

		if nums[l] <= nums[m] { // left is sorted, move right
			l = m + 1
		} else { // right is sorted, move left
			h = m - 1
		}
	}

	return -1
}
