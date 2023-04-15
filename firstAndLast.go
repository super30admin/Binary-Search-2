// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * Approach:
 * We use 2 binary searches in order to find both the required elements, one
 * search to find the left of the range, and the other to find the right.
 */

package main

func searchRange(nums []int, target int) []int {
	if len(nums) == 0 {
		return []int{-1, -1}
	}

	l, h := 0, len(nums)-1

	left := searchLeft(nums, target, l, h)

	if left == -1 { // short circuit; exit early if not found in 1 search
		return []int{-1, -1}
	}

	right := searchRight(nums, target, l, h)

	return []int{left, right}
}

func searchLeft(nums []int, target, l, h int) int {
	for l <= h {
		m := l + (h-l)/2
		if nums[m] == target {
			if m == l || nums[m-1] < target {
				return m
			}
			h = m - 1 // elements are still present to left
		} else if nums[m] > target { // element may be to left of mid
			h = m - 1
		} else { // element may be to right of mid
			l = m + 1
		}
	}

	return -1
}

func searchRight(nums []int, target, l, h int) int {
	for l <= h {
		m := l + (h-l)/2
		if nums[m] == target {
			if m == h || nums[m+1] > target {
				return m
			}
			l = m + 1 // elements are still present to right
		} else if nums[m] > target { // element may be to left of mid
			h = m - 1
		} else { // element may be to right of mid
			l = m + 1
		}
	}

	return -1
}
