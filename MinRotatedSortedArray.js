/**
 TC: O(log n)
 SC: O(1)

 Approach:

 Since we have to do it on O(log n) times we do binary search

 In a rotated sorted array the condition to remember is that at least one side is always sorted
 Also the likelihood of the min element being in the array would be in the unsorted section
 The smallest element in the array would be smaller than the element on the left and the right

 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
  if (!nums) return -1;

  let low = 0;
  let high = nums.length - 1;

  while (low <= high) {
    // The first time this checks that if the entire array is sorted,
    //  from the next time onwards then it checks within the given high and low
    //  and if it satisfies then return nums[low]
    if (nums[low] <= nums[high]) {
      return nums[low]
    }

    const mid = Math.floor(low + (high-low)/2);
    if ((mid === 0 || nums[mid] < nums[mid-1]) &&
        (mid === nums.length -1 || nums[mid] < nums[mid+1])) {
      return nums[mid]
    }

    if (nums[low] <= nums[mid]) { // left side is sorted
      low = mid + 1;
    } else {
      high = mid - 1;
    }
  }
};