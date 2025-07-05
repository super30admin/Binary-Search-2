"""
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

Brute force: Linear probe --> O(n)
Optimal: The smallest element is the pivot point. And in a rotated sorted array with no duplicates, one half is always sorted. We want to binary search for the “unsorted” part, because that’s where the min lives.

Edge case
empty arry

Time Complexity: O(logn)
Space Complexity: O(1)
"""

class Solution:
    def findMin(self, nums):
      if not nums:
        return -1 
      
      low = 0
      high = len(nums)-1
      
      while low < high: # low<=high (and high = mid - 1) means the loop can overshoot: low > high; low might now be past the minimum index. So this condition will not work here.
        mid = (low + high)//2
        
        if nums[mid] > nums[high]: # find the unsorted half; there are no duplicates
          low = mid + 1 # unsorted half --> do binary search here
          # [4,5,6,7,8,0,1,2,3]; mid = 3
        else:
          high = mid # When shrinking to the left, we want to keep mid. Since high is exclusive, setting high = mid keeps mid in the range
      return nums[low] #stops at low == high --> single element.
    
nums = [3,1,2]
sol = Solution()
print(sol.findMin(nums))