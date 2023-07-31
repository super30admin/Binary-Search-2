'''
Approach:
if target is equal to mid we need to find the first and last occurance of that element
for that we need to initiate the binary search from left of the array and right of the array.

left binary search will return the first index of the element
right binary search will return the last index of the element.

Binary Search:
Calculate the mid and compare the mid with the target element. if target == nums[mid], then return index of the mid
if the target is less than mid then move the high to mid - 1
else move the low to mid + 1
'''

# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:

    def binarySearchLeft(self, nums, l, r, target):
        while (l <= r):
            mid = l + (r - l) // 2
            #when nums[mid] == target, then see if immediate left is less than mid, then mid is first occurance
            if nums[mid] == target:
                if (mid == l or nums[mid] > nums[mid - 1]):
                    return mid
                else:
                    r = mid - 1

            elif nums[mid] < target:
                l = mid + 1

            else:
                r = mid - 1

        return -1

    def binarySearchRight(self, nums, l, r, target):
        while (l <= r):
            mid = l + (r - l) // 2
            # when nums[mid] == target, then see if immediate right is greater than mid, then mid is first occurance
            if nums[mid] == target:
                if (mid == r or nums[mid] < nums[mid + 1]):
                    return mid
                else:
                    l = mid + 1

            elif nums[mid] < target:
                l = mid + 1

            else:
                r = mid - 1
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums or len(nums) == 0:
            return [-1, -1]

        low = 0
        high = len(nums) - 1
        left = self.binarySearchLeft(nums, low, high, target)
        if left == -1:
            return [-1, -1]
        right = self.binarySearchRight(nums, low, high, target)

        return [left, right]




