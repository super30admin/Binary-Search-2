'''
I try to look for the peak by finding the middle element and checking if it is the peak
if not, then I set the pointers such that I'm looking on that side of the array which is greater
this way I'll find atleast one peak which is the requirement of the problem
'''


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = 0
        h = length = len(nums) - 1

        if l == h:
            return 0

        while l <= h:
            mid = (l+h) // 2
            value = nums[mid]

            if mid == length:
                if value > nums[mid - 1]:
                    return mid

            if mid == 0:
                if value > nums[mid+1]:
                    return mid

            if value > nums[mid-1] and value > nums[mid+1]:
                return mid

            elif value < nums[mid+1]:
                l = mid + 1

            elif value < nums[mid - 1]:
                h = mid - 1