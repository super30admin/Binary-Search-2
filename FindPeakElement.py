# All test cases passed in leetcode

#Here we apply binary search and check if mid is greater than both mid+1 and mid-1. 
# If yes we return as it is the peak element. If not then we move towards greater 
# element i.e. either mid+1 or mid-1.
# Time complexity - O(logn)
# Space complexity - O(1)

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:

        
        if not nums or len(nums)==1:
            return 0
        l = 0
        h = len(nums)-1
        
        while l<=h:
            mid = (l+h)//2
            
            if (mid==0 or nums[mid]>nums[mid-1]) and (mid==len(nums)-1 or nums[mid]>nums[mid+1]):
                return mid
           
            elif (nums[mid]<nums[mid+1]):
                l = mid+1

            else:
                h = mid-1 
                
        return 
                
        