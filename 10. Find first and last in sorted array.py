# Defining a class Solution to solve the problem of finding the starting and ending position of a target value in a sorted array.
class Solution:
    # Defining the main function searchRange which is taking a sorted list nums and a target value.
    # Calling BiSer twice: once to find the leftmost index and once to find the rightmost index of the target.
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left = self.BiSer(nums, target, True)   # Searching for the leftmost index
        right = self.BiSer(nums, target, False) # Searching for the rightmost index
        return [left, right]

    # Defining a helper function BiSer to perform binary search with a bias (left or right).
    # Using binary search to efficiently find the target index.
    # If leftBias is True, moving towards the left to find the first occurrence.
    # If leftBias is False, moving towards the right to find the last occurrence.
    def BiSer(self, nums, target, leftBias):
        l = 0
        r = len(nums) - 1 
        i = -1
        while l <= r:
            m = (l+r) // 2
            if target > nums[m]:
                l = m + 1
            elif target < nums[m]:
                r = m - 1
            else: 
                i = m 
                if leftBias:
                    r = m - 1 
                else:
                    l = m + 1
        return i 

# Time Complexity (TC): O(log n), since binary search is being performed twice.
# Space Complexity (SC): O(1), since only a constant amount of extra space is being used.