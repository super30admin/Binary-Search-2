class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int

        Time Complexity: O(log n) since we are using binary search
        Space Complexity: O(1) - constant space is used

        Did this code successfully run on Leetcode: Yes
    
        Any problem you faced while coding this: No
    
        Intuition: We have to return ANY one index where the element is greater than it's neighbors.
                   We can do a search in any part of the array since any sub-array will have a peak element.
                   So it lends itself to binary search. 
                   If a number is > element on right,  then peak is on the left. 
                   If a number i < element on right, then peak is on the right.
        """
        left, right = 0, len(nums)-1
        while left < right:
            mid = left + (right-left)/2
            # peak is on the left side - when we shrink the right, we move left
            if nums[mid] > nums[mid+1]:
                right = mid
            # peak is on the right side - when we move the left, we move right   
            else:
                left = mid + 1
        return left
