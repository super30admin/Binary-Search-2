'''
Time Complexity- O(log n)
Space Complexity - O(1)

This code is working on Leetcode.
'''
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        low, high = 0, len(nums)
        while low <= high: #binary search logic
            mid = low + (high - low)//2
            if (mid == 0 or nums[mid]>nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]): #return the mid index if the element at mid is greater than its neighbors
                return mid
            elif  mid != 0 and nums[mid-1] > nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return -1
        