# Time Complexity: O(logn)
# Space Complexity: O(1)
# Approach: deciding between right/left sorted array, compare mid with low and high, apply binary search to find the peak element
class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        low = 0
        high = n-1
        peak_ele = self.binarySearch(nums,low,high)
        return peak_ele

    def binarySearch(self, nums , low,high):

        while low<=high:
            mid = low + (high-low)//2
            
            # mid ele is the peak ele and array is already sorted
            if nums[low]<=nums[high]:
                return nums[low]
            if mid>0 and nums[mid]<nums[mid-1]:
                return nums[mid]
            # right sorted, binary search on right
            elif nums[mid]>nums[high]:
                low = mid+1 
            # left sorted, binary search on left           
            else:
                high = mid -1
        