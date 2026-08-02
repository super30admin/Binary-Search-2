# https://leetcode.com/problems/find-peak-element/

# Time complexity: O(log n)
# Space complexity: O(1)
# Explanation: Perform a binary search to find ANY peak, which is defined by being either first element, last element, or number which is greater than left side and right side

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid
            elif nums[mid] < nums[mid + 1]:
                low = mid + 1
            else:
                high = mid - 1
        
        return -1