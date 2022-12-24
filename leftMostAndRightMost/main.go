package main

/*
approach: 2 pass binary search
- first use binary search to find the left most idx of target
- if we do not find a left most idx, then this target does not exist, exit early
- otherwise use binary search to find the right most idx of target
  - use the already found leftMostIdx as the start of our search window instead of full array again

time : o(2logN) or o(logn)
space: o(1)
*/
func searchRange(nums []int, target int) []int {
	if nums == nil || len(nums) == 0 {
		return []int{-1, -1}
	}
	left := 0
	right := len(nums) - 1

	out := []int{-1, -1} // leftMostIdx, rightMostIdx
	for left <= right {
		mid := left + (right-left)/2
		if target <= nums[mid] {
			if nums[mid] == target {
				out[0] = mid
			}
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	if out[0] == -1 {
		return out
	}

	left = out[0]
	right = len(nums) - 1

	for left <= right {
		mid := left + (right-left)/2
		if target >= nums[mid] {
			if target == nums[mid] {
				out[1] = mid
			}
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return out
}
