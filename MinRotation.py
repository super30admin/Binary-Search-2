# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution(object):
    def findMin(self, nums):
        n = len(nums)

        if n == 1:
            return nums[0]

        if nums is None or n == 0:
            return

        start, end = 0, n - 1

        while start <= end:
            # Find out the middle element
            mid = (start + end) // 2
            # If the middle is less than the end and the mid+1 is less then the mid
            # In a sorted array, mid+1 should be greater than mid
            if mid < end and nums[mid + 1] < nums[mid]:
                return nums[mid + 1]
            # If the mid is greater than the start and the mid-1 is larger than mid
            # mid - 1 should be smaller than mid
            if mid > start and nums[mid - 1] > nums[mid]:
                return nums[mid]
            # If the start is less than mid and mid is larger than end
            # mid should be less than end
            if nums[start] <= nums[mid] and nums[mid] > nums[end]:
                start = mid + 1
            else:
                end = mid - 1

        return nums[start]
