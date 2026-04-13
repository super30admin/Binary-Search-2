/**
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement = function (nums) {
  let lo = 0,
    hi = nums.length - 1;

  while (lo < hi) {
    let mid = lo + ((hi - lo) >>> 1);
    if (nums[mid] < nums[mid + 1]) {
      lo = mid + 1;
    } else {
      hi = mid;
    }
  }
  return lo;
};
