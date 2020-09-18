# Ran on Leetcode - No



class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        left = 0
        right = len(nums) - 1
        
        while left <= right:
            
            mid = left + (right-left)//2
            
            if nums[mid] >= nums[left] and nums[mid] <= nums[right]:
                
                return nums[left]
            
            if nums[mid] >= nums[left]:
                # left is sorted
                left = mid 
                
            elif nums[mid] <= nums[right]:
                right = mid 
            