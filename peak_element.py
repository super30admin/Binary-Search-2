class Solution:  # BRUTE FORCE ; Time Complexity = O(n)
    def findPeakElement(self, nums: List[int]) -> int:
        if not nums:
            return -1
        max_val = float("-inf")
        max_idx = float("-inf")
        for idx, val in enumerate(nums):
            if val > max_val:
                max_val = val 
                max_idx = idx
        return max_idx
