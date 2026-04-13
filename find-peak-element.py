class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        # -inf [1,2,1,3,5,6,4] -inf
        #       l     m l lr
        # -inf [1,2,1,3,5,6,7] -inf, 7 is the peak
        #       l       l m l
        left = 0
        right = len(nums)-1
        while left < right:
            mid = left + (right - left)//2

            if nums[mid] < nums[mid+1]:
                left = mid + 1
            else:
                right = mid

        return left