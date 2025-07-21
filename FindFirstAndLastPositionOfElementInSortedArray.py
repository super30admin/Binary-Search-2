# Time Complexity: O(log n) + O(log n) = O(2log n) = O(log n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: YES
# Any problem you faced while coding this: NO

class Solution:
    def searchRange(self, nums: list[int], target: int) -> list[int]:
        if nums == None or len(nums) == 0:
            return [-1,-1]
            
        first = self.bs1(nums, target)
        if first == -1: # making sure that the first is returning a valid integer
            return [-1,-1]
        
        last = self.bs2(nums, target)

        return [first,last]

    # find the first occurence of target value:
    def bs1(self, nums: list[int], target: int) -> list[int]:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2

            if nums[mid] == target:
                if mid == 0 or nums[mid] != nums[mid-1]: # if there is only one element we cannot compare
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1

    # find last occurence of target value:
    def bs2(self, nums: list[int], target: int) -> list[int]:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2
            
            if nums[mid] == target:
                if mid == len(nums)-1 or nums[mid] != nums[mid+1]:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
            
        return -1