# Time Complexity : O(log n)   # because we use binary search to cut the array in half each step
# Space Complexity : O(1)      # only variables l, r, and mid are used
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Handling edge cases when mid is at index 0 or at the last index

# Your code here along with comments explaining your approach in three sentences only:
# I used binary search to find an index where nums[mid] is greater than both neighbors (a peak).
# If the right neighbor is bigger, then the peak must be on the right side; otherwise, it is on the left side.
# By moving the search boundaries accordingly, I guarantee finding a peak in O(log n) time.

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = 0
        r = len(nums) - 1

        while l <= r:
            mid = (l + r) // 2   # calculate middle index

            # check if nums[mid] is greater than both neighbors (or at boundaries)
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid  # peak element index found

            # if the right neighbor is bigger, then a peak must exist on the right side
            elif (mid < len(nums) - 1) and (nums[mid + 1] > nums[mid]):
                l = mid + 1
            # otherwise, look to the left side
            else:
                r = mid - 1

        return -1 
