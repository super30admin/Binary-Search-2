class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        # Initializing left and right pointers for binary search
        l = 0 
        r = len(nums) - 1 

        # Performing binary search to find a peak element
        while l <= r:
            # Calculating the middle index
            m = l + ((r-l) //2)
            # Checking if the left neighbor is greater, so moving search to the left half
            if m > 0 and nums[m] < nums[m-1]:
                r = m - 1
            # Checking if the right neighbor is greater, so moving search to the right half
            elif m < len(nums) - 1 and nums[m] < nums[m + 1]:
                l = m + 1 
            # If neither neighbor is greater, returning current index as peak
            else: 
                return m

# Time Complexity (TC): O(log n), since binary search is being used.
# Space Complexity (SC): O(1), since only constant extra space is being used.