# Time Complexity: O(log n)

# The algorithm uses binary search, which reduces the search space by half in each iteration.
# In the worst case, we need log₂(n) iterations to find the peak element.

# Space Complexity: O(1)

# The algorithm uses a constant amount of extra space regardless of input size.
# Only three variables are used (l, r, and m) throughout the execution.

# Did this code successfully run on Leetcode: YES

def findPeakElement(self, nums):
   """
   :type nums: List[int]
   :rtype: int
   """
   # Initialize left pointer at the start of the array
   l = 0
   # Initialize right pointer at the end of the array
   r = len(nums)-1
   
   # While loop to continue the search while the left pointer is less than the right pointer
   while l < r:
       # Calculate the middle index using integer division to avoid overflow
       m = l + (r-l)//2
       
       # If the next element is greater than the middle element,
       # a peak must exist in the right half (ascending slope)
       if nums[m+1] > nums[m]:
           l = m + 1
       # Otherwise, a peak must exist in the left half including the middle
       # (we're either at a peak or on a descending slope)
       else:
           r = m
   
   # When l == r, we have found the peak element index
   return l