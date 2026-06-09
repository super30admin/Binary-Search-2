# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes 
# Any problem you faced while coding this : No



class Solution(object):
    def findPeakElement(self, nums):
        n = len(nums)
        low, high = 0, n - 1

        while low <= high:
            mid = low + (high - low) // 2

            if (mid == 0 or nums[mid] > nums[mid - 1]) and \
               (mid == n - 1 or nums[mid] > nums[mid + 1]):
                return mid

            elif mid < n - 1 and nums[mid + 1] > nums[mid]:
                low = mid + 1

            else:
                high = mid - 1

        return -1