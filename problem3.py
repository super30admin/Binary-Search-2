class Solution(object):
    def findPeakElement(self, nums):
        l, r = 0, len(nums)-1
        while l <= r:
            mid = l + (r-l)//2
            if (mid-1<0 or nums[mid]>nums[mid-1]) and (mid+1>=len(nums) or nums[mid]>nums[mid+1]):
                return mid
            elif mid-1>=0 and nums[mid]<nums[mid-1]: # the opposite of the above "if" are these two "elif"
                r = mid - 1
            elif mid+1<len(nums) or nums[mid]<nums[mid+1]:
                l = mid + 1
        return l