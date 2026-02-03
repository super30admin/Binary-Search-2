'''
Time Complexity : O(log n) 
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :  No
'''
class Solution:
    def binarySearch(self, nums, target, isFirst = False):
        low = 0
        high = len(nums) - 1
        ans = -1
        while low <= high:
            mid = high + (low - high) // 2

            if nums[mid] == target:
                ans = mid
                if isFirst:
                    high = mid - 1
                else:
                    low = mid + 1
            
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        
        return ans
        
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        res = [-1, -1]
        res[0] = self.binarySearch(nums, target, True)
        res[1] = self.binarySearch(nums, target, False)

        return res
        