"""
This solution finds the highest peak element in an array using binary search, ensuring that it always returns the maximum peak. 
Instead of stopping at any peak, it moves in the direction of the larger neighbor to locate the highest peak in the array. 
By adjusting the search space based on whether `nums[mid] < nums[mid+1]`, it guarantees an O(log N) time complexity while efficiently identifying the largest peak.
Space Complexity: O(1)
"""

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1

        while left < right:
            mid = left + ((right - left) // 2)

            if nums[mid] < nums[mid + 1]:
                left = mid + 1
            else:
                right = mid

        return left