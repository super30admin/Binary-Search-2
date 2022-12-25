package main

import "fmt"

/*

Initial understanding after reading the question
- array contains duplicates

Constraints
- solve on log2N --> this tells me use BS

Thought Process
- use low high and mid
- find where target lies
- once target is found adjust low until you find the index which uis the left most index

*/

func searchLeft(nums []int, target int) int {
	low := 0
	high := len(nums) - 1
	for low <= high {
		mid := low + (high-low)/2

		// found the target
		if nums[mid] == target {
			// check if this is the lowest index for the target
			if mid == 0 || (nums[mid-1] < target) {
				return mid
			} else {
				high = mid - 1
				continue
			}
		}

		if target > nums[mid] {
			low = mid + 1
		} else {
			high = mid - 1
		}
	}
	return -1
}

func searchRight(nums []int, target int) int {
	low := 0
	high := len(nums) - 1
	for low <= high {
		mid := low + (high-low)/2

		if nums[mid] == target {

			if mid == len(nums)-1 || (nums[mid+1] > target) {
				return mid
			} else {
				low = mid + 1
				continue
			}
		}
		if target > nums[mid] {
			low = mid + 1
		} else {
			high = mid - 1
		}

	}

	return -1
}

func searchRange(nums []int, target int) []int {

	left := searchLeft(nums, target)
	right := searchRight(nums, target)
	return []int{left, right}
}

func main() {
	fmt.Println("first and last index are", searchRange([]int{5, 7, 7, 8, 8, 10}, 8))
}
