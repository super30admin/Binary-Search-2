# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1

        while(low<=high):
            mid = low + (high-low)//2

            if((mid == 0 or nums[mid] > nums[mid-1]) and (mid == len(nums)-1 or nums[mid]>nums[mid+1])):
                return mid
            elif(mid != 0 and nums[mid-1]>nums[mid]):
                high = mid - 1
            else:
                low = mid + 1

        return 99
sc = Solution()
nums = [1,2,3,1]
print(sc.findPeakElement(nums))