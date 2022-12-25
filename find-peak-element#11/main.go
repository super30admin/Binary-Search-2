package main

import "fmt"

/*

Initial Thought : Where to move the low and high after comparing to the mid

key takeaway was that you move to the part of the array where you see a greater value
so if the value mid+1 is greater than the mid you move there and you will surely find
the peak or hit the end of array that will be the peak

moving to greater side of the array will surely help you find the peak element

*/

func findPeakElement(nums []int) int {
	low := 0
	high := len(nums) - 1
	if low == high {
		return low
	}
	if nums[low] > nums[low+1] {
		return low
	}
	for low <= high {
		fmt.Println("inside for")
		mid := low + (high-low)/2
		if (mid == 0 || (nums[mid-1] < nums[mid])) && (mid == len(nums)-1 || (nums[mid] > nums[mid+1])) {
			return mid
		}
		//if nums[mid] < nums[high] && nums[low] > nums[mid]{
		if nums[mid+1] > nums[mid] {
			low = mid + 1
		} else {
			high = mid - 1
		}
	}
	return -1
}

func main() {
	fmt.Println("peak is", findPeakElement([]int{1, 2, 3, 1}))
}
