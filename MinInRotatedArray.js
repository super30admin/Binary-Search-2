// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

var findMin = function (nums) {
    let low = 0, high = nums.length - 1;

    while (low < high) {
        const mid = Math.floor((low + high) / 2);
        if (nums[mid] > nums[high]) {
            low = mid + 1;
        } else {
            high = mid;
        }
    }
    return nums[low];
};