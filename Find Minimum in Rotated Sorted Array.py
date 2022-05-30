"""
Time Complexity : O(Log n)
Space Complexity : O(1)
"""

class Solution:
    def findMin(self, nums: List[int]) -> int:
        l, r = 0 , len(nums)-1
        
        if nums[l] <= nums[r]:
            return nums[l]
        
        while l <= r:
            mid = l + (r - l) // 2
            if nums[mid] > nums[mid+1] :
                return nums[mid + 1]
            
            elif nums[l] > nums[mid]:
                r = mid - 1
            
            else:
                l = mid + 1
