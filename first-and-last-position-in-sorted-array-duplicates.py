"""
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

Brute Force: Linear earch to find the first occurence and keep track of last occurence. --> O(n)
Optimal: O(logn) time complexity is asked in the problem --> Bianry Search.
Duplicates mean I need boundaries, not just a match. Find the upper and lower bounds and not match.

LOWER BOUND: Find the first index i such that nums[i] >= target
You're looking for the first place the target could go without breaking the sorted order, before or at duplicates.
If it exists → gives the first occurrence
If it doesn't → gives the insertion point where you'd put it on the left before the equal values
UPPER BOUND: Find the first index where nums[i] > target
You're looking for the first place the target can no longer go without breaking the sorted order — i.e., past all duplicates.
If target exists → returns just after the last occurrence
If target doesn't exist → returns the insertion point where you'd put it on the right after the equal values

We are looking for possible insertion positions as well, so high = len(nums) because for both cases, the insertion point might be after the last element.

Edge case:
empty array or single element
target is first element
target is last element
target not found

Time Complexity: O(2logn) = O(logn)
Space Complexity: O(1)
"""

class Solution:
  def searchRange(self, nums, target):
    def lowerBound():
      low = 0
      high = len(nums) # ← include the "imaginary" slot after the end
      
      while low < high: # high is exclusive, so keeping mid in play at line 41.
        mid = (low + high)//2
        
        if nums[mid] < target:
          low = mid + 1
        else:
          high = mid # on edge cases (array of length 1, or target smaller than every element) the loop can terminate early, leaving lo past the correct lower bound. So, high = mid, and not mid - 1. Keep mid, it could be the first ≥ target
      return low # will stop at low == high.
    
    
    def upperBound():
      low = 0
      high = len(nums)
      
      while low < high:
        mid = (low+high)//2
        
        if nums[mid] <= target:
          low = mid + 1
        else:
          high = mid
      return low - 1 #low == high is the first index where nums[i] > target. So low - 1 is the last index where nums[i] <= target`
    
    if not nums: # Check for empty array
      return [-1, -1]
    
    first = lowerBound()
    if first == len(nums) or nums[first] != target: #target not present in array
      return [-1, -1]
    last = upperBound()
    return [first, last]
  
nums = [5,7,7,8,8,10]
target = 8
sol = Solution()
print(sol.searchRange(nums, target))