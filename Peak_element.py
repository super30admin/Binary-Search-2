'''
This Python code defines a class Solution with a method findPeakElement, which performs binary search to find a peak element in a given list of integers.

The binary search is applied to efficiently locate a peak element, which is an element greater than its adjacent neighbors.

The code returns the index of the peak element when found; otherwise, it returns -1 if the input list is empty.
'''
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        while low <= high:
            mid= low +(high-low) //2
            if (mid == low or nums[mid-1] < nums[mid]) and (mid == high or nums[mid+1] < nums[mid]):
                return mid
            elif mid != 0 and nums[mid-1] > nums[mid]:
                high = mid-1
            else:
                low = mid +1
        return
        
