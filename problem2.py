#Time Complexity O(log(N))
#Space Complexity O(log(N))
#Passed Leetcode

class Solution:
    
    def search(self, left, right):
        mid = left + (right - left) // 2
        if (self.arr[mid - 1] >= self.arr[mid]):
            return self.arr[mid]
            
        elif self.arr[0] <= self.arr[mid]:
            return self.search(mid + 1, right)
        
        else:
            return self.search(left, mid)
        
    
    def findMin(self, nums: List[int]) -> int:
        
        self.arr = nums
        if self.arr[0] < self.arr[-1]:
            return self.arr[0]
        return self.search(0, len(nums) - 1)
        