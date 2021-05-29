class Solution:
    '''
    Time Complexity: O(log n)
    Space Complexity: O(1)
    '''
    def findPeakElement(self, nums: List[int]) -> int:
        # binary search
        n = len(nums)
        left = 0
        right = n-1

        # iterate while left and right don't meet
        while left < right:
            # find the middle point
            mid = left + (right - left) // 2
            if nums[mid] < nums[mid + 1]: # continue right
                left = mid + 1
            else:
                right = mid
        return left