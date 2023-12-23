"""
    General Binary Search, Once you find target
        keep searching left until you find left most
        keep searching right until you din right most
"""
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        leftFirst = self.binarySearch(nums, target, True)
        rightLast = self.binarySearch(nums, target, False)
        return [leftFirst, rightLast]


    def binarySearch(self, nums, target, leftBias):
        l, r = 0, len(nums)-1
        i = -1
        while l <= r:
            m = (l+r)//2
            if target < nums[m]:
                r = m-1
            elif target > nums[m]:
                l = m+1
            else:
                i= m
                if leftBias:
                    r = m-1
                else:
                    l = m+1
        return i
        