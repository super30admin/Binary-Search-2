# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach in three sentences only


class Solution:
    def findMin(self, nums: List[int]) -> int:
        low,high=0,len(nums)-1
        while low<=high:
            # If elements are sorted first element will be less than last element
            if nums[low] <= nums[high]:
                return nums[low] # so returning the first element, since its sorted.
            mid = low+(high-low)//2 # preventing overflow
            #Handling if mid is first or last index returning the element
            #checking if mid element is less than its neighbor
            if (mid == 0 or nums[mid] < nums[mid-1]) and (mid == high or nums[mid] < nums[mid+1]):
                return nums[mid]
            #checking if left side is sorted, so that we can find the minimum on the right side
            elif nums[low] <= nums[mid]:
                low = mid+1 # shift to right side
            else: # shift to left side
                high = mid-1
        return 1234 # we will never reach this so returning random number