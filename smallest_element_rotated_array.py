# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""To find the smallest element in a rotated sorted array, we can use binary search. 
We do this by comparing the mid element with the left and right elements. If the mid 
element is smaller than the left element, then the mid element is the smallest element. 
If the mid element is greater than the right element, then the smallest element is in 
the right half of the array. If the mid element is greater than the left element, then 
the smallest element is in the left half of the array."""

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        
        left, right = 0, len(nums)-1
        while left <= right:
            mid = (left + right)//2

            if nums[mid] < nums[mid-1]:
                return nums[mid]
            elif nums[mid] > nums[mid+1]:
                return nums[mid+1]
            elif nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid - 1