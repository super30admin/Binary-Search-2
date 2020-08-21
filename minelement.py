# Using binary search
# Time complexity - O(log n)
# Space complexity - O(1)
# Did this solution run on leetcode? - yes
class Solution:
    def findMin(self, nums: List[int]) -> int:
        return nums[self.__bsearch(nums)]
    
    def __bsearch(self, nums):
        """
            - Compare the left and right subarrays.
            - Consider the array which is unsorted as this will contain the smallest element.
            - When both the subarrays are sorted, return the leftmost element. (Entire array is sorted)  
        """
        low, high = 0, len(nums)-1
        
        while low<=high:
            mid = low + (high-low)//2
            if nums[low] <= nums[mid] <= nums[high]:
                return low
            elif nums[low] <= nums[mid]: # left subarray is sorted.
                low = mid + 1
            else:                        # right subarray is sorted.
                high = mid 
            
        return high