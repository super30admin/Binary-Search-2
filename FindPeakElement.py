'''
In this problem to find the peak element, we compare the mid with either of its neighbors and move our pointer towards higher neighbour direction
There will always be a peak element if we move our pointer towards the higher element direction.

In the first condition we check if mid itself is the peak:
by checking mid is the last elemnt or mid element is greater than its right neighbour
and mid the first elemnt or mid is greater than its left neighbour 

If mid is not the peak element, we check which direction should we move the pointer to find a peak.
Since there will always be a peak element we would never reach the last return statement.
'''
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        low = 0
        high = n-1
        while low <= high:
            mid = (low+high)//2
            # check if mid is our peek element or not
            # (mid is not our last elemnt or mid greater than mid+1) and (mid is zero or mid is greater than mid-1)
            if (mid == n-1 or nums[mid] > nums[mid+1]) and (mid is 0 or nums[mid] > nums[mid-1]):
                # mid is peak
                return mid
            # check if mid-1 element is less than mid and mid is greater than zero
            elif mid > 0 and nums[mid-1] > nums[mid]:
                # we go left side of the array
                high = mid - 1
            else:
                # we go to right side of the array
                low = mid+1
        # we will reach the peek elemnt for sure so we will not reach this return statement
        return 123456

'''
Time Complexity : O(log n)
Since we are performing binray serach for finding the element

Space Complexity: O(1)
We did not use any extra space.

'''
        