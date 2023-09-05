/**
 TC: O(log n)
 SC: O(1)

 Approach:
 We know that its element is at its peak when the elemenet to the left and right are smaller than the current element or if the element is not found then the highest number would be the peak element.

 To solve this we use binary search
 - we pick the mid element and then we go left or right depending on the element that is higher than the mid.
 - we find the peak and return mid/index.
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement = function(nums) {

  if (!nums) return -1;

  let low = 0;
  let high = nums.length -1;

  while (low <= high) {
    const mid = Math.floor(low + (high-low)/2);

    if ((mid === 0 || nums[mid] > nums[mid-1]) && (mid === nums.length-1 || nums[mid] > nums[mid+1])) {
      return mid
    } else if (nums[mid + 1] > nums[mid]) {
      low = mid + 1
    } else {
      high = mid - 1;
    }
  }

};