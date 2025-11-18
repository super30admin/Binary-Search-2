"""
the tc for this solution if O(logn) as the search space is halved in each iteration, we check that if the num[mid] is less than the num[mid + 1], then we arein increasing slope and we can find he peak at right side,
else if there is a drop, we can find the peak either way
if the num[m] is not less than the num[mid + 1] we are bit above in the peak, so we move our search space to left, and not loose the mid, bcz it can petentially be our peak
the sc for this is O(1) as we dont use additional space"""


class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l, r = 0, len(nums) - 1

        while l < r:
            m = l + (r - l)//2
            if nums[m + 1] > nums[m]: #peak is at the right side, bcz intuitively, numbers are either rising, or will have a drop, either ways, we can find a peak
                l = m + 1
            else:
                r = m # we dont want to loose m, bcz m could be our potential peak, hence not takinf m-1 but m
        return r
