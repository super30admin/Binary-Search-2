class Solution:
    def findMin(self, nums: List[int]) -> int: #O(logn)
        """trying to find the sorted side if we get that we will know minimun element is in the unsorted side so we are rejecting the sorted side.
        """
        low,high = 0, len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            if nums[low]<=nums[high]:
                return nums[low]
            elif nums[mid]<nums[mid-1] and nums[mid]<nums[mid+1]:
                return nums[mid]
            elif nums[mid]>nums[high]:
                low=mid+1
            else:
                high = mid-1
        
        