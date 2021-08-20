// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

var searchRange = function (nums, target) {
    return [find(nums, target), find(nums, target, false)]
};

var find = function (nums, target, findElem = true) {
    let low = 0, high = nums.length - 1;

    while (low <= high) {
        const mid = Math.floor((low + high) / 2);
        if (nums[mid] < target) {
            low = mid + 1;
        } else if (nums[mid] > target) {
            high = mid - 1;
        } else {
            //When target == mid,
            //checking its left and right elem
            if (findElem) {
                if (nums[mid - 1] == target) {
                    high = mid - 1
                } else return mid;

            } else {
                if (nums[mid + 1] == target) {
                    low = mid + 1;
                } else return mid;

            }
        }
    }

    return -1;
}