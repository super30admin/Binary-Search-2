package main

// peak element - If a given idx is greater than left neighbour and right neighbour - than that idx is the peak
// if not - how do we find out which side to search in next?
// WE ALWAYS USE MID TO COMPARE - ITs generally a good habit to always use mid to figure out which side to go to next
// i.e follow the full concrete binary search pattern
// in this case, if mid-1 > mid -> go left
// if mid+1 > mid -> go right
func findPeakElement(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return -1
	}
	left := 0
	right := len(nums) - 1
	for left <= right {
		mid := left + ((right - left) / 2)
		if (mid == 0 || nums[mid] > nums[mid-1]) && (mid == len(nums)-1 || nums[mid] > nums[mid+1]) {
			return mid
		} else if mid != 0 && nums[mid-1] > nums[mid] {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return -1
}
