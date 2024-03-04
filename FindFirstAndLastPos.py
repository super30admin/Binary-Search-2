# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

class Solution:
    def binSearchFirst(self, nums, low, high, target):

        while low <= high:
            mid = (low + high)//2

            if nums[mid] == target:
                #Checks if mid is first occurence
                if mid == 0 or nums[mid] > nums[mid - 1]:
                    return mid
                else:
                    high = mid - 1

            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1

    def binSearchLast(self, nums, low, high, target):
        while low <= high:
            mid = (low + high)//2

            if nums[mid] == target:
                #checks if mid is last occurence
                if mid == high or nums[mid] < nums[mid + 1]:
                    return mid
                else:
                    low = mid + 1

            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums is None or len(nums) == 0:
            return [-1, -1]
        n = len(nums)
        first = self.binSearchFirst(nums, 0, n - 1, target)
        if first == -1:
            return [-1, -1]
        last = self.binSearchLast(nums, first, n - 1, target)
        return [first, last]