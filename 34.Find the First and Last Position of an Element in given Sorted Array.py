# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(n)
# Space Complexity : Average : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    '''
    Run binary search twice: first to find the first element position and then last position
    '''
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low = 0
        high = len(nums) - 1
        start, end = -1, -1

        def helperSearch(low, high):
            nonlocal start
            nonlocal end
            if (low > high):
                return
            mid = low + (high - low)//2
            if nums[mid] == target:
                if (mid - 1 >= 0) and nums[mid - 1] == target:
                    helperSearch(low, mid - 1)
                else:
                    start = mid
                if (mid + 1 < len(nums)) and (nums[mid + 1] == target):
                    helperSearch(mid + 1, high)
                else:
                    end = mid
            elif nums[mid] < target:
                helperSearch(mid + 1, high)
            elif nums[mid] > target:
                helperSearch(low, mid - 1)

        helperSearch(low, high)
        return(start, end)