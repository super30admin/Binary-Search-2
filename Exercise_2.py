# Time Complexity - I am doing Binary Search so O(log n)
# Space Complexity - we are using two pointers so except input it O(1)
# Approach - Like we did for search in rotated sorted array for every mid there will one sorted array it might be left or right
# first we check if nums[l] < nums[r] means no rotation and return find minimum between res and this number, then find the mid
# and again check the minimum between result and nums[mid], now we have to reject one half of the array which is simple we have to find the sorted array
# if nums[mid] > nums[l] means the left array is sorted and the rotated part is the right array so do l = mid + 1
# if it is not sorted means there are rotated elements in the left array so reject right array
#
# This code ran successfully on Leetcode

def findMin(nums):
    res = float('inf')
    l, r = 0, len(nums)-1
    while l <= r:
        if nums[l] <= nums[r]:
            res = min(res, nums[l])
        mid = l + ((r-l)//2)
        res = min(res, nums[mid])
        if nums[mid] >= nums[l]:
            l = mid + 1
        else:
            r = mid - 1
    return res

nums = [3,4,5,1,2]
print(findMin(nums))
nums = [4,5,6,7,0,1,2]
print(findMin(nums))
nums = [11,13,15,17]
print(findMin(nums))