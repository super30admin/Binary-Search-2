# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1

        while(low<=high):
            if(nums[low] <= nums[high]): return nums[low]

            mid = low + (high-low)//2

            if(mid != 0 and nums[mid] < nums[mid-1]):
                return nums[mid]
            elif(nums[low]<=nums[mid]):
                low = mid +1
            else:
                high = mid -1
    
        return 99

sc = Solution()
nums = [3,4,5,1,2]
print(sc.findMin(nums))


        