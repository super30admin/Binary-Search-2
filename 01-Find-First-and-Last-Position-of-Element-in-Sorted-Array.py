# Problem 1: Find First and Last Position of Element in Sorted Array (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

# Time Complexity: O(log n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# We perform two binary searches, one to find the first occurrence of the target and another to find the last occurrence.
# In each binary search, we adjust our search boundaries based on whether we find the target and its position relative to its neighbors.

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1, -1]

        def findFirst(nums, target):
            low, high = 0, len(nums)-1
            

            while low <= high:
                mid = (low+high)//2

                if nums[mid] == target:
                    if (mid == 0) or nums[mid] != nums[mid-1]:
                        return mid
                    else:
                        high = mid - 1 

                elif target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            return -1

        def findLast(nums, target):
            low, high = 0, len(nums)-1

            while low <= high:
                mid = (low+high)//2

                if nums[mid] == target:
                    if (mid == (len(nums)-1)) or nums[mid] != nums[mid+1]:
                        return mid
                    else:
                        low = mid + 1 

                elif target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            return -1

        return [findFirst(nums, target), findLast(nums, target)]

