# Time complexity - O(n)
# Space complexity - O(1)
# Did this solution run on leetcode? - yes
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        return self.__bsearch_peak(nums)
        
    def __bsearch_peak(self, nums):
        low, high = 0, len(nums)-1
        while low<high:
            mid = low + (high-low)//2
           
            # print(low, high, mid)
            
            if nums[high] > nums[mid]:
                low = mid + 1
            elif nums[low] > nums[mid]:
                high = mid - 1
            else:
                if high == low+1: return low
                high -= 1
                low += 1
        
        return low
    

# Time complexity - O(logn)
# Space complexity - O(1)
# Did this solution run on leetcode? - yes
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        return self.__bsearch_peak(nums)
        
    def __bsearch_peak(self, nums):
        """
            Binary search based on the value of the middle element.
            if the element after the mid is greater than the mid, that implies there is a peak in the right subarray.
            else, there must be at least one peak in the left subarray.
        """
        low, high = 0, len(nums)-1
        
        while low<high:
            mid = low + (high-low)//2
            if nums[mid] < nums[mid+1]: # even if there is one element this will compare the same element
                low = mid + 1
            else:
                high = mid
        
        return low
        