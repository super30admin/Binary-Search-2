func findPeakElement(nums []int) int {
    left := 0
    right := len(nums)-1
    for left <= right {
        mid := left + (right-left)/2
        if (mid == 0 || nums[mid] > nums[mid-1]) && (mid == len(nums)-1 || nums[mid] > nums[mid+1]) {
            return mid
        } else if mid != len(nums)-1 && nums[mid+1] > nums[mid] {
            left = mid+1
        } else {
            right = mid-1
        }
    }
    return -1
}
