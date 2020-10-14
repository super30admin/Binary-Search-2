
# // Time Complexity : O(log n)
# // Space Complexity : O(1) - in-place
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

# Using the same approach I used for search in a rotated sorted array
# We will use the last element to divide the array into two zones, let's call it the polestar
# green - Rotated sorted half
# orange - Original sorted half
# EG [4,5,6,7,0,1,2] - Here, 4,5,6,7 are green (Greater than polestar) and 
# 0,1,2 are orange(Less than polestar)
# Use binary search to find the boundary between the two zones
# On termination(when the start index crosses over end), the start index is the index of the min (pivot).

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        start = 0
        end = len(nums) - 1
        polestar = nums[-1]
        
        while start <= end:
            mid = start + (end - start)//2
            if nums[mid] > polestar: # Mid lies in the green zone(left half), move towards the boundary
                start = mid + 1
            else: # Mid lies in the orange zone(right half), move towards the boundary
                end = mid -1
                
        return nums[start]