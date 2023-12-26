# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(logn)
# Space Complexity : Average : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    '''
    - use binary search logic to discard half in each iteration with conditions:
    - if peak element is on left of mid, move search part left
    - similarly for right. if mid is peak element, return that.
    '''
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low)//2
            if ((mid == 0) or (nums[mid] > nums[mid - 1])) and ((mid == len(nums) - 1) or (nums[mid] > nums[mid + 1])):
                return mid
            elif ((mid == 0) or (nums[mid] > nums[mid - 1])):
                low = mid+1
            else:
                high = mid-1
        return -1
