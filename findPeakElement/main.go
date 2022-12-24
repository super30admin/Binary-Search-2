package main

/*
approach: binary search
- there can be multiple peaks
- peak is an element who is greater than its left and right neighbour ( immediate neighbor )
- if mid is not peak element, which side do we search on?
- find a side thats bigger than mid, peak will definetely be on the greater side ( atleast MORE chances of finding peak on the greater side )

time : o(logn)
space: o(1)
*/
func findPeakElement(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return -1
	}
	if len(nums) == 1 {
		return 0
	}

	left := 0
	right := len(nums) - 1

	// peak element is an element that is greater than left and right neighbor
	for left <= right {
		mid := left + (right-left)/2
		if (mid == 0 || nums[mid] > nums[mid-1]) && (mid == len(nums)-1 || nums[mid] > nums[mid+1]) {
			return mid
		} else if mid == len(nums)-1 || nums[mid+1] > nums[mid] {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return -1
}
