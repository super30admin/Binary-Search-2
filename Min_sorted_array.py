# Time Complexity : O(logN); 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Binary Search


class Solution:
    def findMin(self, nums: List[int]) -> int:
        s, e = 0, len(nums)-1
        while(s<e):
            mid = (s+e)//2
            if nums[mid] <= nums[e]:
                e = mid
            else:
                s = mid +1
        return nums[s]
        
