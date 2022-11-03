# Time Complexity: O(logN)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low:int = 0
        high:int = len(nums) - 1

        # if the 1st element is less than last => not rotated, already sorted
        if nums[low] <= nums[high]:
            return nums[low]

        while low < high:
            mid:int = low + ((high - low)//2)

            # if currrent element is greater than first then it lies on the left increasing side
            # else it could be our minimum so we can shift the high to that
            if nums[mid] >= nums[0]:
                low = mid + 1
            else:
                high = mid
        # this loop will terminate when low == high so we can return high or low, same thing
        return nums[high]