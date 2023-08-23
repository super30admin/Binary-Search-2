# // Time Complexity : O(log n )
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution:
    def findIndex(self,nums: List[int], target: int , isFirst):        
        start, end = 0, len(nums) - 1

        while start <= end:
            mid = int((start + end) / 2)   

            if nums[mid] == target:
                if isFirst:  # This means we found our lower bound.
                    if mid == start or nums[mid - 1] < target:
                        return mid
                    # Search on the left side for the bound.
                    end = mid - 1
                else: # This means we found our upper bound.
                    if mid == end or nums[mid + 1] > target:
                        return mid
                    # Search on the right side for the bound.
                    start = mid + 1

            elif nums[mid] > target:
                end = mid - 1
            else:
                start = mid + 1

        return -1
        
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        lower_index = self.findIndex(nums, target, True)
        if lower_index == -1:
            return [-1,-1]
        
        upper_index = self.findIndex(nums, target, False)
        return [lower_index, upper_index]
        