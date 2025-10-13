# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 

'''
My approach:
Find the first index of the target element by searching in the left half.
Then, find the last index of the target element by searching in the right half (range: [first, len(nums)-1]).
'''
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        first = self.binaryFirstIndex(nums, target, 0, len(nums)-1)

        if first == -1:
            return [-1, -1]

        last = self.binaryLastIndex(nums, target, first, len(nums)-1)
        return [first, last]
        
    def binaryFirstIndex(self, nums: List[int], target: int, low: int, high: int):
        while low <= high:
            mid = low+(high-low)//2
            if nums[mid] == target:
                if mid == 0 or nums[mid-1] < target:
                    return mid
                else:
                    high = mid - 1
            
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def binaryLastIndex(self, nums: List[int], target: int, low: int, high: int):
        while(low <= high):
            mid = low + (high-low)//2
            if nums[mid] == target:
                if mid == len(nums)-1 or nums[mid+1] > target:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1