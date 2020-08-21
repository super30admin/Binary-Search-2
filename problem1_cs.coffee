searchRange = (nums, target) ->
  li = leftMost(nums, 0, nums.length-1, target)
  ri = rightMost(nums, 0, nums.length-1, target)

  [li, ri]

leftMost = (nums, low, high, target) ->
  while low<= high
    mid = Math.floor(low + (high - low)/2)

    if nums[mid] == target
      if  mid == 0 or nums[mid-1] != target
        return mid
      high = mid - 1
    else if target < nums[mid]
      high = mid - 1
    else
      low = mid + 1

  -1

rightMost = (nums, low, high, target) ->
  while low<= high
    mid = Math.floor(low + (high - low)/2)

    if nums[mid] == target and (mid == nums.length-1 or nums[mid+1] != target)
      return mid
    else if target < nums[mid]
      high = mid - 1
    else
      low = mid + 1

  -1
