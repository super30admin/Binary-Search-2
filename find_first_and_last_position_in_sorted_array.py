'''
Time complexity: O(log n ) + O(log n) = O(log n)
Sapce complexity: O(1)
'''

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        first_pos = self.binarySearchFirst(nums,target)
        if first_pos == -1:
            return [-1,-1]
        else:
            second_pos = self.binarySearchLast(nums,target)
            if second_pos == -1:
                return [first_pos, first_pos]
            else:
                return [first_pos, second_pos]
    def binarySearchFirst(self, nums, target):
        low = 0
        high = len(nums) - 1
        
        while low<=high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                if mid ==0 or nums[mid-1] != nums[mid]:
                    return mid 
                high = mid - 1
            if target > nums[mid]:
                low = mid + 1 
            else:
                high = mid - 1 
        
        return -1 
    
    def binarySearchLast(self, nums, target):
        low = 0
        high = len(nums) - 1
        
        while low<=high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid + 1] != nums[mid]:
                    return mid 
                low = mid + 1 
            elif target > nums[mid]:
                low = mid + 1 
            else:
                high = mid - 1 
        return -1 
    