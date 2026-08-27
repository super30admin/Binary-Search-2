#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        low = 0
        high = n - 1
        while (low <= high):
            if (nums[low]<=nums[high]):
                return nums[low]
            mid = low + (high - low)//2
            if mid < n- 1 and nums[mid] > nums[mid + 1]:
                 return nums[mid+1]
            elif mid > 0 and nums[mid] < nums[mid - 1]:
                 return nums[mid]
            elif (nums[low] <= nums[mid]):
                 low = mid + 1
            else:
                  high = mid - 1
        return -1
