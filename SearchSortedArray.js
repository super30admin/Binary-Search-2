/*
* TC: O(log n)
* SC: 0(1)
* Did this code successfully run on Leetcode : Yes
* Any problem you faced while coding this : No
*
* Approach:
*   The approach we went with is to a binary search. we do it twice, the first time we find the first position of the target
*   and in the second search we find the last position by also passing in the first position as the lower bound
*
*   In the first binary search where we search mid=== target within that we also check if the mid element occurrence
*   of the element is not the same as the element to the left if it is the same we move the high = mid - 1 but if mid element
*   occurrence is not equal to the element on the left then we can say that the mid is the first occurrence of the target.
*
*   Similar check on the right where we do if mid element is not equal to the element on the right if it is not then we return
*   mid else we do low = mid + 1;
*
*   In both binary searches we add the check of lower and higher bound to the mid because we also want to make sure that when
*   checking the left and right we are index our of bound
*
*
* */


/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

const binarySearchFirst = (nums, target) => {
  let low = 0;
  let high = nums.length - 1;

  while(low <= high) {
    const mid = Math.floor(low + (high - low)/2);

    if (nums[mid] === target) {
      if (mid === 0 || (nums[mid-1] !== nums[mid])) {
        return mid;
      }
      high = mid - 1; // we move to the left since now we know that element to the elft is also equal to the target
    } else if (target > nums[mid]) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }
  }
  return -1;
}


const binarySearchSecond = (nums, target, low) => {
  let high = nums.length - 1;

  while(low <= high) {
    const mid = Math.floor(low + (high - low)/2);

    if (nums[mid] === target) {
      if (mid === nums.length -1  || (nums[mid+1] !== nums[mid])) {
        return mid
      }
      low = mid + 1; //we move to the right since now we know that element to the elft is also equal to the target
    } else if (target > nums[mid]) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }
  }
  return -1
}


var searchRange = function(nums, target) {
  if (!nums) return [-1, -1];

  const first = binarySearchFirst(nums, target)
  console.log(first);
  if (first === -1) {
    return [-1, -1];
  }

  const second = binarySearchSecond(nums, target, first);
  return [first, second];
};

searchRange([5,7,7,8,8,10], 8)