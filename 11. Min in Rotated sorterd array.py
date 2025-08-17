class Solution:
    def findMin(self, nums: List[int]) -> int:
        # Initializing left and right pointers
        l = 0
        r = len(nums) - 1 
        # Iterating while left pointer is less than right pointer
        while l < r:
            # Calculating middle index
            m = l + (r - l) // 2
            # Checking if middle element is greater than rightmost element
            if nums[m] > nums[r]:
                # Moving left pointer to mid + 1 since minimum is in right half
                l = m + 1
            else: 
                # Moving right pointer to mid since minimum could be at mid or in left half
                r = m 
        # Returning the minimum element found
        return nums[l]

# Time Complexity (TC): O(log n) - performing binary search
# Space Complexity (SC): O(1) - using constant extra space