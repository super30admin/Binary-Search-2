#Find Peak Element

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1

        while left <= right:
            mid  = left + (right-left)//2
            val = nums[mid]
            # if peak return index
            if (mid==0 or val > nums[mid-1]) and (mid == len(nums)-1 or val > nums[mid+1]):
                return mid
            
            # else move towards a peak by moving towards increasing number
            if mid > 0 and nums[mid-1]>val:
                right = mid-1
            else:
                left = mid+1

        # return anything as the code won't reach here
        return -1