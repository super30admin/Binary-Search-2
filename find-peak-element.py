# time complexity: O((n)) where n is the number of elements in the array
# space complexity: O(1) as no additional space used. Only hi, lo, mid ptrs introduced
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        low = 0
        high = n-1

        while low <= high:

            mid = (low+high)//2

            # if there is only one element in the array, that is the peak
            if len(nums) == 1:
                return 0

            # if mid is at 0th idx & it is greater than 1st idx, that is the peak
            if (mid == 0) and (nums[mid] > nums[mid+1]):
                return mid

            # if mid is at the last idx & its greater than # at mid-1 then that is the peak
            elif mid == n-1 and nums[mid] > nums[mid-1]:
                return mid

            # if mid is greater than its left and right neighbor, that is the peak
            elif nums[mid] > nums[mid-1] and nums[mid] > nums[mid+1]:
                return mid

            # if mid+1 element is greater than # at mid, then move right
            elif nums[mid+1] > nums[mid]:
                low = mid + 1

            # else move left
            else:
                high = mid - 1

        # if there is no peak, return -1 idx where nums[-1] is -(infinity)  as per question
        return -1
