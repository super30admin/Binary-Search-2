// Time Complexity : O(log n)
// Space Complexity : O(1) 
// Approach : finding element through binaray seaech applying two binary search left to find first and right to find last element

var searchRange = function (nums, target) {
    if (nums == null || nums.length == 0) return [-1, -1]
    const low = 0
    const high = nums.length - 1
    const left = binarySearchLeft(nums, low, high, target)
    if (left == -1) {
        return [-1, -1]
    }
    const right = binarySearchRight(nums, left, high, target)
    return [left, right]
};

function binarySearchLeft(nums, low, high, target) {
    while (low <= high) {
        mid = Math.floor(low + (high - low) / 2)
        if (nums[mid] == target) {
            if (mid == 0 || nums[mid] > nums[mid - 1]) {
                return mid
            } else {
                high = mid - 1;
            }
        } else if (nums[mid] > target) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return -1
}

function binarySearchRight(nums, low, high, target) {
    while (low <= high) {
        mid = Math.floor(low + (high - low) / 2)
        if (nums[mid] == target) {
            if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
                return mid
            } else {
                low = mid + 1;
            }
        } else if (nums[mid] > target) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return -1
}