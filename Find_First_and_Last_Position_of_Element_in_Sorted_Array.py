# Time Complexity: O(logN)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [-1,-1]
        first:int = self.findOccurence(nums, target, True)
        # if first is -1, then the element is not present in array => we don't need to find last
        if first != -1:
            return [first, self.findOccurence(nums, target, False)]
        return [-1,-1]

    def findOccurence(self, nums:List[int], target:int, isFirst:bool) -> int:
        low:int = 0
        high:int = len(nums) - 1
        ans:int = -1
        # store latest high/low in the ans

        while low <= high:
            mid:int = low + ((high-low)//2)
            if target == nums[mid]:
                ans = mid
                # if we need the first occurence we shift towards the left side else to the right
                if isFirst:
                    high = mid - 1
                else:
                    low = mid + 1
            elif target > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return ans