# Time Complexity : O(logN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 34. Find First and Last Position of Element in Sorted Array
# We are performing a binary search in two parts the first is by finding the first occurance by shifting the right pointer and to find the last occurance we are shifting the left pointer to find the last occurance

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def find_first(nums,target):
            left = 0 
            right = len(nums) - 1
            first_occurance = -1
            while right >= left:
                mid = (left + right) // 2
                if nums[mid] == target:
                    first_occurance = mid
                    right = mid - 1
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid -1
            return first_occurance

        def find_last(nums,targets):
            left = 0
            right = len(nums) - 1
            last_occurance = -1
            while right >= left:
                mid = (left + right) // 2
                if nums[mid] == target:
                    last_occurance = mid
                    left = mid + 1
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            return last_occurance
        first_index = find_first(nums, target)
        last_index = find_last(nums, target)
        return[first_index,last_index]