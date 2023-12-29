/* time complexity : 2*O(lon n)
space complexity : O(n) */

func findPeakElement(nums []int) int {
	n := len(nums)
	low := 0
	high := n - 1
	for low <= high {
		mid := (low + high) / 2
		if nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1] {
			return mid
		}
		if nums[mid] < nums[mid+1] {
			low = mid + 1
		}
	}
	return -1
}