'''
Approach:
perform binary search to find the minimum, Assign the minimum initially to any number.
calculate the mid and update mid whenever nums[mid] is less than current minimum.
whenever the left side of the array is sorted and nums[high] is less than nums[mid]; update low, else update high
whenever the right side of the array is sorted and nums[low] is higher than nums[mid]; update high, else update low
'''

# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 0 or not nums:
            return -1

        low = 0
        high = len(nums) - 1
        m = nums[low]

        while(low <= high):
            mid = low + (high-low)//2
            # update the minimum, if nums[mid] is lower than the current minimum
            m = min(m, nums[mid])
            # when the left part of array is sorted and if high is less than mid, then update the low to mid + 1, else high to mid - 1
            if nums[low] < nums[mid]:
                if nums[high] < nums[mid]:
                    low = mid + 1
                else:
                    high = mid - 1
            # when the right part of array is sorted and if low is higher than mid, then update the high to mid - 1, else low to mid + 1
            else:
                if nums[mid] < nums[low]:
                    high = mid - 1
                else:
                    low = mid + 1

        return m

