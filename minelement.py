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


# Using binary search
# Time complexity - O(log n)
# Space complexity - O(1)
# Did this solution run on leetcode? - yes
class Solution:
    def findMin(self, nums: List[int]) -> int:    
        """
            - Compare the left and right subarrays.
            - Consider the right subarray whether if it sorted.
            - If it is sorted, move the high pointer to mid-1.
            - else (right is unsorted), move the low pointer to mid+1.
            - when the mid element is the smallest, return it.
        """
        n = len(nums)
        low, high = 0, n-1
        
        while low<=high:
            mid = low + (high-low)//2
            if (mid==0 or nums[mid] < nums[mid-1]) and (mid==n-1 or nums[mid] < nums[mid+1]):
                return nums[mid]
            elif nums[high] > nums[mid]: # left subarray is sorted.
                high = mid - 1
            else:                        # right subarray is sorted.
                low = mid + 1
            
        return -1