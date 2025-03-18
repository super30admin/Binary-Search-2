# Time Complexity: O(log n)

# The algorithm uses binary search, which reduces the search space by half in each iteration.
# In the worst case, we need log₂(n) iterations to find the minimum element.

# Space Complexity: O(1)

# The algorithm uses a constant amount of extra space regardless of input size.
# Only three variables are used (l, r, and m) throughout the execution.

# Did this code successfully run on Leetcode: YES

def findMin(self, nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    # Initialize the left pointer at the start of the array
    l = 0 
    # Initialize the right pointer at the end of the array
    r = len(nums)-1

    # While loop to continue the search while the left pointer is less than the right pointer
    while l < r:
        # Calculate the middle index using integer division to avoid overflow
        m = l + (r-l)//2

        # Check if the middle element is the minimum by verifying:
        # 1. It's smaller than its left neighbor (or it's the first element)
        # 2. It's smaller than its right neighbor (or it's the last element)
        if (m == 0 or nums[m]< nums[m-1]) and (m == len(nums)-1 or nums[m]<nums[m+1]):
            return nums[m]

        # If the middle element is greater than the rightmost element,
        # the minimum must be in the right half of the array
        elif nums[m] > nums[r]:
            l = m + 1

        # Otherwise, the minimum must be in the left half including the middle element
        else:
            r = m - 1 
    
    # If we exit the loop, the left pointer is pointing to the minimum element
    return nums[l]