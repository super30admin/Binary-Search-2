// Time Complexity : O(log n)
// Space Complexity : O(1) 
// Approach : finding the element using binary search, spliting [] / 2 where one of peak element will always be at greater end of the mid

var findPeakElement = function (nums) {
    if (nums == null || nums.length == 0) retunr - 1
    let low = 0
    let high = nums.length - 1
    while (low <= high) {
        const mid = Math.floor(low + (high - low) / 2)
        if ((mid == 0 || nums[mid] > nums[mid - 1]) &&
            (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
            return mid
        } else if (mid > 0 && nums[mid] < nums[mid - 1]) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return -1
};