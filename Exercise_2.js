// Time Complexity : O(log n)
// Space Complexity : O(1) 
// Approach : finding the element using binary search

var findMin = function (nums) {
    if (nums == null || nums.length == 0) return -1
    let low = 0
    let high = nums.length - 1
    while (low <= high) {
        if (nums[low] <= nums[high]) {
            return nums[low]
        }
        const mid = Math.floor(low + (high - low) / 2)
        if ((mid == 0 || nums[mid] < nums[mid - 1]) &&
            (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
            return nums[mid]
        } else if (nums[low] <= nums[mid]) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    return -1
};