package main

/*
o(logN) + o(logN) = 2o(logN) == o(logN)
*/
func searchRange(nums []int, target int) []int {
	if nums == nil || len(nums) == 0 {
		return []int{-1, -1}
	}

	first := -1
	second := -1
	left := 0
	right := len(nums) - 1

	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] == target {
			first = mid
			right = mid - 1
		} else if target < nums[mid] {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}

	left = first
	if left == -1 {
		return []int{-1, -1}
	}

	right = len(nums) - 1
	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] == target {
			second = mid
			left = mid + 1
		} else if target < nums[mid] {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}

	return []int{first, second}
}
