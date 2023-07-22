# Time Complexity : O(log(n))
# Space Complexity :O(1)
# Passed on Leetcode: yes
# Approch: Apply Binary search, find the mid element, 
# if target is mid element the travers left and right from the mid to find the first and last occurance

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        l = 0
        r = len(nums)-1
        op = [-1,-1]
        while l <= r:
            mid = (l+r)//2
            if target == nums[mid]:
                i = j = mid
                while i >= 0 and nums[i] == target:
                    op[0] = i
                    i -= 1
                while j < len(nums) and nums[j] == target:
                    op[1] = j
                    j += 1
            if target < nums[mid]:
                r = mid-1
            else:
                l = mid+1
                
        return op