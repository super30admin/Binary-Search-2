"""
https://leetcode.com/problems/find-peak-element/description/

Brute force: Linear probe --> O(n)
Optimal Solution: Not sorted. But O(logn) complexity --> Binary Search

Since we're guaranteed that nums[-1] and nums[n] are -∞, There will always be at least one peak. A peak can be at index 0 or index n-1. If the array is strictly increasing → last element is a peak. If strictly decreasing → first element is a peak
So binary search works fine: Move in direction of increasing value (nums[mid] < nums[mid+1]). You must eventually hit a peak 

Without boundary assumption: No virtual -∞ on the left
If you start with binary search: You'll keep going left. Eventually land at index 0. But is index 0 a peak? Only if you define it that way. If nums[0] < nums[-1] (which now exists), then it’s not a peak. If nums[0] is not guaranteed to be greater than its left neighbor (or nums[n-1] not greater than its right neighbor), then you could have no peak at the edge — and that breaks binary search’s logic. Use brute force.

Binary search relies on the mountain logic: You can always climb up to a peak. You’re not searching for a value — you're searching for a structural pattern: a local maximum. Binary search normally works on sorted data because we use ordering to prune half the array. But here, we’re using a different guarantee: Any strictly increasing slope must eventually descend → there must be a peak. This is the "Mountain Principle." Binary search works not because the array is sorted, but because a peak must exist along every slope.

Edge cases:
empty array
1 element array
duplicates

Time Complexity: O(logn)
Space Complexity: O(1)
"""

class Solution:
    def findPeakElement(self, nums):
      low = 0
      high = len(nums) - 1
      
      while low < high:
        mid = (low + high)//2
        
        if nums[mid] > nums[mid + 1]:
          high = mid # keep mid value which could be the potential peak
        else:
          low = mid + 1
      return low # stops when low == high, so only 1 element.
    
nums = [1,1,1,3,4,1]
sol = Solution()
print(sol.findPeakElement(nums))