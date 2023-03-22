# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :difficult to know if mid is at 0 or at len(nums)
 - 1

# divide array into 2 parts, check which part is unsorted.
# if the array is sorted return low index, else move towards unsorted part

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if not nums:
            return False

        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2
            if (mid == 0 or nums[mid] > nums[mid-1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid

            if mid != 0:

                if nums[mid] < nums[mid - 1]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                low = mid + 1
