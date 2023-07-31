'''
Approach:
Binary search technique can be used here. once the mid is calculated, we need to compare the mid element
 with mid -1 element and mid +1 element and we need to traverse through the larger neighbour since the
 probability of finding the peak is higher in that case
'''

# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while (low <= high):
            mid = low + (high - low)//2
            # if left and right neighbour of the mid is smaller or when we reach the edge case, return mid.
            if (mid == 0 or nums[mid] > nums[mid-1]) and (mid == len(nums)-1  or nums[mid] > nums[mid+1]):
                return mid
            # if the left neighbour of mid is greater, update high
            elif mid != 0 and nums[mid] < nums[mid-1]:
                high = mid - 1
            # if the right neighbour of mid is greater, update low
            else:
                low = mid + 1
        return 444