'''
We apply binary search strategy.

On mid we check if it is eligible to be peak. If not we continue to the next step.

We want to follow the uphill in the array beacuse going uphill will guarentee a peak.
Check which side is going uphill and eliminate the other side.
'''

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = 0
        r = len(nums) - 1

        while l <= r:
            m = l + (r-l)//2

            if (m == 0 or nums[m-1] < nums[m]) and (m == len(nums)-1 or nums[m+1] < nums[m]):
                return m

            if m != 0 and nums[m-1] > nums[m]:
                r = m-1
            else:
                l = m+1

        return -1