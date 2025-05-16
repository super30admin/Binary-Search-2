# Time Complexity - I am doing Binary Search two times so - O(2log n) = O(log n)
# Space Complexity - we are using two pointers so except input it O(1)
# Approach - when we normally do binary search, we find target at mid, now in this case since we are using sorted array
# the target if it is present at mid will have it's first occurrence towards the left of the array from mid
# similarly the last occurrence will be towards the right which means we are doing normal binary search two times
# in first time when we get nums[mid] == target we shift towards left instead of returning so that if there are target present towards the left
# then we can get the minimum index where nums[mid] == target which will be the first similarly for the last index
#
# This code ran successfully on Leetcode

def searchRange(nums, target):
    res = [-1,-1]
    l1, r1 = 0, len(nums)-1
    l2, r2 = 0, len(nums)-1
    
    while l1 <= r1:
        mid = l1 + ((r1-l1)//2)
        if nums[mid] == target:
            res[0] = mid
            r1 = mid - 1
        elif nums[mid] < target:
            l1 = mid + 1
        else:
            r1 = mid - 1
    while l2 <= r2:
        mid = l2 + ((r2-l2)//2)
        if nums[mid] == target:
            res[1] = mid
            l2 = mid + 1
        elif nums[mid] < target:
            l2 = mid + 1
        else:
            r2 = mid - 1
    return res

nums = [5,7,7,8,8,10]
target = 8
print(searchRange(nums, target))
nums = [5,7,7,8,8,10]
target = 6
print(searchRange(nums, target))
nums = []
target = 0
print(searchRange(nums, target))