"""
Approach: Here, we have to find the peak element, by checking the neighbors. So, when we do our binary search, we will check the mid element that is is bigger than its
neighbor or if it not then we will go the bigger element side of the array.


TC: O(log n)
SC: O(1)
"""

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low)//2
            if (mid == 0 or nums[mid] > nums[mid-1]) and (mid == high or nums[mid] > nums[mid+1]):
                return mid
            elif mid != 0 and nums[mid-1] > nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return 89
                