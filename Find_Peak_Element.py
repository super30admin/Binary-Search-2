# Time Complexity: O(logN)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:

        low:int = 0
        high:int = len(nums) - 1

        while low < high:
            mid:int = low + ((high - low)//2)

            # if curr element > next, we are on the decreasing slope and curr could be a peak
            # else we are on an increasing slope and mid+1 could be a peak
            if nums[mid] > nums[mid+1]:
                high = mid
            else:
                low = mid + 1
        return high