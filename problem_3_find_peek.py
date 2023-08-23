# // Time Complexity : O(log n )
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        start, end = 0, len(nums)-1
        
        while (start <= end):
            mid = (start + end) // 2
            
            greaterThanLT = mid == 0 or nums[mid] > nums[mid - 1]
            greaterThanRT = mid ==len(nums)-1 or nums[mid] > nums[mid + 1]
            
            if (greaterThanLT and greaterThanRT):
                return mid
            elif greaterThanLT:
                start = mid + 1
            else:
                end = mid - 1