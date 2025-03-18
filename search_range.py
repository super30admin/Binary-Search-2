# Time Complexity: O(log n)

# The algorithm performs two binary searches, each taking O(log n) time.
# Since these searches are sequential, the overall time complexity remains O(log n).

# Space Complexity: O(1)

# The algorithm uses a constant amount of extra space regardless of input size.
# Only five variables are used (l, r, m, i, and j) throughout the execution.

# Did this code successfully run on Leetcode: YES

def searchRange(self, nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: List[int]
    """
    # Initialize left pointer at the start of the array
    l = 0
    # Initialize right pointer at the end of the array
    r = len(nums) - 1
    # Initialize starting position of target to -1 (not found)
    i = -1
    # Initialize ending position of target to -1 (not found)
    j = -1
    
    # First binary search: Find the leftmost occurrence of target
    while l <= r:
        # Calculate the middle index using integer division to avoid overflow
        m = l + (r-l)//2
        
        # If middle element is the target, record it and continue searching left
        if nums[m] == target:
            i = m
            r = m - 1
        # If middle element is greater than target, search in the left half
        elif nums[m] > target:
            r = m - 1
        # If middle element is less than target, search in the right half
        else:
            l = m + 1
    
    # If target was not found in the first search, return [-1, -1]
    if i == -1:
        return [-1, -1]
    
    # Reset pointers for the second binary search
    l = 0
    r = len(nums) - 1
    
    # Second binary search: Find the rightmost occurrence of target
    while l <= r:
        # Calculate the middle index using integer division to avoid overflow
        m = l + (r-l)//2
        
        # If middle element is the target, record it and continue searching right
        if nums[m] == target:
            j = m
            l = m + 1
        # If middle element is greater than target, search in the left half
        elif nums[m] > target:
            r = m - 1
        # If middle element is less than target, search in the right half
        else:
            l = m + 1
    
    # Return the starting and ending positions of the target
    return [i, j]