package main

import "fmt"

// TODO - drop notes when you look at this later on

func findMin(nums []int) int {
	low := 0
	high := len(nums) - 1

	// edge cases
	if low == high {
		return nums[low]
	}
	if nums[low+1] > nums[low] && nums[low] < nums[high] {
		return nums[low]
	}

	for low <= high {
		fmt.Println("once")
		if nums[low] < nums[high] {
			return nums[low]
		}
		mid := low + (high-low)/2
		if (mid == 0 || nums[mid-1] > nums[mid]) && (mid == len(nums)-1 || nums[mid] < nums[mid+1]) {
			fmt.Println("inside if")
			return nums[mid]
		}
		//check if this is the sorted part
		if nums[low] <= nums[mid] {
			//this is sorted part

			low = mid + 1
		} else {
			// in unsroted part and try to squeeze high inside
			high = mid - 1
			//low = mid + 1
		}
	}
	fmt.Println("outside for")
	return 0
}

func main() {
	fmt.Println("min is ", findMin([]int{3, 4, 5, 1, 2}))
}
