var leftMost, rightMost, searchRange;

searchRange = function(nums, target) {
  var li, ri;
  li = leftMost(nums, 0, nums.length - 1, target);
  ri = rightMost(nums, 0, nums.length - 1, target);
  return [li, ri];
};

leftMost = function(nums, low, high, target) {
  var mid;
  while (low <= high) {
    mid = Math.floor(low + (high - low) / 2);
    if (nums[mid] === target) {
      if (mid === 0 || nums[mid - 1] !== target) {
        return mid;
      }
      high = mid - 1;
    } else if (target < nums[mid]) {
      high = mid - 1;
    } else {
      low = mid + 1;
    }
  }
  return -1;
};

rightMost = function(nums, low, high, target) {
  var mid;
  while (low <= high) {
    mid = Math.floor(low + (high - low) / 2);
    if (nums[mid] === target && (mid === nums.length - 1 || nums[mid + 1] !== target)) {
      return mid;
    } else if (target < nums[mid]) {
      high = mid - 1;
    } else {
      low = mid + 1;
    }
  }
  return -1;
};

//# sourceMappingURL=problem1_cs.js.map
