func findMin(nums []int) int {
	n := len(nums) - 1
	low := 0
	high := n
	for low <= high {
		if nums[low] < nums[high] {
			return nums[low]
		}
		mid := (low + high) / 2
		if (mid == 0 || nums[mid] < nums[mid-1]) && (mid == n || nums[mid] < nums[mid+1]) {
			return nums[mid]
		} else if nums[low] <= nums[mid] {
			low = mid + 1
		} else {
			high = mid - 1
		}
	}
	return -1
}