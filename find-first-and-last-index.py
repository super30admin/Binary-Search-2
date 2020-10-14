# // Time Complexity : O(log n)
# // Space Complexity : O(1) in-place
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

# My approach here is to use binary search for boundry search rather that searching for a target.

# 1. Find the lower bound of target
#   Split the array into two zones - elements < target and elements >= target
#   Use binary search to look for this boundry, on termination, the start index will be the LOWER bound of the target (if it exists!) 

# 2. Find the upper bound of target
#   Split the array into two zones - elements <= target and elements > target
#   Use binary search to look for this boundry, on termination, the end index will be the UPPER bound of the target
# more comments in-line...

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        output = [-1,-1]
        if not nums:
            return output
        start = 0
        end = len(nums) - 1
        
        # Binsearch 1 - search for boundry that divides nums < target and nums >= target
        while start <= end:
            mid = start + (end - start) // 2
            if nums[mid] >= target:
                end = mid - 1
            else:
                start = mid + 1

        # When binary search terminates, start index crosses over end index- 
        # the start index will point to the lower bound of the target
        if start == len(nums) or nums[start] != target: # If the target is not present, binary search will termainate with these conditions
            return output
        output[0] = start
        
        
        # Binsearch 2 - search for boundary that divides nums <= target and nums > target
        end = len(nums) - 1
        while start <= end:
            mid = start + (end - start) // 2
            if nums[mid] > target:
                end = mid - 1
            else:
                start = mid + 1
        # When binary search terminates, end index will point to the upper bound of the number
        output[1] = end
        
        return output