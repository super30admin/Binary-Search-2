#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode :
#Any problem you faced while coding this :
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


class Solution:
    def findBound(self, nums, target, isFirst):
        low, high = 0, len(nums) - 1
        bound = -1
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                bound = mid
                if isFirst:
                    high = mid - 1
                else:
                    low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return bound
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        first = self.findBound(nums, target, True)
        if first == -1:
            return [-1, -1]
        last = self.findBound(nums, target, False)
        return [first, last]
