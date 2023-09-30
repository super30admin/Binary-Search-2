class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        lo, hi = 0, len(nums) - 1
        while lo <= hi:
            mid = lo + ((hi - lo) // 2)
            # check if the condition is met
            if (len(nums) == 1) or (mid == 0 and nums[mid] > nums[mid + 1]) or (
                    mid == len(nums) - 1 and nums[mid - 1] < nums[mid]) or (nums[mid - 1] < nums[mid] > nums[mid + 1]):
                return mid
            if mid < len(nums) - 1 and nums[mid] <= nums[mid + 1]:
                lo = mid + 1
            else:
                hi = mid - 1
        return lo
