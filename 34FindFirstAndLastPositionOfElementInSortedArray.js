/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function (nums, target) {
  if (nums.length === 0) return [-1, -1];

  function findFirst() {
    let lo = 0,
      hi = nums.length - 1;

    while (lo < hi) {
      const mid = lo + ((hi - lo) >> 1); // floor
      if (target <= nums[mid]) hi = mid;
      else lo = mid + 1;
    }
    return nums[lo] === target ? lo : -1;
  }

  function findSecond() {
    let lo = 0,
      hi = nums.length - 1;

    while (lo < hi) {
      const mid = lo + ((hi - lo + 1) >> 1); // ceil
      if (target >= nums[mid]) lo = mid;
      else hi = mid - 1;
    }
    return nums[lo] === target ? lo : -1;
  }
  return [findFirst(), findSecond()];
};
