"""
if the nums at m is greater than the rightmost element, it is the wrapped around part and hence we can find the minimn in the rightmost part, else in the left part
the TC for this is o(logn) as during each iteration, the search space is halved. The sc is contant space as we dont store anything apart from the answer
"""

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l , r = 0, len(nums) - 1

        while l < r:
            m = (l+r) // 2

            if nums[m] > nums[r]: #the number lies in the right half (since rotation wraps around)
                l = m + 1
            else: #the number lies in the left side and m can still be a possible asnwer, hence we dont skip over m
                r = m
        return nums[l]