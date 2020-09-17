# Time Complexity: 

class Solution:
    
    def find_upper_range(self, index):
        
        curr_index = index
        for i in range(index + 1, len(self.nums)):
            if self.nums[index] == self.nums[i]:
                curr_index = i
            else:
                break
        return curr_index
    
    def find_lower_range(self, index):
        curr_index = index
        for i in range(index - 1 , -1, -1):
            if self.nums[index] == self.nums[i]:
                curr_index = i
            else:
                break
        return curr_index
    
    def binary_search(self, left, right):
        
        if left > right:
            return -1
        
        mid = left + (right - left) // 2
        
        if self.nums[mid] == self.target:
            return mid
        
        if self.target < self.nums[mid]:
            return self.binary_search(left, mid - 1)
        else:
            return self.binary_search(mid + 1, right)
        
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        self.nums = nums
        self.target = target
        if len(nums) == 0:
            return [-1, -1]
        
        index = self.binary_search(0, len(nums) - 1)
        
        if index == -1:
            return [-1,-1]
        
        return [self.find_lower_range(index), self.find_upper_range(index)]
        
        