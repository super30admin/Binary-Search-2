
#Time Complexity :O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

#Approach: The min element always lies on the unsorted side, if the entire array is sorted the min will be at index low.  

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        n = len(nums)
        high = n - 1
        while low <= high:
            mid = low + (high - low) // 2
            #Entire array is sorted, min element lies at index low
            if nums[low] <= nums[high]:  # I am not checking the edge case mid != n -1 cause, when mid points to last element, High and low pointers point to the same index
                return nums[low]
            #if min element lies at mid
            if (mid == 0 or nums[mid] < nums[mid - 1]) and (nums[mid] < nums[mid + 1]):
                return nums[mid]
            # if (mid != 0 and nums[mid] < nums[mid - 1]) and (nums[mid] < nums[mid + 1]):
            #     return nums[mid]
            if nums[low] <= nums[mid]: #Left side is sorted
               low = mid + 1
            else:
                high = mid - 1
          
            
        

        
          
            
        

        