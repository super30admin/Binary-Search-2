#  Time Complexity : O(log (n)) where n is the length of the array.
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

# The smallest element is always on the unsorted side. we check if left of middle is sorted, if true we move towards right of mid. Else we come to left of mid. 

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) -1
        while(low <= high):
            if nums[low] <= nums[high]: # edge case when whole array is sorted. 
                return nums[low]
            mid = (low + high) // 2
            if ((mid == 0 or nums[mid-1] > nums[mid]) and (mid == len(nums)-1 or nums[mid] < nums[mid+1])):
                return nums[mid]
            elif nums[low] <= nums[mid]: # smallest element is always on the unsorted side. 
                low = mid + 1 
            else:
                high = mid -1
        return -1
