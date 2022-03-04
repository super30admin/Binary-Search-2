package main

/*
	Min is always on the unsorted side
	4,5,6,7,0,1,2
		  M

	This is a variant on find target in rotated sorted array.
	In that problem we were given a target , but here we are given to find smallest.
	An element is smallest in a rotated sorted array ONLY if its smaller compared to
	its left and right neighbours

	so we know how to check if an element is a min element
	then we can use binary search because we can eliminate a
	side by searching in the unsorted side.

	So instead of searching in the sorted side, the min will always be in
	the unsorted side.
	Then with that, we look for a sorted side and go search in the other side of the sorted side.

	along with this, we have to ensure that in each iteration if left < right - this would mean the elements
	are fully sorted within this window, so return the leftest ( i.e the smallest )

	time: o(logN)
	space: o(1)
*/
func findMin(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return -1
	}

	left := 0
	right := len(nums) - 1

	for left <= right {
		if nums[left] <= nums[right] {
			return nums[left]
		}
		mid := left + ((right - left) / 2)
		if (mid == 0 || nums[mid] < nums[mid-1]) && (mid == len(nums)-1 || nums[mid] < nums[mid+1]) {
			return nums[mid]
		} else if nums[left] <= nums[mid] {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return -1
}
