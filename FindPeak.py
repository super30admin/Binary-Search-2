# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

'''
My approach:
If element at mid is greater than both its neighbors, then it is the peak element.
Otherwise, move towards the higher side as peak will always be there.
'''
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high-low)//2
            
            # are we at the peak
            if (mid == 0 or nums[mid-1] < nums[mid]) and (mid == len(nums)-1 or nums[mid+1] < nums[mid]):
                return mid

            # find the higher side and move towards it
            if nums[mid-1] > nums[mid+1]:
                # left is higher
                high = mid -1
            else:
                low = mid + 1

        return -1
        
