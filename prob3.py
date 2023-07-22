# Time Complexity : O(log(n))
# Space Complexity :O(1)
# Passed on Leetcode: yes

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = 0
        n = len(nums) - 1
        h = n

        if h == 0:
            return h

        while l <= h:
            mid = l + (h-l)//2
            if (mid == n or nums[mid] > nums[mid+1]) and (mid == 0 or nums[mid] > nums[mid-1]):
                return mid
            
            elif nums[mid] < nums[mid+1]:
                l = mid+1
            else:
                h = mid-1
        

        