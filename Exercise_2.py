# Time Complexity: O(log n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
from typing import List
class Solution:
    def findMin(self, nums: List[int]) -> int:

        # base case for non existent arrays
        if not nums or len(nums)==0:
            return None

        # edge case if only one element exists
        if(len(nums) == 1):
            return nums[0]

        low = 0
        high = len(nums)-1

        while low<=high:
            # if array is sorted and rotated n mod n times, then first element is min
            if nums[low] <= nums[high]:
                return nums[low]

            mid = low + (high-low)//2


            # if mid element is less than its neighbor then mid is the min element
            if (mid == 0 or nums[mid] <= nums[mid-1]) and (mid == len(nums)-1 or nums[mid] <= nums[mid+1]):
                return nums[mid]

            # normal case, one side is unsorted so min element is towards that side, if low is less than mid element then check right side else left side
            # check if low element is less than mid element then left partition is sorted side, check the unsorted side for min element
            if (nums[low] <= nums[mid]):
                low = mid+1
            else:
                high = mid-1

        
            



        